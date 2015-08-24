package gui;

import java.awt.TextArea;

import javax.swing.JFrame;

public class TelaOutPut extends JFrame{
	private TextArea outputArea;
	
	private static final long serialVersionUID = 1L;
	
	public TelaOutPut(){
		initComponents();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void initComponents(){
		this.setSize(700, 700);
		this.setTitle("OutPut ");
		this.setLocationRelativeTo(null);
		outputArea = new TextArea();
		this.add(outputArea);
		this.setVisible(true);
	}
	
	public void setValueInTextArea(String s){
		outputArea.setText(outputArea.getText()+"\n"+s);
	}
	
	public static void main(String[] args) {
		TelaOutPut o = new TelaOutPut();
	}

}
