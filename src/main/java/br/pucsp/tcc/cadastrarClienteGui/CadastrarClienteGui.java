package br.pucsp.tcc.cadastrarClienteGui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

import br.pucsp.tcc.cadastrarCliente.CadastradorCliente;
import br.pucsp.tcc.cadastrarCliente.FactoryCadastradorCliente;

public class CadastrarClienteGui extends Tela {

	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JButton jButtonClienteIndiviual = null;
	private JButton jButtonClienteMesa = null;
	private FactoryCadastradorCliente factoryCadastradorCliente;
	
	public CadastrarClienteGui(FactoryCadastradorCliente factoryCadastradorCliente) {
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
		this.setSize(600, 400);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastrar Cliente");
		this.centralizar();
		this.exibir();
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(1);
			jPanel = new JPanel();
			jPanel.setLayout(gridLayout);
			jPanel.add(getJButtonClienteIndiviual(), null);
			jPanel.add(getJButtonClienteMesa(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jButtonClienteIndiviual	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonClienteIndiviual() {
		if (jButtonClienteIndiviual == null) {
			jButtonClienteIndiviual = new JButton();
			jButtonClienteIndiviual.setText("Cadastrar Cliente Individual");
			jButtonClienteIndiviual.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					CadastradorCliente cadastradorCliente = factoryCadastradorCliente.fabricarCadastradorClienteIndividual();
					cadastradorCliente.cadastrarCliente();
				}
			});
		}
		return jButtonClienteIndiviual;
	}
	/**
	 * This method initializes jButtonClienteMesa	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonClienteMesa() {
		if (jButtonClienteMesa == null) {
			jButtonClienteMesa = new JButton();
			jButtonClienteMesa.setText("Cadastrar Cliente Mesa");
			jButtonClienteMesa.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					CadastradorCliente cadastradorCliente = factoryCadastradorCliente.fabricarCadastradorClienteMesa();
					cadastradorCliente.cadastrarCliente();
				}
			});
		}
		return jButtonClienteMesa;
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
}