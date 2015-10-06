package services;

import exceptions.RuntimeScriptException;
import gui.TelaInicio;

import java.io.IOException;
import java.util.ArrayList;

import model.RemoteShell;
import model.Script;
import util.FileUtils;
import util.PkgDeployConstants;

public class BuildServices {

	private String serverToDeploy;
	private boolean someJavaSelected;
	private String folderToPkg;
	private String folderToDeploy;
	private ArrayList<String> pkgs;
	private ArrayList<Script> commands;
	private String flag;

	public BuildServices(String serverToDeploy) {
		super();
		this.serverToDeploy = serverToDeploy;
		this.setFolders();
		pkgs = new ArrayList<String>();
		commands = new ArrayList<Script>();
	}

	// Abortado porque aparentemente o cliente unix não consegue detachar do
	// start_jboss e start_agents
	/*
	 * public void doRestart(String restart, TelaInicio telaInicio) throws
	 * IOException, RuntimeScriptException { if (restart.equals("full")) {
	 * setFullRestartScripts(); } else if (restart.equals("agents")) {
	 * commands.add(new Script("Doing the Agents restart", folderToDeploy +
	 * PkgDeployConstants.SCRIPT_RESTART_AGENTS, getServerToDeploy())); } else {
	 * commands.add(new Script("Doing the JBOSS restart",
	 * PkgDeployConstants.SCRIPT_RESTART_JBOSS, getServerToDeploy())); }
	 * executeAllCommands(telaInicio);
	 * 
	 * }
	 */

	public boolean generateFQAPkg(final ArrayList<String> pkgs,
			final TelaInicio telaInicio, final boolean isSomeJavaSelected,
			final String fqaPkg) throws Exception {
		this.flag = "fqa";
		boolean isGenerated = false;
		RemoteShell shell = new RemoteShell(getServerToBuild());
		generateBuildScripts(pkgs, isSomeJavaSelected);
		getPrepareDeployST();
		executeAllCommands(telaInicio);
		FileUtils.createLocalPkgStructure(fqaPkg, this, telaInicio);
		shell.downloadFileToFqaPkg(fqaPkg);
		isGenerated = FileUtils.isDiretorioVazio(fqaPkg, this, telaInicio);
		return isGenerated;
	}

	public boolean executeBuildAndDeployScripts(ArrayList<String> pkgs,
			TelaInicio telaInicio, boolean isSomeJavaSelected)
			throws IOException, RuntimeScriptException {
		flag = "deploy";
		generateBuildScripts(pkgs, isSomeJavaSelected);
		getPrepareDeploy();
		getDeployScripts();
		boolean b = executeAllCommands(telaInicio);
		return b;
	}

	private void generateBuildScripts(ArrayList<String> pkgs,
			boolean isSomeJavaSelected) {
		this.pkgs = pkgs;
		this.someJavaSelected = isSomeJavaSelected;
		getBuildScripts();
	}

	private void getBuildScripts() {
		commands.add(new Script("get_code from SVN", folderToPkg
				+ PkgDeployConstants.SCRIPT_GET_CODE, getServerToBuild()));
		if (someJavaSelected || pkgs.contains("BPM")) {
			commands.add(new Script("build Java by Maven", folderToPkg
					+ PkgDeployConstants.SCRIPT_BUILD_JAVA, getServerToBuild()));

			if (pkgs.contains("MOD")) {
				commands.add(new Script("pkg MOD", folderToPkg
						+ PkgDeployConstants.SCRIPT_PKG_ALL_JAVA + "MOD",
						getServerToBuild()));
			}
			if (pkgs.contains("EJB")) {
				commands.add(new Script("pkg EJB", folderToPkg
						+ PkgDeployConstants.SCRIPT_PKG_ALL_JAVA + "EJB",
						getServerToBuild()));
			}
			if (pkgs.contains("GUI")) {
				commands.add(new Script("pkg GUI", folderToPkg
						+ PkgDeployConstants.SCRIPT_PKG_ALL_JAVA + "GUI",
						getServerToBuild()));
			}
			if (pkgs.contains("WS")) {
				commands.add(new Script("pkg WSB", folderToPkg
						+ PkgDeployConstants.SCRIPT_PKG_ALL_JAVA + "WSB",
						getServerToBuild()));
			}
			if (pkgs.contains("AGE")) {
				commands.add(new Script("pkg AGE", folderToPkg
						+ PkgDeployConstants.SCRIPT_PKG_ALL_JAVA + "AGE",
						getServerToBuild()));
			}
			if (pkgs.contains("BPM")) {
				commands.add(new Script("pkg BPM", folderToPkg
						+ PkgDeployConstants.SCRIPT_PKG_BPM, getServerToBuild()));
			}
		}

		for (String pkg : pkgs) {
			if (pkg.contains("Delta")) {
				String deltaCommand = pkg.substring(6);
				commands.add(new Script("Delta" + deltaCommand, folderToPkg
						+ PkgDeployConstants.SCRIPT_PKG_SQL_DELTA
						+ deltaCommand + ";", getServerToBuild()));
			}
		}

	}

	private void getDeployScripts() {
		commands.add(new Script("Looking the number pkg", getCorrectPkgDeploy()
				+ PkgDeployConstants.CMD_CAT_OM, getServerToDeploy()));
		if (pkgs.contains("MOD")) {
			commands.add(new Script("MOD - Deploy of Modules", folderToDeploy
					+ PkgDeployConstants.SCRIPT_DEPLOY_MOD, getServerToDeploy()));
		}

		if (pkgs.contains("EJB")) {
			commands.add(new Script("EJB - Deploy of EJBs", folderToDeploy
					+ PkgDeployConstants.SCRIPT_DEPLOY_EJB, getServerToDeploy()));
		}

		if (pkgs.contains("GUI")) {
			commands.add(new Script("GUI - Deploy of GUI", folderToDeploy
					+ PkgDeployConstants.SCRIPT_DEPLOY_GUI, getServerToDeploy()));
		}

		if (pkgs.contains("WS")) {
			commands.add(new Script("WSB - Deploy of Web Services",
					folderToDeploy + PkgDeployConstants.SCRIPT_DEPLOY_WS,
					getServerToDeploy()));
		}

		if (pkgs.contains("BPM")) {
			commands.add(new Script("BPM - Deploy of BPMs", folderToDeploy
					+ PkgDeployConstants.SCRIPT_DEPLOY_BPM, getServerToDeploy()));
		}

		if (pkgs.contains("AGE")) {
			commands.add(new Script("AGE - Deploy of Agents", folderToDeploy
					+ PkgDeployConstants.SCRIPT_DEPLOY_AGE, getServerToDeploy()));
		}

		for (String pkg : pkgs) {
			if (pkg.contains("Delta")) {
				String deltaCommand = pkg.substring(6);
				commands.add(new Script("SQL-Delta" + deltaCommand
						+ " - Deploy Delta" + deltaCommand, folderToDeploy
						+ getCorrectDeltaScript(deltaCommand) + deltaCommand
						+ ";", getServerToDeploy()));
			}
		}

		// setFullRestartScripts();

	}

	private void getPrepareDeploy() {
		if (!serverToDeploy.equals(PkgDeployConstants.MACHINE_ST2)) {
			if (serverToDeploy.equals(PkgDeployConstants.MACHINE_ST1)) {
				this.getPrepareDeployST();
			}
			commands.add(new Script(
					"Copy_local",
					!getServerToDeploy().equals(PkgDeployConstants.MACHINE_ST1) ? PkgDeployConstants.SCRIPT_COPYLOCAL
							: PkgDeployConstants.SCRIPT_COPYLOCAL_ST,
					getServerToBuild()));

		} else {
			this.getPrepareDeployST();
			commands.add(new Script(
					"Transfering inside of pkg in deploy machine",
					serverToDeploy.equals(PkgDeployConstants.MACHINE_ST1) ? folderToPkg
							+ PkgDeployConstants.CMD_ST1_CPY_TAR_TO_PKG
							: folderToPkg
									+ PkgDeployConstants.CMD_ST2_CPY_TAR_TO_PKG,
					getServerToBuild()));
			commands.add(new Script("Untar the OM-*.tar",
					PkgDeployConstants.CD_FOLDER_PKG_ST
							+ PkgDeployConstants.CMD_UNTAR_OM_TAR,
					getServerToDeploy()));
		}
	}

	private void getPrepareDeployST() {
		commands.add(new Script(
				"Creating the .tar. for all pkg in deploy machine", folderToPkg
						+ PkgDeployConstants.SCRIPT_PKG_ALL, getServerToBuild()));
		// commands.add(new Script("Versioning this package", folderToPkg
		// + PkgDeployConstants.SCRIPT_COMMIT_PKG_SVN,
		// getServerToBuild()));
		if (flag.equals("deploy")) {
			commands.add(new Script("Creating a pkg folder in deploy machine",
					folderToDeploy
							+ PkgDeployConstants.SCRIPT_CREATE_PKG_FOLDER,
					getServerToDeploy()));
			
		}else if(flag.equals("fqa")){
			commands.add(new Script("Deleting OM-*.tar file", folderToPkg
					 + PkgDeployConstants.CMD_DEL_BIG_TAR,
					 getServerToBuild()));
		}
	}

	private boolean executeAllCommands(TelaInicio telaInicio) {
		boolean rodou = false;
		try {
			for (Script command : commands) {
				RemoteShell shell = new RemoteShell();
				rodou = shell.executeCommand(command, this, telaInicio);
				System.out.println();
			}

		} catch (IOException e) {
			rodou = false;
			e.printStackTrace();
		} catch (RuntimeScriptException e) {
			rodou = false;
			e.printStackTrace();
		} catch (Exception e) {
			rodou = false;
			e.printStackTrace();
		}
		return rodou;
	}

	public String getServerToBuild() {
		if (serverToDeploy.equals(PkgDeployConstants.MACHINE_DEV1)) {
			return PkgDeployConstants.MACHINE_DEV1;
		} else if (serverToDeploy.equals(PkgDeployConstants.MACHINE_ST1)) {
			return PkgDeployConstants.MACHINE_ST1;
		} else {
			return PkgDeployConstants.MACHINE_DEV2;
		}

	}

	private void setFolders() {
		if (serverToDeploy.equals(PkgDeployConstants.MACHINE_DEV1)
				|| serverToDeploy.equals(PkgDeployConstants.MACHINE_DEV2)) {
			folderToPkg = PkgDeployConstants.CD_OFFICIAL_BUILD_SCRIPTS;
			folderToDeploy = PkgDeployConstants.CD_FOLDER_ASST_DEPLOY_SCRIPTS;
		} else {
			folderToPkg = PkgDeployConstants.CD_STABLE_BUILD_SCRIPTS;
			folderToDeploy = PkgDeployConstants.CD_FOLDER_ST_DEPLOY_SCRIPTS;
		}
	}

	private String getCorrectPkgDeploy() {
		if (serverToDeploy.equals(PkgDeployConstants.MACHINE_DEV1)
				|| serverToDeploy.equals(PkgDeployConstants.MACHINE_DEV2)) {
			return PkgDeployConstants.CD_FOLDER_PKG_ASST;
		} else {
			return PkgDeployConstants.CD_FOLDER_PKG_ST;
		}
	}

	private String getCorrectDeltaScript(String number) {
		if (number.startsWith("2121")) {
			return PkgDeployConstants.SCRIPT_DEPLOY_SQL_P212_1;
		} else if (number.startsWith("2122")) {
			return PkgDeployConstants.SCRIPT_DEPLOY_SQL_P212_2;
		} else if (number.startsWith("2123")) {
			return PkgDeployConstants.SCRIPT_DEPLOY_SQL_P212_3;
		} else if (number.startsWith("22")) {
			return PkgDeployConstants.SCRIPT_DEPLOY_SQL_P22;
		} else {
			return PkgDeployConstants.SCRIPT_DEPLOY_SQL;
		}
	}

	/*
	 * private void setFullRestartScripts() { commands.add(new
	 * Script("Doing the JBOSS restart",
	 * PkgDeployConstants.SCRIPT_RESTART_JBOSS, getServerToDeploy()));
	 * commands.add(new Script("Doing the Agents restart", folderToDeploy +
	 * PkgDeployConstants.SCRIPT_RESTART_AGENTS, getServerToDeploy())); }
	 */

	public void sendOutputToTela(final TelaInicio telaInicio,
			final String output) {
		telaInicio.setOutPutInTextArea(output);
	}

	public void sendStatusCode(final TelaInicio telaInicio, final String status) {
		telaInicio.setStatusCode(status);
	}

	public void sendInfoToDialog(TelaInicio telaInicio, String info) {
		telaInicio.showInfoInDialog(info);
	}

	public String getServerToDeploy() {
		return serverToDeploy;
	}

	public void setServerToDeploy(String serverToDeploy) {
		this.serverToDeploy = serverToDeploy;
	}

	public boolean isSomeJavaSelected() {
		return someJavaSelected;
	}

	public void setSomeJavaSelected(boolean someJavaSelected) {
		this.someJavaSelected = someJavaSelected;
	}

	public String getFolderToPkg() {
		return folderToPkg;
	}

	public String getFolderToDeploy() {
		return folderToDeploy;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
