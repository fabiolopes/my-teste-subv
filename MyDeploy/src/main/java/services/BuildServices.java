package services;

import gui.TelaOutPut;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;

import util.PkgDeployConstants;

public class BuildServices {
	
	private String serverToBuild;
	private String serverToDeploy;
	private boolean someJavaSelected;
	
	public BuildServices(String serverToBuild, boolean someJavaSelected) {
		super();
		this.serverToBuild = serverToBuild;
		this.someJavaSelected = someJavaSelected;
	}
	
	public void executeBuildAndDeployScripts(ArrayList<String> pkgs){
		executeBuildScripts(pkgs);
	}
	
	public void executeBuildScripts(final ArrayList<String> pkgs){
		TelaOutPut out = new TelaOutPut();
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
	}

	public String getServerToBuild() {
		return serverToBuild;
	}

	public void setServerToBuild(String serverToBuild) {
		this.serverToBuild = serverToBuild;
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

