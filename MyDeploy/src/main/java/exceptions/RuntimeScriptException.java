package exceptions;

import javax.swing.JOptionPane;

public class RuntimeScriptException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public RuntimeScriptException(String msg) throws Exception{
		JOptionPane.showMessageDialog(null, msg);
	}

}
