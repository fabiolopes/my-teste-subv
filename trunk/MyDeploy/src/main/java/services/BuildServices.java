package services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.RemoteShell;
import model.Script;
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
	
	/*public void executeBuildAndDeployScripts(ArrayList<String> pkgs) throws IOException, RuntimeScriptException{
		executeBuildScripts(pkgs);
	}*/
	
	public ArrayList<Script> getBuildScripts(final ArrayList<String> pkgs){
		ArrayList<Script> buildCommands = new ArrayList<Script>();
		buildCommands.add(new Script("get_code from SVN", PkgDeployConstants.SCRIPT_GET_CODE));
		if(someJavaSelected || pkgs.contains("BPM")){
			buildCommands.add(new Script("build Java by Maven", PkgDeployConstants.SCRIPT_BUILD_JAVA));
			
			if (someJavaSelected){
				buildCommands.add(new Script("Pkg All Java pkgs", PkgDeployConstants.SCRIPT_PKG_ALL_JAVA));
			}
			if(pkgs.contains("BPM")){
				buildCommands.add(new Script("pkg BPM", PkgDeployConstants.SCRIPT_PKG_BPM));
			}
		}
		
		for(String pkg:pkgs){
			if(pkg.contains("Delta")){
				String deltaCommand = pkg.substring(6);
				buildCommands.add(new Script("Delta"+deltaCommand, PkgDeployConstants.SCRIPT_PKG_SQL_DELTA+deltaCommand+";"));
			}
		}
		
		return buildCommands;
		
	}
	
	/*public ArrayList<Script> getDeployScripts(final ArrayList<String> pkgs){
		
	}*/

	
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

