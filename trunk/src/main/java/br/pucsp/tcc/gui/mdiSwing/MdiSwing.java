package br.pucsp.tcc.gui.mdiSwing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.pucsp.tcc.gui.mdi.Mdi;

import java.awt.Dimension;
import java.util.Stack;
import javax.swing.JSplitPane;

import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.JScrollPane;

public class MdiSwing implements Mdi {

	private JFrame jFrame = null;
	private JPanel jContentPane = null;
	private Stack<JPanel> pilha = null;
	private JSplitPane jSplitPane = null;
	private JPanel jPanelLEFT = null;
	private JPanel jPanelBotoes = null;
	private JButton jButtonGerenciamentoDeClientes = null;
	private JButton jButtonPreferencias = null;
	private JButton jButtonGerenciamentoDePedidos = null;
	private JButton jButtonGerenciamentoDeContas = null;
	private JScrollPane jScrollPane = null;
	public MdiSwing() {
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pilha = getPilha();
	}

	private Stack<JPanel> getPilha() {
		if(pilha == null) {
			pilha = new Stack<JPanel>();
		}
		return pilha;
	}

	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setContentPane(getJSplitPane());
			jFrame.setSize(new Dimension(812, 527));
			centerComponent(jFrame);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		return jFrame;
	}

	public void dispose() {
		if(jContentPane != null) {
			getJFrame().remove(jContentPane);
			pilha.remove(jContentPane);
		}
		setVisible(true);
	}

	public void setVisible(boolean visivel) {
		if(visivel) {
			if(pilha.isEmpty()) {
				getJFrame().dispose();
			}
			else {
				jContentPane = pilha.lastElement();
				getJScrollPane().setViewportView(jContentPane);
				getJFrame().setTitle(jContentPane.getName());
				getJFrame().setVisible(visivel);
			}
		}
		else {
			getJFrame().setVisible(visivel);
		}
	}

	public void setContentPane(JPanel contentPane) {
		pilha.push(contentPane);
	}

	public void setTitle(String title) {
		getJFrame().setTitle(title);
	}

	/**
	 * This method initializes jSplitPane	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setLeftComponent(getJPanelLEFT());
			jSplitPane.setRightComponent(getJScrollPane());
			jSplitPane.setOneTouchExpandable(true);
		}
		return jSplitPane;
	}

	/**
	 * This method initializes jPanelLEFT	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelLEFT() {
		if (jPanelLEFT == null) {
			jPanelLEFT = new JPanel();
			jPanelLEFT.setLayout(new BorderLayout());
			jPanelLEFT.add(getJPanelBotoes(), BorderLayout.CENTER);
			jPanelLEFT.add(new JPanel(), BorderLayout.NORTH);
			jPanelLEFT.add(new JPanel(), BorderLayout.SOUTH);
			jPanelLEFT.add(new JPanel(), BorderLayout.EAST);
			jPanelLEFT.add(new JPanel(), BorderLayout.WEST);
		}
		return jPanelLEFT;
	}

	/**
	 * This method initializes jPanelBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBotoes() {
		if (jPanelBotoes == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(4);
			gridLayout.setVgap(5);
			gridLayout.setColumns(1);
			gridLayout.setHgap(5);
			jPanelBotoes = new JPanel();
			jPanelBotoes.setLayout(gridLayout);
			jPanelBotoes.add(getJButtonGerenciamentoDeClientes(), null);
			jPanelBotoes.add(getJButtonPreferencias(), null);
			jPanelBotoes.add(getJButtonGerenciamentoDePedidos(), null);
			jPanelBotoes.add(getJButtonGerenciamentoDeContas(), null);
		}
		return jPanelBotoes;
	}

	/**
	 * This method initializes jButtonGerenciamentoDeClientes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGerenciamentoDeClientes() {
		if (jButtonGerenciamentoDeClientes == null) {
			jButtonGerenciamentoDeClientes = new JButton();
			jButtonGerenciamentoDeClientes.setText("Gerenciamento de Clientes");
		}
		return jButtonGerenciamentoDeClientes;
	}

	/**
	 * This method initializes jButtonPreferencias	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPreferencias() {
		if (jButtonPreferencias == null) {
			jButtonPreferencias = new JButton();
			jButtonPreferencias.setText("Preferências");
		}
		return jButtonPreferencias;
	}

	/**
	 * This method initializes jButtonGerenciamentoDePedidos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGerenciamentoDePedidos() {
		if (jButtonGerenciamentoDePedidos == null) {
			jButtonGerenciamentoDePedidos = new JButton();
			jButtonGerenciamentoDePedidos.setText("Gerenciamento de Pedidos");
		}
		return jButtonGerenciamentoDePedidos;
	}

	/**
	 * This method initializes jButtonGerenciamentoDeContas	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGerenciamentoDeContas() {
		if (jButtonGerenciamentoDeContas == null) {
			jButtonGerenciamentoDeContas = new JButton();
			jButtonGerenciamentoDeContas.setText("Gerenciamento de Contas");
		}
		return jButtonGerenciamentoDeContas;
	}
	
	private void centerComponent(Component comp) {
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension compSize = comp.getSize();
		int centerX = (screenDim.width - compSize.width) >> 1;
		int centerY = (screenDim.height - compSize.height) >> 2;
		comp.setLocation(centerX, centerY);
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
		}
		return jScrollPane;
	}

}
