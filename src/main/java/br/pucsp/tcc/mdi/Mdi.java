package br.pucsp.tcc.mdi;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.Stack;

public class Mdi {

	private JFrame jFrame = null;
	private JPanel jContentPane = null;
	private Stack<JPanel> pilha = null;
	
	public Mdi() {
		pilha = new Stack<JPanel>();
	}

	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setSize(new Dimension(301, 170));
		}
		return jFrame;
	}

	public void dispose() {
		pilha.pop();
		setVisible(true);
	}

	public void setVisible(boolean b) {
		JPanel contentPane = pilha.lastElement();
		if(pilha.isEmpty()) {
			getJFrame().dispose();
		}
		else {
			getJFrame().setContentPane(contentPane);
			getJFrame().setVisible(true);
		}
	}

	public void setContentPane(JPanel contentPane) {
		pilha.add(contentPane);
	}

}
