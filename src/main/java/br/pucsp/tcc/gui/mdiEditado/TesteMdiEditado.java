package br.pucsp.tcc.gui.mdiEditado;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;

import br.pucsp.tcc.gui.mdi.Mdi;
import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;

public class TesteMdiEditado {

	private Mdi jFrame = null;
	private JPanel jContentPane = null;
	private JTextPane jTextPane = null;
	
	public TesteMdiEditado() {
		jFrame = getJFrame();
	}
	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private Mdi getJFrame() {
		if (jFrame == null) {
			jFrame = FactorySingletonMdi.Contruir();
//			jFrame.setSize(new Dimension(307, 154));
			jFrame.setContentPane(getJContentPane());
			jFrame.setVisible(true);
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
			jContentPane.add(getJTextPane(), BorderLayout.CENTER);
			jContentPane.setName("Comanda Digital");
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
			jTextPane.setText("As telas são colocadas aqui dentro.\n\nTudo que está por fora deste quadro nunca se altera.");
		}
		return jTextPane;
	}

	public static void main(String[] args) {
		new TesteMdiEditado();
	}

}
