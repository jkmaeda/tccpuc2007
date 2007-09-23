package br.pucsp.tcc.cadastrarClienteGui;

import java.awt.BorderLayout;

import br.pucsp.tcc.cadastrarCliente.CadastradorCliente;
import br.pucsp.tcc.cadastrarCliente.FactoryCadastradorCliente;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastrarClienteMesaGui extends Tela {

	private JPanel jContentPane = null;
	private FactoryCadastradorCliente factoryCadastradorCliente;
	private JButton jButtonAdicionarClienteIndividual = null;
	private JPanel jPanelNumeroMesa = null;
	private JLabel jLabelNumeroMesa = null;
	private JTextField jTextFieldNumeroMesa = null;
	private JButton jButtonEditarMesa = null;
	
	public CadastrarClienteMesaGui(FactoryCadastradorCliente factoryCadastradorCliente) {
		super();
		this.factoryCadastradorCliente = factoryCadastradorCliente;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setSize(600, 400);
		this.setTitle("Cadastrar Cliente Mesa");
		this.centralizar();
		this.exibir();
		capturarNumeroMesa();
	}
	
	private void capturarNumeroMesa() {
		//TODO refactory da entrada de número de mesa
		int numero = 0;
		boolean falhou = true;
		while(falhou) {
			falhou = false;
			try {
				numero = Integer.parseInt((String)JOptionPane.showInputDialog(null, "Digite o número da mesa", "Número da mesa", JOptionPane.INFORMATION_MESSAGE, null, null, null));
			}
			catch (Exception e) {
				falhou = true;
			}
		}
		jTextFieldNumeroMesa.setText(numero+"");
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
			jContentPane.add(getJPanelNumeroMesa(), BorderLayout.NORTH);
			jContentPane.add(getJButtonAdicionarClienteIndividual(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonAdicionarClienteIndividual	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAdicionarClienteIndividual() {
		if (jButtonAdicionarClienteIndividual == null) {
			jButtonAdicionarClienteIndividual = new JButton();
			jButtonAdicionarClienteIndividual.setText("Adicionar Cliente Individual");
			jButtonAdicionarClienteIndividual
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							CadastradorCliente cadastradorCliente = factoryCadastradorCliente.fabricarCadastradorClienteIndividual();
							cadastradorCliente.cadastrarCliente();
						}
					});
		}
		return jButtonAdicionarClienteIndividual;
	}

	/**
	 * This method initializes jPanelNumeroMesa	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelNumeroMesa() {
		if (jPanelNumeroMesa == null) {
			jLabelNumeroMesa = new JLabel();
			jLabelNumeroMesa.setText("Número da Mesa:");
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(5);
			jPanelNumeroMesa = new JPanel();
			jPanelNumeroMesa.setLayout(borderLayout);
			jPanelNumeroMesa.add(jLabelNumeroMesa, BorderLayout.WEST);
			jPanelNumeroMesa.add(getJTextFieldNumeroMesa(), BorderLayout.CENTER);
			jPanelNumeroMesa.add(getJButtonEditarMesa(), BorderLayout.EAST);
		}
		return jPanelNumeroMesa;
	}

	/**
	 * This method initializes jTextFieldNumeroMesa	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNumeroMesa() {
		if (jTextFieldNumeroMesa == null) {
			jTextFieldNumeroMesa = new JTextField();
			jTextFieldNumeroMesa.setEditable(false);
		}
		return jTextFieldNumeroMesa;
	}

	/**
	 * This method initializes jButtonEditarMesa	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEditarMesa() {
		if (jButtonEditarMesa == null) {
			jButtonEditarMesa = new JButton();
			jButtonEditarMesa.setText("Editar");
			jButtonEditarMesa.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					capturarNumeroMesa();
				}
			});
		}
		return jButtonEditarMesa;
	}
}
