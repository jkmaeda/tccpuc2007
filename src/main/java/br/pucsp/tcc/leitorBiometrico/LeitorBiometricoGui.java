package br.pucsp.tcc.leitorBiometrico;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

import br.pucsp.tcc.gui.gerarIdentificacao.IdentificadorCliente;
import br.pucsp.tcc.gui.gerarIdentificacao.IdentificarClienteExibir;
import br.pucsp.tcc.gui.gerarIdentificacao.LeitorBiometrico;

public class LeitorBiometricoGui implements LeitorBiometrico {

	private JFrame jFrame = null;
	private JPanel jContentPane = null;
	private JPanel jPanelCENTER = null;
	private JTextField jTextFieldCodigo = null;
	private JButton jButtonOk = null;
	private IdentificadorCliente identificadorCliente = null;  //  @jve:decl-index=0:

	public LeitorBiometricoGui(IdentificadorCliente identificadorCliente) {
		this.identificadorCliente = identificadorCliente;
	}
	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setSize(new Dimension(347, 71));
			centralizar(jFrame);
			jFrame.setTitle("Leitor Biométrico (Digite o código biométrico)");
			jFrame.setContentPane(getJContentPane());
		}
		return jFrame;
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
			jContentPane.add(getJPanelCENTER(), BorderLayout.CENTER);
			jContentPane.add(new JPanel(), BorderLayout.NORTH);
			jContentPane.add(new JPanel(), BorderLayout.SOUTH);
			jContentPane.add(new JPanel(), BorderLayout.EAST);
			jContentPane.add(new JPanel(), BorderLayout.WEST);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelCENTER	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCENTER() {
		if (jPanelCENTER == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(8);
			borderLayout.setVgap(8);
			jPanelCENTER = new JPanel();
			jPanelCENTER.setLayout(borderLayout);
			jPanelCENTER.add(getJTextFieldCodigo(), BorderLayout.CENTER);
			jPanelCENTER.add(getJButtonOk(), BorderLayout.EAST);
		}
		return jPanelCENTER;
	}

	/**
	 * This method initializes jTextFieldCodigo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCodigo() {
		if (jTextFieldCodigo == null) {
			jTextFieldCodigo = new JTextField();
			jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					identificarCliente();
					getJFrame().dispose();
				}
			});
		}
		return jTextFieldCodigo;
	}

	/**
	 * This method initializes jButtonOk	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOk() {
		if (jButtonOk == null) {
			jButtonOk = new JButton();
			jButtonOk.setText("OK");
			jButtonOk.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					identificarCliente();
					getJFrame().dispose();
				}
			});
		}
		return jButtonOk;
	}
	
	private void identificarCliente() {
		identificadorCliente.identificarCliente(jTextFieldCodigo.getText());
	}
	
	public void exibir() {
		getJFrame().setVisible(true);
	}
	
	public void habilitar() {
		exibir();
	}
	
	public static void main(String[] args) {
		IdentificadorCliente identificador = new IdentificarClienteExibir();
		LeitorBiometricoGui leitorBiometricoGui =  new LeitorBiometricoGui(identificador);
		leitorBiometricoGui.exibir();
	}
	
	protected void centralizar(Component component){
  	    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
  	    Dimension compSize = component.getSize();
  	    int centerX = (screenDim.width - compSize.width) >> 1;
  	    int centerY = (screenDim.height - compSize.height) >> 1;
  	    component.setLocation(centerX, centerY);
	}

}
