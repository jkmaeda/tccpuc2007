package br.pucsp.tcc.gui.cadastrarCliente.impl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.pucsp.tcc.gui.cadastrarCliente.CadastrarClienteIndividual;
import br.pucsp.tcc.gui.cadastrarCliente.TelaCadastro;
import br.pucsp.tcc.mdi.Mdi;

import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroClienteIndividualGui extends Tela implements TelaCadastro {

	private CadastrarClienteIndividual cadastradorClienteIndividual;
	private JPanel jContentPane = null;
	private Mdi jFrame = null;
	private JPanel jPanelCENTER = null;
	private JPanel jPanelNome = null;
	private JLabel jLabelNome = null;
	private JTextField jTextFieldNome = null;
	private JButton jButtonOk = null;

	public CadastroClienteIndividualGui(CadastrarClienteIndividual cadastradorClienteIndividual) {
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
	}

	@Override
	public void exibir() {
		getJFrame().setVisible(true);
	}

	public void confirmarCadastro() {
		cadastradorClienteIndividual.setNome(jTextFieldNome.getText());
		cadastradorClienteIndividual.salvarCadastro();
		fecharTela();
	}
	
	private Mdi getJFrame() {
		if(jFrame  == null) {
			jFrame = new Mdi();
//			jFrame.setSize(400, 150);
//			jFrame.setTitle("Cadastrar Cliente");
			jFrame.setContentPane(getJContentPane());
//			centralizar(jFrame);
		}
		return jFrame;
	}

	private JPanel getJContentPane() {
		if(jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(3);
			borderLayout.setVgap(3);
			jContentPane  = new JPanel();
			jContentPane.setLayout(borderLayout);
			jContentPane.add(getJPanelCENTER(), BorderLayout.CENTER);
			jContentPane.add(new JPanel(), BorderLayout.NORTH);
			jContentPane.add(new JPanel(), BorderLayout.WEST);
			jContentPane.add(new JPanel(), BorderLayout.EAST);
			jContentPane.add(new JPanel(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	

	private JPanel getJPanelCENTER() {
		if(jPanelCENTER == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(5);
			borderLayout.setVgap(15);
			jPanelCENTER  = new JPanel();
			jPanelCENTER.setLayout(borderLayout);
			jPanelCENTER.add(getJPanelNome(), BorderLayout.NORTH);
			jPanelCENTER.add(getJButtonOk(), BorderLayout.CENTER);
		}
		return jPanelCENTER;
	}
	
	private JPanel getJPanelNome() {
		if(jPanelNome == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(5);
			borderLayout.setVgap(5);
			jPanelNome  = new JPanel();
			jPanelNome.setLayout(borderLayout);
			jPanelNome.add(getJLabelNome(), BorderLayout.WEST);
			jPanelNome.add(getJTextFieldNome(), BorderLayout.CENTER);
		}
		return jPanelNome;
	}
	
	private JLabel getJLabelNome() {
		if(jLabelNome == null) {
			jLabelNome  = new JLabel();
			jLabelNome.setText("Nome:");
		}
		return jLabelNome;
	}
	
	private JTextField getJTextFieldNome() {
		if(jTextFieldNome == null) {
			jTextFieldNome  = new JTextField();
			jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					confirmarCadastro();
				}
			});
		}
		return jTextFieldNome;
	}
	
	private JButton getJButtonOk() {
		if(jButtonOk == null) {
			jButtonOk  = new JButton();
			jButtonOk.setText("OK");
			jButtonOk.addActionListener(new AcaoBotaoOk(this));
		}
		return jButtonOk;
	}
	
	private void fecharTela() {
		jFrame.dispose();
	}
	
	public static void main(String[] args) {
		CadastroClienteIndividualGui cadastroClienteIndividualGui = new CadastroClienteIndividualGui(null);
		cadastroClienteIndividualGui.exibir();
	}
	
	class AcaoBotaoOk implements ActionListener {
		
		private TelaCadastro telaCadastro;
		
		public AcaoBotaoOk(TelaCadastro telaCadastro) {
			this.telaCadastro = telaCadastro;
		}
		
		public void actionPerformed(ActionEvent e) {
			telaCadastro.confirmarCadastro();
		}
		
	}
	
}
