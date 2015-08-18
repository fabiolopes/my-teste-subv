package services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.RemoteShell;
import util.PkgDeployConstants;
import exceptions.RuntimeScriptException;

public class BuildServices {
	
	private String serverToDeploy;
	private boolean someJavaSelected;
	
	public BuildServices(String serverToDeploy, boolean someJavaSelected) {
		super();
		this.serverToDeploy = serverToDeploy;
		this.someJavaSelected = someJavaSelected;
	}
	
	public void executeBuildAndDeployScripts(ArrayList<String> pkgs) throws IOException, RuntimeScriptException{
		executeBuildScripts(pkgs);
	}
	
	public void executeBuildScripts(final ArrayList<String> pkgs) throws IOException, RuntimeScriptException{
		List<String> buildCommands = new ArrayList<String>();
		buildCommands.add(PkgDeployConstants.SCRIPT_GET_CODE);
		if(someJavaSelected || pkgs.contains("BPM")){
			buildCommands.add(PkgDeployConstants.SCRIPT_BUILD_JAVA);
			
			if (someJavaSelected){
				buildCommands.add(PkgDeployConstants.SCRIPT_PKG_ALL_JAVA);
			}
			if(pkgs.contains("BPM")){
				buildCommands.add(PkgDeployConstants.SCRIPT_PKG_BPM);
			}
		}
		
		for(String pkg:pkgs){
			if(pkg.contains("Delta")){
				String deltaCommand = pkg.substring(6);
				buildCommands.add(PkgDeployConstants.SCRIPT_PKG_SQL_DELTA+deltaCommand+";");
			}
		}
		
		System.out.println(buildCommands.toString());
		RemoteShell shell = new RemoteShell(getServerToBuild());
		for(String comm: buildCommands){
			shell.executeCommand(comm);
		}
	}

	
	public String getServerToBuild(){
		if(serverToDeploy.equals(PkgDeployConstants.MACHINE_ST1)){
			return PkgDeployConstants.MACHINE_DEV1;
		}else if(serverToDeploy.equals(PkgDeployConstants.MACHINE_ST2)){
			return PkgDeployConstants.MACHINE_DEV2;
		}
		
		return null;
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

	
}

