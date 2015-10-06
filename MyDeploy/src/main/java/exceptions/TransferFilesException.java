package exceptions;

import javax.swing.JOptionPane;

public class TransferFilesException extends Exception{

private static final long serialVersionUID = 1L;
	
	public TransferFilesException(String msg) throws Exception{
		JOptionPane.showMessageDialog(null, msg);
	}

}
