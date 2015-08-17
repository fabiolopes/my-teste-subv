package model;

import java.io.IOException;


import util.PkgDeployConstants;

public class TesteConexao {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		RemoteShell shell = new RemoteShell("10.43.1.109");
		try {
			/*shell.executeCommand("cd /oradata/om/official_build_scripts; ./copyLocal.sh ../pkg_dev;" +
					"cd ../deploy_dev_scripts; ./deploySQLp22.sh 2122012;");*/
			shell.executeCommand(PkgDeployConstants.SCRIPT_BUILD_JAVA);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
