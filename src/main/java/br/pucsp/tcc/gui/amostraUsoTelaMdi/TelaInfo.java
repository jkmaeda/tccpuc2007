package br.pucsp.tcc.gui.amostraUsoTelaMdi;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextPane;

import br.pucsp.tcc.gui.mdi.Mdi;
import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;
import javax.swing.JButton;

public class TelaInfo {

	private Mdi jFrame = null;
	private JPanel jContentPane = null;
	private JTextPane jTextPane = null;
	private JButton jButton = null;

	public TelaInfo() {
		jFrame = getJFrame();
	}
	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private Mdi getJFrame() {
		if (jFrame == null) {
			jFrame = FactorySingletonMdi.Construir();
//			jFrame.setSize(new Dimension(341, 168));
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
			jContentPane.setName("Tela Info");
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTextPane(), BorderLayout.CENTER);
			jContentPane.add(getJButton(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setText("Este é uma tela de exemplo, após a exibição desta tela, a tela anterior deverá ser exibida novamente.");
			jTextPane.setEditable(false);
		}
		return jTextPane;
	}

	public void exibir() {
		getJFrame().setVisible(true);
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("OK");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getJFrame().dispose();
				}
			});
		}
		return jButton;
	}

}
