package services;

import gui.TelaInicio;

import java.util.ArrayList;

import model.Script;
import util.PkgDeployConstants;

public class BuildServices {

	private String serverToDeploy;
	private boolean someJavaSelected;
	private String folderToPkg;
	private String folderToDeploy;

	public BuildServices(String serverToDeploy, boolean someJavaSelected) {
		super();
		this.serverToDeploy = serverToDeploy;
		this.someJavaSelected = someJavaSelected;
		this.setFolders();
	}

	/*
	 * public void executeBuildAndDeployScripts(ArrayList<String> pkgs) throws
	 * IOException, RuntimeScriptException{ executeBuildScripts(pkgs); }
	 */

	public ArrayList<Script> getBuildScripts(final ArrayList<String> pkgs) {
		ArrayList<Script> buildCommands = new ArrayList<Script>();
		buildCommands.add(new Script("get_code from SVN", folderToPkg
				+ PkgDeployConstants.SCRIPT_GET_CODE));
		if (someJavaSelected || pkgs.contains("BPM")) {
			buildCommands.add(new Script("build Java by Maven", folderToPkg
					+ PkgDeployConstants.SCRIPT_BUILD_JAVA));

			if (someJavaSelected) {
				buildCommands.add(new Script("Pkg All Java pkgs", folderToPkg
						+ PkgDeployConstants.SCRIPT_PKG_ALL_JAVA));
			}
			if (pkgs.contains("BPM")) {
				buildCommands.add(new Script("pkg BPM", folderToPkg
						+ PkgDeployConstants.SCRIPT_PKG_BPM));
			}
		}

		for (String pkg : pkgs) {
			if (pkg.contains("Delta")) {
				String deltaCommand = pkg.substring(6);
				buildCommands.add(new Script("Delta" + deltaCommand,
						folderToPkg + PkgDeployConstants.SCRIPT_PKG_SQL_DELTA
								+ deltaCommand + ";"));
			}
		}

		return buildCommands;

	}

	/*
	 * public ArrayList<Script> getDeployScripts(final ArrayList<String> pkgs){
	 * 
	 * }
	 */

	public ArrayList<Script> getPrepareDeploy(ArrayList<Script> commands) {
		if (serverToDeploy.equals(PkgDeployConstants.MACHINE_DEV1)
				|| serverToDeploy.equals(PkgDeployConstants.MACHINE_DEV2)) {
			commands.add(new Script("Copy_local",
					PkgDeployConstants.SCRIPT_COPYLOCAL));
		} else {
			commands.add(new Script("To copy all pkgs to deploy machine",
					serverToDeploy.equals(PkgDeployConstants.MACHINE_DEV1) ? 
							PkgDeployConstants.CMD_ST1_PREPARE_PKG_FOLDER:
							PkgDeployConstants.CMD_ST1_PREPARE_PKG_FOLDER));
		}
		return commands;
	}

	public String getServerToBuild() {
		if (serverToDeploy.equals(PkgDeployConstants.MACHINE_ST1)
				|| serverToDeploy.equals(PkgDeployConstants.MACHINE_DEV1)) {
			return PkgDeployConstants.MACHINE_DEV1;
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

	public void sendOutputToTela(final TelaInicio telaInicio,
			final String output) {
		telaInicio.setOutPutInTextArea(output);
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

}
