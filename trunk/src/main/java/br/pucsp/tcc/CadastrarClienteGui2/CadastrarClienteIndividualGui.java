package br.pucsp.tcc.CadastrarClienteGui2;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.util.Random;

public class CadastrarClienteIndividualGui extends Tela {

	private JPanel jContentPane = null;
	private JPanel jPanelNome = null;
	private JLabel jLabelNome = null;
	private JTextField jTextFieldNome = null;
	private JButton jButtonCapturarImpressaoDigital = null;
	private JButton jButtonConfirmarCadastro = null;
	
	public CadastrarClienteIndividualGui() {
		super();
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastrar Cliente");
		this.centralizar();
		this.exibir();
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setVgap(5);
			jContentPane = new JPanel();
			jContentPane.setLayout(borderLayout1);
			jContentPane.add(getJPanelNome(), BorderLayout.NORTH);
			jContentPane.add(getJButtonCapturarImpressaoDigital(), BorderLayout.CENTER);
			jContentPane.add(getJButtonConfirmarCadastro(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelNome	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelNome() {
		if (jPanelNome == null) {
			jLabelNome = new JLabel();
			jLabelNome.setText("Nome");
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(5);
			jPanelNome = new JPanel();
			jPanelNome.setLayout(borderLayout);
			jPanelNome.add(jLabelNome, BorderLayout.WEST);
			jPanelNome.add(getJTextFieldNome(), BorderLayout.CENTER);
		}
		return jPanelNome;
	}

	/**
	 * This method initializes jTextFieldNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNome() {
		if (jTextFieldNome == null) {
			jTextFieldNome = new JTextField();
			jTextFieldNome.setEditable(false);
		}
		return jTextFieldNome;
	}

	/**
	 * This method initializes jButtonCapturarImpressaoDigital	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCapturarImpressaoDigital() {
		if (jButtonCapturarImpressaoDigital == null) {
			jButtonCapturarImpressaoDigital = new JButton();
			jButtonCapturarImpressaoDigital.setText("Capturar impressão Digital");
			jButtonCapturarImpressaoDigital
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							//TODO implementar a verificação de clientes já cadastrados
							Random random = new Random();
							int aleatorio = random.nextInt(2);
							if(aleatorio == 1) {
								//Cliente já cadastrado
								jButtonCapturarImpressaoDigital.setBackground(null);
								JOptionPane.showMessageDialog(null, "Cliente já cadastrado");
								jButtonCapturarImpressaoDigital.setBackground(Color.GREEN);
								jTextFieldNome.setText("Fulano da Silva Sauro");
							}
							else {
								//TODO impementar a confirmação da captura de impessão digital
								jTextFieldNome.setText(null);
								int aleatorio2 = random.nextInt(2);
								if(aleatorio2 == 1) {
									//capturado com sucesso, digitar o nome
									jButtonCapturarImpressaoDigital.setBackground(Color.GREEN);
									String nome = (String)JOptionPane.showInputDialog(null, "Digite o nome do cliente", "Nome", JOptionPane.INFORMATION_MESSAGE, null, null, null);
									jTextFieldNome.setText(nome);
								}
								else {
									//Erro de captura
									jButtonCapturarImpressaoDigital.setBackground(Color.RED);
								}
							}
						}
					});
		}
		return jButtonCapturarImpressaoDigital;
	}

	/**
	 * This method initializes jButtonConfirmarCadastro	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonConfirmarCadastro() {
		if (jButtonConfirmarCadastro == null) {
			jButtonConfirmarCadastro = new JButton();
			jButtonConfirmarCadastro.setText("Confirmar Cadastro");
			jButtonConfirmarCadastro.setPreferredSize(new Dimension(200, 200));
		}
		return jButtonConfirmarCadastro;
	}
}
