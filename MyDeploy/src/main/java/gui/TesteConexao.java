package gui;

import java.io.IOException;

import model.MyRemoteShell;

import exceptions.RuntimeScriptException;


import util.PkgDeployConstants;

public class TesteConexao {
	public static void main(String[] args) throws RuntimeScriptException{
		// TODO Auto-generated method stub
		MyRemoteShell shell = new MyRemoteShell("10.43.1.110");
		try {
			/*shell.executeCommand("cd /oradata/om/official_build_scripts; ./copyLocal.sh ../pkg_dev;" +
					"cd ../deploy_dev_scripts; ./deploySQLp22.sh 2122012;");*/
			shell.executeCommand();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
