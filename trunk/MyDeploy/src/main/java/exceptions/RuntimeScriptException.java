package exceptions;

import javax.swing.JOptionPane;

public class RuntimeScriptException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public RuntimeScriptException(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}

}
