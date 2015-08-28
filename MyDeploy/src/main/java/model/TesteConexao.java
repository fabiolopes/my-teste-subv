package model;

import java.io.IOException;

import exceptions.RuntimeScriptException;


import util.PkgDeployConstants;

public class TesteConexao {
	public static void main(String[] args) throws RuntimeScriptException{
		// TODO Auto-generated method stub
		MyRemoteShell shell = new MyRemoteShell("10.43.1.109");
		try {
			shell.executeCommand("ls /oradata/om/stable_build_scripts/pkg/OM-*;");
		} catch (IOException e) {
			
		}
	}
}
