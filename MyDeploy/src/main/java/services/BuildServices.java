package services;

import exceptions.RuntimeScriptException;
import gui.TelaInicio;

import java.io.IOException;
import java.util.ArrayList;

import model.RemoteShell;
import model.Script;
import util.PkgDeployConstants;

public class BuildServices {

	private String serverToDeploy;
	private boolean someJavaSelected;
	private String folderToPkg;
	private String folderToDeploy;
	private ArrayList<String> pkgs;
	private ArrayList<Script> commands;

	public BuildServices(String serverToDeploy) {
		super();
		this.serverToDeploy = serverToDeploy;
		this.setFolders();
		pkgs = new ArrayList<String>();
		commands = new ArrayList<Script>();
	}
	
	public void doRestart(String restart, TelaInicio telaInicio) throws IOException, RuntimeScriptException{
		RemoteShell shell = new RemoteShell();
		Script restartScript = new Script("Doing a "+restart, folderToDeploy+restart, getServerToDeploy());
		shell.executeCommand(restartScript, this, telaInicio);
	}

	public void executeBuildAndDeployScripts(ArrayList<String> pkgs, TelaInicio telaInicio)
			throws IOException, RuntimeScriptException {
		this.pkgs = pkgs;
		getBuildScripts();
		getPrepareDeploy();
		getDeployScripts();
		RemoteShell shell = new RemoteShell(getServerToBuild());
		for(Script command: commands){
			shell.executeCommand(command, this, telaInicio);
		}
	}

	public void getBuildScripts() {
		commands.add(new Script("get_code from SVN", folderToPkg
				+ PkgDeployConstants.SCRIPT_GET_CODE, getServerToBuild()));
		if (someJavaSelected || pkgs.contains("BPM")) {
			commands.add(new Script("build Java by Maven", folderToPkg
					+ PkgDeployConstants.SCRIPT_BUILD_JAVA, getServerToBuild()));

			if (someJavaSelected) {
				commands.add(new Script("Pkg All Java pkgs", folderToPkg
						+ PkgDeployConstants.SCRIPT_PKG_ALL_JAVA, getServerToBuild()));
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

	public void getDeployScripts() {
		commands.add(new Script("Looking the number pkg", folderToDeploy+PkgDeployConstants.CMD_CAT_OM, getServerToDeploy()));
		if (pkgs.contains("MOD"))
			commands.add(new Script("Deploy of Modules", folderToDeploy
					+ PkgDeployConstants.SCRIPT_DEPLOY_MOD, getServerToDeploy()));
		if (pkgs.contains("EJB"))
			commands.add(new Script("Deploy of EJBs", folderToDeploy
					+ PkgDeployConstants.SCRIPT_DEPLOY_EJB, getServerToDeploy()));
		if (pkgs.contains("GUI"))
			commands.add(new Script("Deploy of GUI", folderToDeploy
					+ PkgDeployConstants.SCRIPT_DEPLOY_GUI, getServerToDeploy()));
		if (pkgs.contains("WS"))
			commands.add(new Script("Deploy of Web Services", folderToDeploy
					+ PkgDeployConstants.SCRIPT_DEPLOY_WS, getServerToDeploy()));
		if (pkgs.contains("BPM"))
			commands.add(new Script("Deploy of BPMs", folderToDeploy
					+ PkgDeployConstants.SCRIPT_DEPLOY_BPM, getServerToDeploy()));
		if (pkgs.contains("AGE"))
			commands.add(new Script("Deploy of Agents", folderToDeploy
					+ PkgDeployConstants.SCRIPT_DEPLOY_AGE, getServerToDeploy()));
		for (String pkg : pkgs) {
			if (pkg.contains("Delta")) {
				String deltaCommand = pkg.substring(6);
				commands.add(new Script("Deploy Delta" + deltaCommand,
						folderToDeploy + getCorrectDeltaScript(deltaCommand)
								+ deltaCommand + ";", getServerToDeploy()));
			}
		}
		commands.add(new Script("Doing a full restart", folderToDeploy
				+ PkgDeployConstants.SCRIPT_FULL_RESTART, getServerToDeploy()));
	}

	public void getPrepareDeploy() {
		if (serverToDeploy.equals(PkgDeployConstants.MACHINE_DEV1)
				|| serverToDeploy.equals(PkgDeployConstants.MACHINE_DEV2)) {
			commands.add(new Script("Copy_local",
					PkgDeployConstants.SCRIPT_COPYLOCAL, getServerToBuild()));
		} else {
			commands.add(new Script("Creating the .tar. for all pkg in deploy machine",
					folderToPkg+PkgDeployConstants.SCRIPT_PKG_ALL,getServerToBuild()));
			commands.add(new Script("Creating a pkg folder in deploy machine", folderToDeploy+PkgDeployConstants.SCRIPT_CREATE_PKG_FOLDER, getServerToDeploy()));
			commands.add(new Script(
					"Creating the .tar file, transfering and untar inside of pkg in deploy machine",
					serverToDeploy.equals(PkgDeployConstants.MACHINE_ST1) ? folderToPkg+PkgDeployConstants.CMD_ST1_PREPARE_PKG_FOLDER
							: folderToPkg+PkgDeployConstants.CMD_ST2_PREPARE_PKG_FOLDER, getServerToBuild()));
		}
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
	
	private String getCorrectDeltaScript(String number){
		if(number.startsWith("2121")){
			return PkgDeployConstants.SCRIPT_DEPLOY_SQL_P212_1;
		}else if(number.startsWith("2122")){
			return PkgDeployConstants.SCRIPT_DEPLOY_SQL_P212_2;
		}else{
			return PkgDeployConstants.SCRIPT_DEPLOY_SQL;
		}
	}

	public void sendOutputToTela(final TelaInicio telaInicio,
			final String output) {
		telaInicio.setOutPutInTextArea(output);
	}
	
	public void sendStatusCode(final TelaInicio telaInicio, final String status){
		telaInicio.setStatusCode(status);
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
