package br.pucsp.tcc.gui.cadastrarCliente.impl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.pucsp.tcc.gui.cadastrarCliente.CadastramentoClienteIndividual;
import br.pucsp.tcc.gui.cadastrarCliente.TelaCadastro;
import br.pucsp.tcc.gui.componentesPersonalizados.MyJTextField;
import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;
import br.pucsp.tcc.gui.mdi.Mdi;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class CadastroClienteIndividualGui extends Tela implements TelaCadastro {

	private CadastramentoClienteIndividual cadastradorClienteIndividual;
	private JPanel jContentPane = null;
	private Mdi jFrame = null;
	private JPanel jPanelCENTER = null;
	private JPanel jPanelJTextFields = null;
	private JLabel jLabelNome = null;
	private JTextField jTextFieldNome = null;
	private JButton jButtonOk = null;
	private JPanel jPanelJLabels = null;
	private JLabel jLabelNascimento = null;
	private JPanel jPanelNome = null;
	private JPanel jPanelNascimento = null;
	private JTextField jTextFieldDia = null;
	private JLabel jLabelEMail = null;
	private JPanel jPanelEMail = null;
	private JPanel jPanelTelefoneFixo = null;
	private JPanel jPanelCelular = null;
	private JTextField jTextFieldEMail = null;
	private JTextField jTextFieldTelefoneFixo = null;
	private JTextField jTextFieldCelular = null;
	private JLabel jLabelTelefoneFixo = null;
	private JLabel jLabelCelular = null;
	private JTextField jTextFieldMes = null;
	private JTextField jTextFieldAno = null;
	private JLabel jLabelBarra1 = null;
	private JLabel jLabelBarra2 = null;
	private JPanel jPanelGridLayoutNascimento = null;
	private JPanel jPanelDia = null;
	private JPanel jPanelMes = null;
	private JPanel jPanelAno = null;
	private JPanel jPanelNamedForm = null;
	private JPanel jPanelForm = null;
	private JPanel jPanelImpressaoDigital = null;
	private JPanel jPanelLeft = null;
	private JPanel jPanelRight = null;
	private JPanel jPanelNamedImpressaoDigital = null;
	private JPanel jPanelFormText = null;
	private JScrollPane jScrollPaneDigital = null;
	private JPanel jPanelCenter = null;
	private ActionListener acaoBotao = null;
	private JPanel jPanelBotoes = null;
	private JPanel jPanelCenterBotoes = null;
	private JButton jButtonCancelar = null;
	
	public CadastroClienteIndividualGui(CadastramentoClienteIndividual cadastradorClienteIndividual) {
		super();
		this.cadastradorClienteIndividual = cadastradorClienteIndividual;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		getJFrame();
		editarNome();
	}

	@Override
	public void exibir() {
//		getJFrame().setVisible(true);
		FactorySingletonMdi.Construir().setVisible(true);
	}

	public void confirmarCadastro() {
		cadastradorClienteIndividual.setNome(jTextFieldNome.getText());
		String nascimento = jTextFieldDia.getText();
		nascimento += "/";
		nascimento += jTextFieldMes.getText();
		nascimento += "/";
		nascimento += jTextFieldAno.getText();
		if(nascimento.length() != 10) {
			nascimento = null;
		}
		cadastradorClienteIndividual.setNascimento(nascimento);
		cadastradorClienteIndividual.setTelefoneFixo(jTextFieldTelefoneFixo.getText());
		cadastradorClienteIndividual.setCelular(jTextFieldCelular.getText());
		cadastradorClienteIndividual.setEMail(jTextFieldEMail.getText());
		cadastradorClienteIndividual.salvarCadastro();
		fecharTela();
	}

	public void confirmarEdicao() {
		cadastradorClienteIndividual.setNome(jTextFieldNome.getText());
		String nascimento = jTextFieldDia.getText();
		nascimento += "/";
		nascimento += jTextFieldMes.getText();
		nascimento += "/";
		nascimento += jTextFieldAno.getText();
		cadastradorClienteIndividual.setNascimento(nascimento);
		cadastradorClienteIndividual.setTelefoneFixo(jTextFieldTelefoneFixo.getText());
		cadastradorClienteIndividual.setCelular(jTextFieldCelular.getText());
		cadastradorClienteIndividual.setEMail(jTextFieldEMail.getText());
		cadastradorClienteIndividual.editarCadastro();
		fecharTela();
	}

	public void cancelar() {
		fecharTela();
	}
	
	private Mdi getJFrame() {
		if(jFrame  == null) {
//			jFrame = SingletonMdiEditado;
//			jFrame.setSize(400, 150);
//			jFrame.setTitle("Cadastrar Cliente");
			jFrame = FactorySingletonMdi.Construir();
			jFrame.setContentPane(getJContentPane());
//			centralizar(jFrame);
		}
		return jFrame;
	}

	private JPanel getJContentPane() {
		if(jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(15);
			borderLayout.setVgap(10);
			jContentPane  = new JPanel();
			jContentPane.setSize(new Dimension(400, 500));
			jContentPane.setLayout(borderLayout);
			jContentPane.add(getJPanelCENTER(), BorderLayout.CENTER);
			jContentPane.add(new JPanel(), BorderLayout.NORTH);
			jContentPane.add(new JPanel(), BorderLayout.WEST);
			jContentPane.add(new JPanel(), BorderLayout.EAST);
			jContentPane.add(getJPanelBotoes(), BorderLayout.SOUTH);
			jContentPane.setName("Cadastro de Cliente");
		}
		return jContentPane;
	}
	

	private JPanel getJPanelCENTER() {
		if(jPanelCENTER == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(5);
			borderLayout.setVgap(10);
			jPanelCENTER  = new JPanel();
			jPanelCENTER.setLayout(borderLayout);
			jPanelCENTER.add(getJPanelNamedForm(), BorderLayout.NORTH);
			jPanelCENTER.add(getJPanelNamedImpressaoDigital(), BorderLayout.CENTER);
//			jPanelCENTER.add(getJPanelBotoes(), BorderLayout.SOUTH);
		}
		return jPanelCENTER;
	}
	
	private JPanel getJPanelJTextFields() {
		if(jPanelJTextFields == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(5);
			gridLayout1.setVgap(10);
			gridLayout1.setColumns(1);
			jPanelJTextFields  = new JPanel();
			jPanelJTextFields.setLayout(gridLayout1);
			jPanelJTextFields.add(getJPanelNome(), null);
			jPanelJTextFields.add(getJPanelNascimento(), null);
			jPanelJTextFields.add(getJPanelEMail(), null);
			jPanelJTextFields.add(getJPanelTelefoneFixo(), null);
			jPanelJTextFields.add(getJPanelCelular(), null);
		}
		return jPanelJTextFields;
	}
	
	private JLabel getJLabelNome() {
		if(jLabelNome == null) {
			jLabelNome  = new JLabel();
			jLabelNome.setText("Nome:");
			jLabelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return jLabelNome;
	}
	
	private JTextField getJTextFieldNome() {
		if(jTextFieldNome == null) {
			jTextFieldNome  = new MyJTextField();
			jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					editarNascimento();
				}
			});
		}
		return jTextFieldNome;
	}
	
	private JButton getJButtonOk() {
		if(jButtonOk == null) {
			jButtonOk  = new JButton();
			jButtonOk.setText("Cadastrar");
			jButtonOk.addActionListener(getAcaoBotao());
		}
		return jButtonOk;
	}
	
	private ActionListener getAcaoBotao() {
		if(acaoBotao == null) {
			acaoBotao = new AcaoBotaoCadastrar(this);
		}
		return acaoBotao;
	}

	private void fecharTela() {
		jFrame.dispose();
	}

	private void editarNome() {
		jTextFieldNome.requestFocus();
	}

	private void editarNascimento() {
		jTextFieldDia.requestFocus();
	}

	private void editarMes() {
		jTextFieldMes.requestFocus();
	}

	private void editarAno() {
		jTextFieldAno.requestFocus();
	}

	private void editarEMail() {
		jTextFieldEMail.requestFocus();
	}

	private void editarTelefoneFixo() {
		jTextFieldTelefoneFixo.requestFocus();
	}

	private void editarCelular() {
		jTextFieldCelular.requestFocus();
	}
	
	/**
	 * This method initializes jPanelJLabels	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelJLabels() {
		if (jPanelJLabels == null) {
			jLabelCelular = new JLabel();
			jLabelCelular.setText("Celular:");
			jLabelCelular.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefoneFixo = new JLabel();
			jLabelTelefoneFixo.setText("Telefone Fixo:");
			jLabelTelefoneFixo.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelEMail = new JLabel();
			jLabelEMail.setText("e-mail:");
			jLabelEMail.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNascimento = new JLabel();
			jLabelNascimento.setText("Data de Nascimento:");
			jLabelNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(5);
			gridLayout.setVgap(10);
			gridLayout.setColumns(1);
			jPanelJLabels = new JPanel();
			jPanelJLabels.setLayout(gridLayout);
			jPanelJLabels.add(getJLabelNome(), null);
			jPanelJLabels.add(jLabelNascimento, null);
			jPanelJLabels.add(jLabelEMail, null);
			jPanelJLabels.add(jLabelTelefoneFixo, null);
			jPanelJLabels.add(jLabelCelular, null);
		}
		return jPanelJLabels;
	}

	/**
	 * This method initializes jPanelNome	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelNome() {
		if (jPanelNome == null) {
			jPanelNome = new JPanel();
			jPanelNome.setLayout(new BorderLayout());
			jPanelNome.add(getJTextFieldNome(), BorderLayout.CENTER);
		}
		return jPanelNome;
	}

	/**
	 * This method initializes jPanelNascimento	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelNascimento() {
		if (jPanelNascimento == null) {
			jLabelBarra2 = new JLabel();
			jLabelBarra2.setText("/ ");
			jLabelBarra2.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelBarra1 = new JLabel();
			jLabelBarra1.setText("  /");
			jLabelBarra1.setHorizontalAlignment(SwingConstants.CENTER);
			jPanelNascimento = new JPanel();
			jPanelNascimento.setLayout(new BorderLayout());
			jPanelNascimento.add(getJPanelGridLayoutNascimento(), BorderLayout.CENTER);
		}
		return jPanelNascimento;
	}

	/**
	 * This method initializes jTextFieldDia	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDia() {
		if (jTextFieldDia == null) {
			jTextFieldDia = new MyJTextField();
			jTextFieldDia.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					editarMes();
				}
			});
			jTextFieldDia.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					String conteudo = jTextFieldDia.getText();
					if(conteudo.length() >= 2) {
						jTextFieldDia.setText(conteudo.substring(0, 2));
						editarMes();
					}
				}
			});
		}
		return jTextFieldDia;
	}

	/**
	 * This method initializes jPanelEMail	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelEMail() {
		if (jPanelEMail == null) {
			jPanelEMail = new JPanel();
			jPanelEMail.setLayout(new BorderLayout());
			jPanelEMail.add(getJTextFieldEMail(), BorderLayout.CENTER);
		}
		return jPanelEMail;
	}

	/**
	 * This method initializes jPanelTelefoneFixo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelTelefoneFixo() {
		if (jPanelTelefoneFixo == null) {
			jPanelTelefoneFixo = new JPanel();
			jPanelTelefoneFixo.setLayout(new BorderLayout());
			jPanelTelefoneFixo.add(getJTextFieldTelefoneFixo(), BorderLayout.CENTER);
		}
		return jPanelTelefoneFixo;
	}

	/**
	 * This method initializes jPanelCelular	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCelular() {
		if (jPanelCelular == null) {
			jPanelCelular = new JPanel();
			jPanelCelular.setLayout(new BorderLayout());
			jPanelCelular.add(getJTextFieldCelular(), BorderLayout.CENTER);
		}
		return jPanelCelular;
	}

	/**
	 * This method initializes jTextFieldEMail	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldEMail() {
		if (jTextFieldEMail == null) {
			jTextFieldEMail = new MyJTextField();
			jTextFieldEMail.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					editarTelefoneFixo();
				}
			});
		}
		return jTextFieldEMail;
	}

	/**
	 * This method initializes jTextFieldTelefoneFixo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldTelefoneFixo() {
		if (jTextFieldTelefoneFixo == null) {
			jTextFieldTelefoneFixo = new MyJTextField();
			jTextFieldTelefoneFixo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					editarCelular();
				}
			});
		}
		return jTextFieldTelefoneFixo;
	}

	/**
	 * This method initializes jTextFieldCelular	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCelular() {
		if (jTextFieldCelular == null) {
			jTextFieldCelular = new MyJTextField();
			jTextFieldCelular.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jButtonOk.requestFocus();
				}
			});
		}
		return jTextFieldCelular;
	}

	/**
	 * This method initializes jTextFieldMes	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldMes() {
		if (jTextFieldMes == null) {
			jTextFieldMes = new MyJTextField();
			jTextFieldMes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					editarAno();
				}
			});
			jTextFieldMes.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					String conteudo = jTextFieldMes.getText();
					if(conteudo.length() >= 2) {
						jTextFieldMes.setText(conteudo.substring(0, 2));
						editarAno();
					}
				}
			});
		}
		return jTextFieldMes;
	}

	/**
	 * This method initializes jTextFieldAno	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAno() {
		if (jTextFieldAno == null) {
			jTextFieldAno = new MyJTextField();
			jTextFieldAno.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					editarEMail();
				}
			});
			jTextFieldAno.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					String conteudo = jTextFieldAno.getText();
					if(conteudo.length() >= 4) {
						jTextFieldAno.setText(conteudo.substring(0, 4));
						editarEMail();
					}
				}
			});
		}
		return jTextFieldAno;
	}

	/**
	 * This method initializes jPanelGridLayoutNascimento	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelGridLayoutNascimento() {
		if (jPanelGridLayoutNascimento == null) {
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setRows(1);
			gridLayout2.setColumns(3);
			jPanelGridLayoutNascimento = new JPanel();
			jPanelGridLayoutNascimento.setLayout(gridLayout2);
			jPanelGridLayoutNascimento.add(getJPanelDia(), null);
			jPanelGridLayoutNascimento.add(getJPanelMes(), null);
			jPanelGridLayoutNascimento.add(getJPanelAno(), null);
		}
		return jPanelGridLayoutNascimento;
	}

	/**
	 * This method initializes jPanelDia	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelDia() {
		if (jPanelDia == null) {
			jPanelDia = new JPanel();
			jPanelDia.setLayout(new BorderLayout());
			jPanelDia.add(getJTextFieldDia(), BorderLayout.CENTER);
			jPanelDia.add(jLabelBarra1, BorderLayout.EAST);
		}
		return jPanelDia;
	}

	/**
	 * This method initializes jPanelMes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelMes() {
		if (jPanelMes == null) {
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setHgap(4);
			jPanelMes = new JPanel();
			jPanelMes.setLayout(borderLayout1);
			jPanelMes.add(getJTextFieldMes(), BorderLayout.CENTER);
			jPanelMes.add(new JLabel(), BorderLayout.EAST);
			jPanelMes.add(new JLabel(), BorderLayout.WEST);
		}
		return jPanelMes;
	}

	/**
	 * This method initializes jPanelAno	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelAno() {
		if (jPanelAno == null) {
			jPanelAno = new JPanel();
			jPanelAno.setLayout(new BorderLayout());
			jPanelAno.add(jLabelBarra2, BorderLayout.WEST);
			jPanelAno.add(getJTextFieldAno(), java.awt.BorderLayout.CENTER);
		}
		return jPanelAno;
	}

	/**
	 * This method initializes jPanelNamedForm	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelNamedForm() {
		if (jPanelNamedForm == null) {
			BorderLayout borderLayout2 = new BorderLayout();
			borderLayout2.setHgap(15);
			borderLayout2.setVgap(0);
			jPanelNamedForm = new JPanel();
			jPanelNamedForm.setBorder(BorderFactory.createTitledBorder(null, "Dados do Cliente", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanelNamedForm.setLayout(borderLayout2);
			jPanelNamedForm.add(getJPanelForm(), BorderLayout.CENTER);
			jPanelNamedForm.add(new JPanel(), BorderLayout.NORTH);
			jPanelNamedForm.add(new JPanel(), BorderLayout.SOUTH);
			jPanelNamedForm.add(new JPanel(), BorderLayout.EAST);
			jPanelNamedForm.add(new JPanel(), BorderLayout.WEST);
		}
		return jPanelNamedForm;
	}

	/**
	 * This method initializes jPanelForm	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelForm() {
		if (jPanelForm == null) {
			BorderLayout borderLayout3 = new BorderLayout();
			borderLayout3.setHgap(15);
			borderLayout3.setVgap(10);
			jPanelForm = new JPanel();
			jPanelForm.setLayout(borderLayout3);
			jPanelForm.add(getJPanelFormText(), BorderLayout.NORTH);
		}
		return jPanelForm;
	}

	/**
	 * This method initializes jPanelImpressaoDigital	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelImpressaoDigital() {
		if (jPanelImpressaoDigital == null) {
			Identificacao identificacao = cadastradorClienteIndividual.getIdentificacao();
			ImpressaoDigital digital = (ImpressaoDigital)identificacao;
			jPanelImpressaoDigital = new JPanelViewImpressaoDigital(digital.getInfo());
			jPanelImpressaoDigital.setPreferredSize(new Dimension(110, 130));
		}
		return jPanelImpressaoDigital;
	}

	/**
	 * This method initializes jPanelLeft	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelLeft() {
		if (jPanelLeft == null) {
			jPanelLeft = new JPanel();
			jPanelLeft.setLayout(new BorderLayout());
			jPanelLeft.add(getJPanelJLabels(), BorderLayout.CENTER);
		}
		return jPanelLeft;
	}

	/**
	 * This method initializes jPanelRight	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelRight() {
		if (jPanelRight == null) {
			jPanelRight = new JPanel();
			jPanelRight.setLayout(new BorderLayout());
			jPanelRight.add(getJPanelJTextFields(), BorderLayout.CENTER);
		}
		return jPanelRight;
	}

	/**
	 * This method initializes jPanelNamedImpressaoDigital	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelNamedImpressaoDigital() {
		if (jPanelNamedImpressaoDigital == null) {
			BorderLayout borderLayout4 = new BorderLayout();
			borderLayout4.setVgap(3);
			borderLayout4.setHgap(15);
			jPanelNamedImpressaoDigital = new JPanel();
			jPanelNamedImpressaoDigital.setBorder(BorderFactory.createTitledBorder(null, "Impressão Digital", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanelNamedImpressaoDigital.setLayout(borderLayout4);
			jPanelNamedImpressaoDigital.setPreferredSize(new Dimension(100, 130));
			jPanelNamedImpressaoDigital.add(getJPanelCenter(), BorderLayout.CENTER);
			jPanelNamedImpressaoDigital.add(new JPanel(), java.awt.BorderLayout.NORTH);
			jPanelNamedImpressaoDigital.add(new JPanel(), java.awt.BorderLayout.SOUTH);
			jPanelNamedImpressaoDigital.add(new JPanel(), java.awt.BorderLayout.EAST);
			jPanelNamedImpressaoDigital.add(new JPanel(), java.awt.BorderLayout.WEST);
		}
		return jPanelNamedImpressaoDigital;
	}

	/**
	 * This method initializes jPanelFormText	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelFormText() {
		if (jPanelFormText == null) {
			jPanelFormText = new JPanel();
			jPanelFormText.setLayout(new BorderLayout());
			jPanelFormText.add(getJPanelLeft(), BorderLayout.WEST);
			jPanelFormText.add(getJPanelRight(), BorderLayout.CENTER);
		}
		return jPanelFormText;
	}

	/**
	 * This method initializes jScrollPaneDigital	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneDigital() {
		if (jScrollPaneDigital == null) {
			jScrollPaneDigital = new JScrollPane();
			jScrollPaneDigital.setViewportView(getJPanelImpressaoDigital());
		}
		return jScrollPaneDigital;
	}

	/**
	 * This method initializes jPanelCenter	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCenter() {
		if (jPanelCenter == null) {
			jPanelCenter = new JPanel();
			jPanelCenter.setLayout(new BorderLayout());
			jPanelCenter.add(getJScrollPaneDigital(), BorderLayout.WEST);
		}
		return jPanelCenter;
	}

	/**
	 * This method initializes jPanelBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBotoes() {
		if (jPanelBotoes == null) {
			BorderLayout borderLayout5 = new BorderLayout();
			borderLayout5.setHgap(40);
			jPanelBotoes = new JPanel();
			jPanelBotoes.setLayout(borderLayout5);
			jPanelBotoes.add(getJPanelCenterBotoes(), BorderLayout.CENTER);
			jPanelBotoes.add(new JPanel(), BorderLayout.WEST);
			jPanelBotoes.add(new JPanel(), BorderLayout.EAST);
			jPanelBotoes.add(new JPanel(), BorderLayout.SOUTH);
			jPanelBotoes.add(new JPanel(), BorderLayout.NORTH);
		}
		return jPanelBotoes;
	}

	/**
	 * This method initializes jPanelCenterBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCenterBotoes() {
		if (jPanelCenterBotoes == null) {
			GridLayout gridLayout3 = new GridLayout();
			gridLayout3.setRows(1);
			gridLayout3.setHgap(50);
			gridLayout3.setColumns(2);
			jPanelCenterBotoes = new JPanel();
			jPanelCenterBotoes.setLayout(gridLayout3);
			jPanelCenterBotoes.add(getJButtonOk(), null);
			jPanelCenterBotoes.add(getJButtonCancelar(), null);
		}
		return jPanelCenterBotoes;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cancelar();
				}
			});
		}
		return jButtonCancelar;
	}

	public static void main(String[] args) {
		CadastroClienteIndividualGui cadastroClienteIndividualGui = new CadastroClienteIndividualGui(null);
		cadastroClienteIndividualGui.exibir();
	}
	
	class AcaoBotaoCadastrar implements ActionListener {
		
		private TelaCadastro telaCadastro;
		
		public AcaoBotaoCadastrar(TelaCadastro telaCadastro) {
			this.telaCadastro = telaCadastro;
		}
		
		public void actionPerformed(ActionEvent e) {
			telaCadastro.confirmarCadastro();
		}
		
	}
	
	class AcaoBotaoEditar implements ActionListener {
		
		private TelaCadastro telaCadastro;
		
		public AcaoBotaoEditar(TelaCadastro telaCadastro) {
			this.telaCadastro = telaCadastro;
		}
		
		public void actionPerformed(ActionEvent e) {
			telaCadastro.confirmarEdicao();
		}
		
	}

	public void setNome(String nome) {
		jTextFieldNome.setText(nome);
	}

	public void setNascimento(String nascimento) {
		if(nascimento != null) {
			String dia = nascimento.substring(0, 2);
			String mes = nascimento.substring(3, 5);
			String ano = nascimento.substring(6, 10);
			jTextFieldDia.setText(dia);
			jTextFieldMes.setText(mes);
			jTextFieldAno.setText(ano);
		}
	}

	public void setTelefoneFixo(String telefoneFixo) {
		jTextFieldTelefoneFixo.setText(telefoneFixo);
	}

	public void setCelular(String celular) {
		jTextFieldCelular.setText(celular);
	}

	public void setEmail(String email) {
		jTextFieldEMail.setText(email);
	}

	public void editarCliente() {
		getJButtonOk().setText("Editar");
		getJButtonOk().removeActionListener(acaoBotao);
		acaoBotao = new AcaoBotaoEditar(this);
		getJButtonOk().addActionListener(acaoBotao);
	}
	
}
