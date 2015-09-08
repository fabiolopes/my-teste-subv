package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import services.BuildServices;
import util.PkgDeployConstants;
import exceptions.RuntimeScriptException;

public class TelaInicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form TelaInicio
	 */
	public TelaInicio() {
		initComponents();
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		btGDelta = new javax.swing.ButtonGroup();
		btGProced = new javax.swing.ButtonGroup();
		panelPrincipal = new javax.swing.JPanel();
		cbAgents = new javax.swing.JCheckBox();
		cbEJB = new javax.swing.JCheckBox();
		cbBPM = new javax.swing.JCheckBox();
		cbGUI = new javax.swing.JCheckBox();
		cbMod = new javax.swing.JCheckBox();
		cbWS = new javax.swing.JCheckBox();
		cbDelta = new javax.swing.JCheckBox();
		rbOne = new javax.swing.JRadioButton();
		labelWhatDelta = new javax.swing.JLabel();
		rbMais = new javax.swing.JRadioButton();
		rbDeploy = new javax.swing.JRadioButton();
		rbFullRestart = new javax.swing.JRadioButton();
		rbRestartAgents = new javax.swing.JRadioButton();
		rbRestartJBoss = new javax.swing.JRadioButton();
		tfDeltaInicio = new javax.swing.JTextField();
		tfDeltaFinal = new javax.swing.JTextField();
		labelDeltaInicio = new javax.swing.JLabel();
		labelDeltaFinal = new javax.swing.JLabel();
		taOutPut = new javax.swing.JTextArea();
		taStatus = new javax.swing.JTextArea();
		labelTitle = new javax.swing.JLabel();
		btInstalar = new javax.swing.JButton();
		panelServer = new javax.swing.JPanel();
		panelProcedimento = new javax.swing.JPanel();
		cbServer = new javax.swing.JComboBox();
		scrollOutput = new javax.swing.JScrollPane();
		scrollStatus = new javax.swing.JScrollPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Wellcome to application - OM Deploy helper");
		setMinimumSize(new java.awt.Dimension(900, 700));
		setPreferredSize(new java.awt.Dimension(900, 700));
		setResizable(false);
		getContentPane().setLayout(null);

		panelPrincipal.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Informa��es do pacote"));
		panelPrincipal.setToolTipText("Insira informa��es do pacote");
		panelPrincipal.setLayout(null);

		cbAgents.setText("Agents");
		cbAgents.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				cbAgentsStateChanged(evt);
			}
		});
		panelPrincipal.add(cbAgents);
		cbAgents.setBounds(20, 30, 59, 23);

		cbEJB.setText("EJBs");
		cbEJB.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				cbEJBStateChanged(evt);
			}
		});
		panelPrincipal.add(cbEJB);
		cbEJB.setBounds(320, 30, 47, 23);

		cbBPM.setText("BPMs");
		cbBPM.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				cbBPMStateChanged(evt);
			}
		});
		panelPrincipal.add(cbBPM);
		cbBPM.setBounds(420, 30, 51, 23);

		cbGUI.setText("GUI");
		cbGUI.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				cbGUIStateChanged(evt);
			}
		});
		panelPrincipal.add(cbGUI);
		cbGUI.setBounds(120, 30, 43, 23);

		cbMod.setText("Modules");
		cbMod.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				cbModStateChanged(evt);
			}
		});
		panelPrincipal.add(cbMod);
		cbMod.setBounds(220, 30, 81, 23);

		cbWS.setText("WS");
		cbWS.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				cbWSStateChanged(evt);
			}
		});
		panelPrincipal.add(cbWS);
		cbWS.setBounds(520, 30, 41, 23);

		cbDelta.setText("SQL-Delta");
		cbDelta.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				cbDeltaStateChanged(evt);
			}
		});
		panelPrincipal.add(cbDelta);
		cbDelta.setBounds(20, 70, 73, 23);

		btGDelta.add(rbOne);
		rbOne.setText("1");
		rbOne.setEnabled(false);
		rbOne.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				rbOneStateChanged(evt);
			}
		});
		panelPrincipal.add(rbOne);
		rbOne.setBounds(20, 140, 40, 23);

		labelWhatDelta.setText("Quantos deltas?");
		panelPrincipal.add(labelWhatDelta);
		labelWhatDelta.setBounds(20, 120, 90, 14);

		btGDelta.add(rbMais);
		rbMais.setText("Mais de 1");
		rbMais.setEnabled(false);
		rbMais.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				rbMaisStateChanged(evt);
			}
		});
		panelPrincipal.add(rbMais);
		rbMais.setBounds(70, 140, 80, 23);

		tfDeltaInicio.setEnabled(false);
		panelPrincipal.add(tfDeltaInicio);
		tfDeltaInicio.setBounds(160, 140, 50, 20);
		tfDeltaInicio.addKeyListener(new java.awt.event.KeyListener() {

			public void keyTyped(KeyEvent e) {
				tfDeltaKeyTyped(e);

			}

			public void keyPressed(KeyEvent e) {

			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		tfDeltaFinal.setEnabled(false);
		panelPrincipal.add(tfDeltaFinal);
		tfDeltaFinal.setBounds(250, 140, 50, 20);
		tfDeltaFinal.addKeyListener(new java.awt.event.KeyListener() {

			public void keyTyped(KeyEvent e) {
				tfDeltaKeyTyped(e);

			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		labelDeltaInicio.setText("Delta (in�cio)");
		panelPrincipal.add(labelDeltaInicio);
		labelDeltaInicio.setBounds(160, 120, 70, 14);

		labelDeltaFinal.setText("Delta (final)");
		panelPrincipal.add(labelDeltaFinal);
		labelDeltaFinal.setBounds(250, 120, 60, 14);

		getContentPane().add(panelPrincipal);
		panelPrincipal.setBounds(40, 90, 610, 180);
		changePanelPrincipalEditable(false);

		labelTitle.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		labelTitle.setText("Defina os dados da instala��o");
		getContentPane().add(labelTitle);
		labelTitle.setBounds(40, 0, 250, 40);

		btInstalar.setText("Instalar");
		btInstalar.setEnabled(false);
		btInstalar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btInstalarActionPerformed(evt);
			}
		});
		getContentPane().add(btInstalar);
		btInstalar.setBounds(40, 280, 80, 30);
		scrollOutput.setViewportView(taOutPut);
		getContentPane().add(scrollOutput);
		scrollOutput.setBounds(40, 350, 810, 250);
		// getContentPane().add(taOutPut);
		// taOutPut.setBounds(40, 350, 600, 250);
		taOutPut.setEditable(true);
		taOutPut.setBackground(Color.BLACK);
		taOutPut.setForeground(Color.WHITE);
		taOutPut.setVisible(true);

		scrollStatus.setViewportView(taStatus);
		getContentPane().add(scrollStatus);
		scrollStatus.setBounds(660, 97, 190, 170);
		taStatus.setEditable(false);

		panelServer
				.setBorder(javax.swing.BorderFactory
						.createTitledBorder("Escolha o servidor onde a instala��o ser� realizada"));
		panelServer.setLayout(null);

		cbServer.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"10.43.1.87", "10.43.1.109", "10.43.1.110" }));
		panelServer.add(cbServer);
		cbServer.setBounds(20, 20, 110, 22);

		getContentPane().add(panelServer);
		panelServer.setBounds(40, 40, 400, 50);

		panelProcedimento.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Escolha o procedimento a ser realizado"));
		panelProcedimento.setLayout(null);
		getContentPane().add(panelProcedimento);
		panelProcedimento.setBounds(450, 40, 400, 50);
		
		btGProced.add(rbDeploy);
		rbDeploy.setText("Deploy");
		panelProcedimento.add(rbDeploy);
		rbDeploy.setBounds(15, 20, 70, 20);
		rbDeploy.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				rbDeployStateChanged(evt);
			}
		});
		
		btGProced.add(rbFullRestart);
		rbFullRestart.setText("Full Restart");
		panelProcedimento.add(rbFullRestart);
		rbFullRestart.setBounds(90, 20, 90, 20);
		rbFullRestart.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				rbStateChanged(evt, rbFullRestart);
			}
		});
		
		btGProced.add(rbRestartAgents);
		rbRestartAgents.setText("Restart Agents");
		panelProcedimento.add(rbRestartAgents);
		rbRestartAgents.setBounds(180, 20, 100, 20);
		rbRestartAgents
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						rbStateChanged(evt, rbRestartAgents);
					}
				});
		
		btGProced.add(rbRestartJBoss);
		rbRestartJBoss.setText("Restart JBOSS");
		panelProcedimento.add(rbRestartJBoss);
		rbRestartJBoss.setBounds(290, 20, 100, 20);
		rbRestartJBoss
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						rbStateChanged(evt, rbRestartJBoss);
					}
				});
		
		pack();
	}// </editor-fold>

	private void cbDeltaStateChanged(javax.swing.event.ChangeEvent evt) {
		if (cbDelta.isSelected()) {
			rbOne.setEnabled(true);
			rbMais.setEnabled(true);
		} else {
			rbOne.setEnabled(false);
			rbMais.setEnabled(false);
			tfDeltaInicio.setEnabled(false);
			tfDeltaFinal.setEnabled(false);
		}
		isSomeItemSelected();
	}

	private void rbOneStateChanged(javax.swing.event.ChangeEvent evt) {
		if (rbOne.isSelected()) {
			tfDeltaInicio.setEnabled(true);
			tfDeltaFinal.setEnabled(false);
		}
	}

	private void rbMaisStateChanged(javax.swing.event.ChangeEvent evt) {
		if (rbMais.isSelected()) {
			tfDeltaInicio.setEnabled(true);
			tfDeltaFinal.setEnabled(true);
		}
	}

	private void rbDeployStateChanged(javax.swing.event.ChangeEvent evt) {
		if (rbDeploy.isSelected()) {
			changePanelPrincipalEditable(true);
		} else {
			changePanelPrincipalEditable(false);
		}
	}

	private void rbStateChanged(javax.swing.event.ChangeEvent evt,
			JRadioButton rb) {
		if (rb.isSelected()) {
			btInstalar.setEnabled(true);
		} else {
			btInstalar.setEnabled(false);
		}
	}

	private void cbAgentsStateChanged(javax.swing.event.ChangeEvent evt) {
		isSomeItemSelected();
	}

	private void cbGUIStateChanged(javax.swing.event.ChangeEvent evt) {
		isSomeItemSelected();
	}

	private void cbModStateChanged(javax.swing.event.ChangeEvent evt) {
		isSomeItemSelected();
	}

	private void cbEJBStateChanged(javax.swing.event.ChangeEvent evt) {
		isSomeItemSelected();
	}

	private void cbBPMStateChanged(javax.swing.event.ChangeEvent evt) {
		isSomeItemSelected();
	}

	private void cbWSStateChanged(javax.swing.event.ChangeEvent evt) {
		isSomeItemSelected();
	}

	private void tfDeltaKeyTyped(java.awt.event.KeyEvent evt) {
		String caracteres = "0987654321";
		if (!caracteres.contains(evt.getKeyChar() + "")) {
			evt.consume();
		}
	}

	private void btInstalarActionPerformed(java.awt.event.ActionEvent evt) {
		final BuildServices build = new BuildServices(cbServer.getSelectedItem().toString());
		final TelaInicio ctx = this;
		if (rbDeploy.isSelected()) {
		if (isDeltaCorrect()) {
			new Thread(new Runnable() {

				public void run() {
					try {
							build.executeBuildAndDeployScripts(
									getpkgsToInstall(), ctx, isSomeJavaItemSelected());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RuntimeScriptException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		} else {
			JOptionPane.showMessageDialog(null,
					"Insira insforma��es corretas dos deltas");
		}
		}else{
			String restart="";
			if(rbFullRestart.isSelected()){
				restart="full";
			}else if(rbRestartAgents.isSelected()){
				restart="agents";
			}else if(rbRestartJBoss.isSelected()){
				restart=PkgDeployConstants.SCRIPT_RESTART_JBOSS;
			}
			final String finalRestart = restart;
			new Thread(new Runnable() {
				
				public void run() {
					try {
						build.doRestart(finalRestart, ctx);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RuntimeScriptException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}).start();
		}
	}

	private ArrayList<String> getpkgsToInstall() {
		ArrayList<String> pkgs = new ArrayList<String>();
		if (cbMod.isSelected()) {
			pkgs.add("MOD");
		}
		if (cbEJB.isSelected()) {
			pkgs.add("EJB");
		}
		if (cbGUI.isSelected()) {
			pkgs.add("GUI");
		}
		if (cbWS.isSelected()) {
			pkgs.add("WS");
		}
		if (cbBPM.isSelected()) {
			pkgs.add("BPM");
		}
		if (cbAgents.isSelected()) {
			pkgs.add("AGE");
		}
		if (cbDelta.isSelected()) {
			if (rbOne.isSelected()) {
				pkgs.add("Delta-" + tfDeltaInicio.getText());
			} else {
				int deltaInicio = Integer.parseInt(tfDeltaInicio.getText());
				int deltaFinal = Integer.parseInt(tfDeltaFinal.getText());
				for (int i = deltaInicio; i <= deltaFinal; i++) {
					pkgs.add("Delta-" + String.valueOf(i));
				}
			}
		}

		return pkgs;
	}

	private boolean isSomeJavaItemSelected() {
		return (cbAgents.isSelected() || cbEJB.isSelected()
				|| cbGUI.isSelected() || cbMod.isSelected()
				|| cbWS.isSelected() || cbBPM.isSelected());
	}

	private void isSomeItemSelected() {
		if (isSomeJavaItemSelected() || cbDelta.isSelected()) {
			btInstalar.setEnabled(true);
		} else {
			btInstalar.setEnabled(false);
		}

	}

	private boolean isDeltaCorrect() {
		// Resumindo: Retorna true se cbdelta est� selecionado e se:
		// (rb est� selecionado ou: (brmais est� selecionado e tfdeltafinal n�o
		// est� vazio
		// e o deltafinal � maior que o inicial) e deltainicio n�o est� vazio
		return (!cbDelta.isSelected() || ((rbOne.isSelected() || (rbMais
				.isSelected() && !tfDeltaFinal.getText().equals("") && Integer
				.parseInt(tfDeltaFinal.getText()) > Integer
				.parseInt(tfDeltaInicio.getText()))) && !tfDeltaInicio
				.getText().equals("")));
	}

	private void changePanelPrincipalEditable(boolean isEditable) {
		for (Component c : panelPrincipal.getComponents()) {
			c.setEnabled(isEditable);
		}
		// Problema: Se true, todos os componentes, inclusive os referentes ao
		// delta estar�o habilitados
		// Como solu��o, quando true, o checkbox do delta � marcado e
		// desmarcado, deixando tudo desabilitado :)
		if (isEditable) {
			cbDelta.setSelected(true);
			cbDelta.setSelected(false);
		}
	}

	public void setOutPutInTextArea(final String out) {
		taOutPut.append(out + "\n");
		taOutPut.setCaretPosition(taOutPut.getDocument().getLength());
	}

	public void setStatusCode(final String status) {
		taStatus.append(status + "\n");
		taStatus.setCaretPosition(taStatus.getDocument().getLength());
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaInicio().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.ButtonGroup btGDelta;
	private javax.swing.ButtonGroup btGProced;
	private javax.swing.JButton btInstalar;
	private javax.swing.JCheckBox cbAgents;
	private javax.swing.JCheckBox cbBPM;
	private javax.swing.JCheckBox cbDelta;
	private javax.swing.JCheckBox cbEJB;
	private javax.swing.JCheckBox cbGUI;
	private javax.swing.JCheckBox cbMod;
	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cbServer;
	private javax.swing.JCheckBox cbWS;
	private javax.swing.JLabel labelDeltaFinal;
	private javax.swing.JLabel labelDeltaInicio;
	private javax.swing.JLabel labelTitle;
	private javax.swing.JLabel labelWhatDelta;
	private javax.swing.JPanel panelPrincipal;
	private javax.swing.JPanel panelServer;
	private javax.swing.JPanel panelProcedimento;
	private javax.swing.JScrollPane scrollStatus;
	private javax.swing.JScrollPane scrollOutput;
	private javax.swing.JTextArea taOutPut;
	private javax.swing.JTextArea taStatus;
	private javax.swing.JRadioButton rbMais;
	private javax.swing.JRadioButton rbOne;
	private javax.swing.JRadioButton rbDeploy;
	private javax.swing.JRadioButton rbFullRestart;
	private javax.swing.JRadioButton rbRestartAgents;
	private javax.swing.JRadioButton rbRestartJBoss;
	private javax.swing.JTextField tfDeltaFinal;
	private javax.swing.JTextField tfDeltaInicio;
	// End of variables declaration
}