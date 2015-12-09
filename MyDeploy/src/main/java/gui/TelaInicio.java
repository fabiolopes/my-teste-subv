package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import model.RemoteShell;
import model.sharepoint.Feed;
import model.sharepoint.Properties;
import services.BuildServices;
import services.SharePointConnector;
import util.PkgDeployConstants;
import util.SetupUtil;
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
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		btGDelta = new javax.swing.ButtonGroup();
		btGProced = new javax.swing.ButtonGroup();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Wellcome to application - OM Deploy helper");
		setMinimumSize(new java.awt.Dimension(900, 700));
		setPreferredSize(new java.awt.Dimension(900, 700));
		setResizable(false);
		getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 894, 675);
		getContentPane().add(tabbedPane);

		panelBuild = new JPanel();
		panelBuild.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				tfDomain.setText(SetupUtil.getValue(SetupUtil.ACCESS_SECTION, "sharepoint_user_domain"));
				tfUsername.setText(SetupUtil.getValue(SetupUtil.ACCESS_SECTION, "sharepoint_username"));
				
			}
		});
		tabbedPane.addTab("Build", null, panelBuild, null);
		panelBuild.setLayout(null);
		
		JLabel label = new JLabel("Username");
		label.setBounds(82, 36, 116, 14);
		panelBuild.add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JOptionPane.showMessageDialog(null, new String(tfCredPassword.getPassword()).toString() ,"Password reveal!!", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		label_1.setBounds(220, 36, 46, 14);
		panelBuild.add(label_1);
		
		JLabel label_2 = new JLabel("Credentials to AKN (SharePoint)");
		label_2.setFont(new Font("Arial", Font.PLAIN, 18));
		label_2.setBounds(10, 11, 280, 14);
		panelBuild.add(label_2);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(82, 51, 128, 20);
		panelBuild.add(tfUsername);
		
		tfCredPassword = new JPasswordField();
		tfCredPassword.setBounds(220, 51, 209, 20);
		panelBuild.add(tfCredPassword);
		
		JLabel label_3 = new JLabel("Domain (DIR)");
		label_3.setBounds(10, 36, 72, 14);
		panelBuild.add(label_3);
		
		tfDomain = new JTextField();
		tfDomain.setColumns(10);
		tfDomain.setBounds(10, 51, 63, 20);
		panelBuild.add(tfDomain);
		
		final JButton btSaveUserCredentials = new JButton("Save");
		btSaveUserCredentials.setEnabled(false);
		btSaveUserCredentials.setBounds(338, 82, 91, 23);
		panelBuild.add(btSaveUserCredentials);
		
		final JPanel panelSearchDelta = new JPanel();
		panelSearchDelta.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Search and Lock a delta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSearchDelta.setBounds(10, 121, 419, 282);
		panelBuild.add(panelSearchDelta);
				panelSearchDelta.setLayout(null);
						
						tfPhase = new JTextField();
						tfPhase.setEnabled(false);
						tfPhase.setBounds(10, 38, 86, 20);
						panelSearchDelta.add(tfPhase);
						tfPhase.setColumns(10);
				
						JButton btnCheckAvailability = new JButton("Check for availability");
						btnCheckAvailability.setEnabled(false);
						btnCheckAvailability.setBounds(106, 37, 140, 23);
						panelSearchDelta.add(btnCheckAvailability);
						
								JButton btnLock = new JButton("Lock");
								btnLock.setEnabled(false);
								btnLock.setBounds(354, 248, 55, 23);
								panelSearchDelta.add(btnLock);
								
								JLabel lblPhase = new JLabel("Phase");
								lblPhase.setEnabled(false);
								lblPhase.setBounds(10, 24, 46, 14);
								panelSearchDelta.add(lblPhase);
								
								lbReasonSDNDefect = new JLabel("Reason or SDN/Defect related");
								lbReasonSDNDefect.setEnabled(false);
								lbReasonSDNDefect.setBounds(10, 115, 236, 14);
								panelSearchDelta.add(lbReasonSDNDefect);
								
								tfReasonSDNDefect = new JTextField();
								tfReasonSDNDefect.setEnabled(false);
								tfReasonSDNDefect.setBounds(10, 131, 399, 20);
								panelSearchDelta.add(tfReasonSDNDefect);
								tfReasonSDNDefect.setColumns(10);
								
								lblDelta = new JLabel("Delta #");
								lblDelta.setEnabled(false);
								lblDelta.setBounds(10, 69, 46, 14);
								panelSearchDelta.add(lblDelta);
								
								tfDeltaNumber = new JTextField();
								tfDeltaNumber.setEnabled(false);
								tfDeltaNumber.setColumns(10);
								tfDeltaNumber.setBounds(10, 86, 125, 20);
								panelSearchDelta.add(tfDeltaNumber);
								
								lblTechnicalDesignRelated = new JLabel("Technical Design related");
								lblTechnicalDesignRelated.setEnabled(false);
								lblTechnicalDesignRelated.setBounds(10, 159, 146, 14);
								panelSearchDelta.add(lblTechnicalDesignRelated);
								
								JScrollPane scrollPane = new JScrollPane();
								scrollPane.setEnabled(false);
								scrollPane.setBounds(10, 178, 399, 53);
								panelSearchDelta.add(scrollPane);
								
								JTextArea taTDs = new JTextArea();
								taTDs.setEnabled(false);
								scrollPane.setViewportView(taTDs);
								btnLock.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
									}
								});
								
						btnCheckAvailability.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {

								SharePointConnector con = new SharePointConnector();
								con.setPassword(tfCredPassword.getPassword());
								model.sharepoint.Feed feed = con.querySharePoint("$filter=Phase eq '" + tfPhase.getText().trim() + "'&$top=1&$orderby=Modified desc");
								
								String nextDelta;
								if (feed != null && feed.getEntry() != null && feed.getEntry().size() > 0) {
									model.sharepoint.Properties properties = feed.getEntry().get(0).getContent().getProperties();
									
									nextDelta = properties.getDeltaNumber();
									if (properties.getStatusValue().toLowerCase().equals("done")) {
										tfDeltaNumber.setText(getNexDeltaNumber(nextDelta));
									} else {
										tfDeltaNumber.setText(nextDelta);
									}
								}
								

							}

							private String getNexDeltaNumber(String nextDelta) {
								Integer currentDelta = Integer.parseInt(nextDelta);
								currentDelta++;
								return currentDelta.toString();
							}
						});


		btSaveUserCredentials.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enableComponents(panelSearchDelta, true);
			}
		});

		tfCredPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (tfCredPassword.getPassword() != null && tfCredPassword.getPassword().length > 6) {
					btSaveUserCredentials.setEnabled(true);
				} else {
					enableComponents(panelSearchDelta, false);
					btSaveUserCredentials.setEnabled(false);
				}
			}
		});
						
		panelDeploy = new JPanel();
		tabbedPane.addTab("Deploy", null, panelDeploy, null);
		panelDeploy.setLayout(null);
		panelPrincipal = new javax.swing.JPanel();
		panelPrincipal.setBounds(44, 90, 610, 180);
		panelDeploy.add(panelPrincipal);
		cbAgents = new javax.swing.JCheckBox();
		cbBPM = new javax.swing.JCheckBox();
		cbGUI = new javax.swing.JCheckBox();
		cbMod = new javax.swing.JCheckBox();
		cbWS = new javax.swing.JCheckBox();
		cbDelta = new javax.swing.JCheckBox();
		rbOne = new javax.swing.JRadioButton();
		labelWhatDelta = new javax.swing.JLabel();
		rbMais = new javax.swing.JRadioButton();
		// rbRestartAgents = new javax.swing.JRadioButton();
		// rbRestartJBoss = new javax.swing.JRadioButton();
		tfDeltaInicio = new javax.swing.JTextField();
		tfDeltaFinal = new javax.swing.JTextField();
		tfFQAPkg = new javax.swing.JTextField();
		labelDeltaInicio = new javax.swing.JLabel();
		labelDeltaFinal = new javax.swing.JLabel();
		labelFQAPkg = new javax.swing.JLabel();

		panelPrincipal.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Informações do pacote"));
		panelPrincipal.setToolTipText("Insira informações do pacote");
		panelPrincipal.setLayout(null);

		cbAgents.setText("Agents");
		cbAgents.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				cbAgentsStateChanged(evt);
			}
		});
		panelPrincipal.add(cbAgents);
		cbAgents.setBounds(20, 30, 59, 23);

		cbBPM.setText("BPMs");
		cbBPM.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				cbBPMStateChanged(evt);
			}
		});
		cbEJB = new javax.swing.JCheckBox();

		cbEJB.setText("EJBs");
		cbEJB.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				cbEJBStateChanged(evt);
			}
		});
		panelPrincipal.add(cbEJB);
		cbEJB.setBounds(320, 30, 47, 23);
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

		panelPrincipal.add(tfFQAPkg);
		tfFQAPkg.setEnabled(false);
		tfFQAPkg.setBounds(340, 140, 130, 20);
		tfFQAPkg.addKeyListener(new java.awt.event.KeyListener() {

			public void keyTyped(KeyEvent e) {
				tfFQAPkgKeyTyped(e);

			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		labelDeltaInicio.setText("Delta (início)");
		panelPrincipal.add(labelDeltaInicio);
		labelDeltaInicio.setBounds(160, 120, 70, 14);

		labelDeltaFinal.setText("Delta (final)");
		panelPrincipal.add(labelDeltaFinal);
		labelDeltaFinal.setBounds(250, 120, 60, 14);

		labelFQAPkg.setText("Versão do pacote");
		panelPrincipal.add(labelFQAPkg);
		labelFQAPkg.setBounds(340, 120, 100, 14);
		labelTitle = new javax.swing.JLabel();
		labelTitle.setBounds(44, 0, 250, 40);
		panelDeploy.add(labelTitle);

		labelTitle.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		labelTitle.setText("Defina os dados da instalação");
		btIniciar = new javax.swing.JButton();
		btIniciar.setBounds(44, 280, 80, 30);
		panelDeploy.add(btIniciar);

		btIniciar.setText("Iniciar");
		btIniciar.setEnabled(false);
		btFechar = new javax.swing.JButton();
		btFechar.setBounds(144, 280, 80, 30);
		panelDeploy.add(btFechar);

		btFechar.setText("Fechar");
		taOutPut = new javax.swing.JTextArea();
		scrollOutput = new javax.swing.JScrollPane();
		scrollOutput.setBounds(44, 350, 810, 250);
		panelDeploy.add(scrollOutput);

		scrollOutput.setViewportView(taOutPut);
		// getContentPane().add(taOutPut);
		// taOutPut.setBounds(40, 350, 600, 250);
		taOutPut.setEditable(true);
		taOutPut.setBackground(Color.BLACK);
		taOutPut.setForeground(Color.WHITE);
		taStatus = new javax.swing.JTextArea();
		scrollStatus = new javax.swing.JScrollPane();
		scrollStatus.setBounds(664, 97, 190, 170);
		panelDeploy.add(scrollStatus);

		scrollStatus.setViewportView(taStatus);
		taStatus.setEditable(false);
		panelServer = new javax.swing.JPanel();
		panelServer.setBounds(44, 40, 400, 50);
		panelDeploy.add(panelServer);
		cbServer = new javax.swing.JComboBox();

		panelServer.setBorder(javax.swing.BorderFactory
						.createTitledBorder("Escolha o servidor onde a instalação será realizada"));
		panelServer.setLayout(null);

		cbServer.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"10.43.1.87", "10.43.1.109", "10.43.1.110" }));
		panelServer.add(cbServer);
		cbServer.setBounds(20, 20, 110, 22);
		rbDeploy = new javax.swing.JRadioButton();
		rbFQAPkg = new javax.swing.JRadioButton();
		panelProcedimento = new javax.swing.JPanel();
		panelProcedimento.setBounds(454, 40, 400, 50);
		panelDeploy.add(panelProcedimento);

		panelProcedimento.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Escolha o procedimento a ser realizado"));
		panelProcedimento.setLayout(null);

		btGProced.add(rbDeploy);
		rbDeploy.setText("Deploy");
		panelProcedimento.add(rbDeploy);
		rbDeploy.setBounds(15, 20, 70, 20);
		rbDeploy.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				rbDeployStateChanged(evt);
			}
		});

		btGProced.add(rbFQAPkg);
		rbFQAPkg.setText("FQA Pkg");
		panelProcedimento.add(rbFQAPkg);
		rbFQAPkg.setBounds(90, 20, 90, 20);
		
		panelSetup = new JPanel();
		panelSetup.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				tfProtocol.setText(SetupUtil.getValue(SetupUtil.ACCESS_SECTION, "sharepoint_protocol"));
				tfHost.setText(SetupUtil.getValue(SetupUtil.ACCESS_SECTION, "sharepoint_host"));
				tfPort.setText(SetupUtil.getValue(SetupUtil.ACCESS_SECTION, "sharepoint_port"));
				tfPath.setText(SetupUtil.getValue(SetupUtil.ACCESS_SECTION, "sharepoint_path"));
				
			}
		});
		tabbedPane.addTab("Setup", null, panelSetup, null);
		panelSetup.setLayout(null);
		
		JLabel lblProtocol = new JLabel("Protocol");
		lblProtocol.setBounds(25, 35, 46, 14);
		panelSetup.add(lblProtocol);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setBounds(97, 35, 46, 14);
		panelSetup.add(lblHost);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(398, 35, 46, 14);
		panelSetup.add(lblPort);
		
		JLabel lblPath = new JLabel("Path");
		lblPath.setBounds(25, 73, 46, 14);
		panelSetup.add(lblPath);
		
		JLabel lblSharepointAccess = new JLabel("SharePoint access");
		lblSharepointAccess.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSharepointAccess.setBounds(25, 11, 251, 14);
		panelSetup.add(lblSharepointAccess);
		
		tfProtocol = new JTextField();
		tfProtocol.setEnabled(false);
		tfProtocol.setBounds(25, 50, 63, 20);
		panelSetup.add(tfProtocol);
		tfProtocol.setColumns(10);
		
		tfHost = new JTextField();
		tfHost.setEnabled(false);
		tfHost.setColumns(10);
		tfHost.setBounds(97, 50, 286, 20);
		panelSetup.add(tfHost);
		
		tfPort = new JTextField();
		tfPort.setEnabled(false);
		tfPort.setColumns(10);
		tfPort.setBounds(391, 50, 53, 20);
		panelSetup.add(tfPort);
		
		tfPath = new JTextField();
		tfPath.setEnabled(false);
		tfPath.setColumns(10);
		tfPath.setBounds(25, 88, 419, 20);
		panelSetup.add(tfPath);
		
		JButton btEnableAccessSetup = new JButton("Enable/Disable for editing");
		btEnableAccessSetup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<JTextField> fields = new ArrayList<JTextField>();
				fields.add(tfProtocol);
				fields.add(tfHost);
				fields.add(tfPort);
				fields.add(tfPath);
				switchEnabledState(fields);
			}
		});
		btEnableAccessSetup.setBounds(25, 117, 157, 23);
		panelSetup.add(btEnableAccessSetup);
		
		JButton btnSaveAccess = new JButton("Save");
		btnSaveAccess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tfProtocol.isEditable()) {
					List<JTextField> fields = new ArrayList<JTextField>();
					fields.add(tfProtocol);
					fields.add(tfHost);
					fields.add(tfPort);
					fields.add(tfPath);
					switchEnabledState(fields);

					SetupUtil.setValue(SetupUtil.ACCESS_SECTION, "sharepoint_protocol", tfProtocol.getText());
					SetupUtil.setValue(SetupUtil.ACCESS_SECTION, "sharepoint_host", tfHost.getText());
					SetupUtil.setValue(SetupUtil.ACCESS_SECTION, "sharepoint_port", tfPort.getText());
					SetupUtil.setValue(SetupUtil.ACCESS_SECTION, "sharepoint_path", tfPath.getText());
				}
			}
		});
		btnSaveAccess.setBounds(353, 119, 91, 23);
		panelSetup.add(btnSaveAccess);
		rbFQAPkg.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				rbFQAPkgStateChanged(evt);
			}
		});
		taOutPut.setVisible(true);
		btFechar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btFecharActionPerformed(evt);
			}
		});
		btIniciar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btIniciarActionPerformed(evt);
			}
		});
		changePanelPrincipalEditable(true);

		/*
		 * btGProced.add(rbRestartAgents);
		 * rbRestartAgents.setText("Restart Agents");
		 * panelProcedimento.add(rbRestartAgents);
		 * rbRestartAgents.setBounds(180, 20, 100, 20); rbRestartAgents
		 * .addChangeListener(new javax.swing.event.ChangeListener() { public
		 * void stateChanged(javax.swing.event.ChangeEvent evt) {
		 * rbStateChanged(evt, rbRestartAgents); } });
		 * 
		 * btGProced.add(rbRestartJBoss);
		 * rbRestartJBoss.setText("Restart JBOSS");
		 * panelProcedimento.add(rbRestartJBoss); rbRestartJBoss.setBounds(290,
		 * 20, 100, 20); rbRestartJBoss .addChangeListener(new
		 * javax.swing.event.ChangeListener() { public void
		 * stateChanged(javax.swing.event.ChangeEvent evt) { rbStateChanged(evt,
		 * rbRestartJBoss); } });
		 */

		setIcon();

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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void rbDeployStateChanged(javax.swing.event.ChangeEvent evt) {
		if (rbDeploy.isSelected()) {
			tfFQAPkg.setEnabled(false);
			cbServer.setModel(new javax.swing.DefaultComboBoxModel(
					new String[] { "10.43.1.87", "10.43.1.109", "10.43.1.110" }));
		} else {
			tfFQAPkg.setEnabled(true);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void rbFQAPkgStateChanged(javax.swing.event.ChangeEvent evt) {
		if (rbFQAPkg.isSelected()) {
			tfFQAPkg.setEnabled(true);
			cbServer.setModel(new javax.swing.DefaultComboBoxModel(
					new String[] { "R1", "R2.1" }));
			isSomeItemVersionFQASelected();
		} else {
			tfFQAPkg.setEnabled(false);
		}
	}

	/*
	 * private void rbStateChanged(javax.swing.event.ChangeEvent evt,
	 * JRadioButton rb) { if (rb.isSelected()) { btIniciar.setEnabled(true); }
	 * else { btIniciar.setEnabled(false); } }
	 */

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

	private void tfFQAPkgKeyTyped(java.awt.event.KeyEvent evt) {
		isSomeItemVersionFQASelected();
	}

	private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {
		limpaTela();
		final BuildServices build = new BuildServices(getServer());
		final TelaInicio ctx = this;
		// if (rbDeploy.isSelected()) {
		if (isDeltaCorrect()) {
			new Thread(new Runnable() {

				public void run() {
					try {
						String msg = new String();
						if (rbDeploy.isSelected()) {
							if (build.executeBuildAndDeployScripts(
									getpkgsToInstall(), ctx,
									isSomeJavaItemSelected())) {
								msg = "Deploy concluído com sucesso. Versão do pacote disponível na área de transferência";
								copyToTransferArea(RemoteShell.omTxt);
								RemoteShell.omTxt = "";
							}
						} else if (rbFQAPkg.isSelected()) {
							if (build.generateFQAPkg(getpkgsToInstall(), ctx,
									isSomeJavaItemSelected(), tfFQAPkg
											.getText().trim())) {
								msg = "Pacote para FQA criado com sucesso";
							}
						}
						JOptionPane.showMessageDialog(null, msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RuntimeScriptException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		} else {
			JOptionPane.showMessageDialog(null,
					"Insira insformações corretas dos deltas");
		}
		// Abortado porque aparentemente o cliente unix n�o consegue detachar do
		// start_jboss e start_agents
		/*
		 * }else{ String restart=""; if(rbFullRestart.isSelected()){
		 * restart="full"; }else if(rbRestartAgents.isSelected()){
		 * restart="agents"; }else if(rbRestartJBoss.isSelected()){
		 * restart="jboss"; } final String finalRestart = restart; new
		 * Thread(new Runnable() {
		 * 
		 * public void run() { try { build.doRestart(finalRestart, ctx);
		 * JOptionPane.showMessageDialog(null, "Restart conclu�do com sucesso");
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (RuntimeScriptException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * } }).start();
		 * 
		 * }
		 */
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
			btIniciar.setEnabled(true);
		} else {
			btIniciar.setEnabled(false);
		}

	}

	public void isSomeItemVersionFQASelected() {
		if (isSomeJavaItemSelected() || cbDelta.isSelected()
				&& !tfFQAPkg.getText().isEmpty()) {
			btIniciar.setEnabled(true);
		} else {
			btIniciar.setEnabled(false);
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

	private String getServer() {
		if (rbDeploy.isSelected()) {
			return cbServer.getSelectedItem().toString();
		} else {
			String server = cbServer.getSelectedItem().toString();
			if (server.equals("R1")) {
				return PkgDeployConstants.MACHINE_ST1;
			} else if (server.equals("R2.1")) {
				return PkgDeployConstants.MACHINE_ST2;
			}
		}
		return null;
	}

	private void changePanelPrincipalEditable(boolean isEditable) {
		for (Component c : panelPrincipal.getComponents()) {
			c.setEnabled(isEditable);
		}
		// Problema: Se true, todos os componentes, inclusive os referentes ao
		// delta estarão habilitados
		// Como solução, quando true, o checkbox do delta é marcado e
		// desmarcado, deixando tudo desabilitado :)
		if (isEditable) {
			cbDelta.setSelected(true);
			cbDelta.setSelected(false);
		}
	}

	public void limpaTela() {
		taOutPut.setText("");
		taStatus.setText("");
	}

	public void setOutPutInTextArea(final String out) {
		taOutPut.append(out + "\n");
		taOutPut.setCaretPosition(taOutPut.getDocument().getLength());
	}

	public void setStatusCode(final String status) {
		taStatus.append(status + "\n");
		taStatus.setCaretPosition(taStatus.getDocument().getLength());
	}

	public void showInfoInDialog(String info) {
		JOptionPane.showMessageDialog(null, info);
	}

	private void copyToTransferArea(String toCopy) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection selection = new StringSelection(toCopy);
		clipboard.setContents(selection, null);
	}

	private void setIcon() {
		URL url = this.getClass().getClassLoader()
				.getResource("resource/icone_instalacao.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeTitulo);
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
	private javax.swing.JButton btIniciar;
	private javax.swing.JButton btFechar;
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
	private javax.swing.JLabel labelFQAPkg;
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
	private javax.swing.JRadioButton rbFQAPkg;
	// private javax.swing.JRadioButton rbRestartAgents;
	// private javax.swing.JRadioButton rbRestartJBoss;
	private javax.swing.JTextField tfDeltaFinal;
	private javax.swing.JTextField tfDeltaInicio;
	private javax.swing.JTextField tfFQAPkg;
	private JPanel panel;
	private JPanel panelDeploy;
	private JTabbedPane tabbedPane;
	private JPanel panelBuild;
	private JTextField tfPhase;
	private JPanel panelSetup;
	private JTextField tfProtocol;
	private JTextField tfHost;
	private JTextField tfPort;
	private JTextField tfPath;
	private JTextField tfUsername;
	private JPasswordField tfCredPassword;
	private JTextField tfDomain;
	private JLabel lbReasonSDNDefect;
	private JTextField tfReasonSDNDefect;
	private JLabel lblDelta;
	private JTextField tfDeltaNumber;
	private JLabel lblTechnicalDesignRelated;
	
	public static void switchEnabledState(List<JTextField> objects) {
		for (JTextField jTextField : objects) {
			jTextField.setEnabled(!jTextField.isEnabled());
		}
	}
	
	public static void enableComponents(Container container, boolean enable) {
		Component[] components = container.getComponents();
		for (Component component : components) {
			component.setEnabled(enable);
		}
	}
}