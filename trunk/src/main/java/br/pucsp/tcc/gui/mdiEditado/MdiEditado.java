package br.pucsp.tcc.gui.mdiEditado;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Dimension;
import java.util.Stack;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import br.pucsp.tcc.aplicacao.ComandaDigital;
import br.pucsp.tcc.gui.mdi.Mdi;

public class MdiEditado implements Mdi {

	private JFrame jFrame = null;
	private JPanel jContentPane = null;
	private Stack<JPanel> pilha = null;  //  @jve:decl-index=0:
	private JPanel jPanelMain = null;
	private JPanel jPanel = null;
	private JButton jButtonGerenciamentoDePedidos = null;
	private JButton jButtonGerenciamentoDeClientes = null;
	private JButton jButtonGerenciamentoDeConta = null;
	private JButton jButtonPreferencias = null;
	private ComandaDigital comandaDigital;  //  @jve:decl-index=0:
	
	public MdiEditado() {
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
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
			jFrame.setSize(new Dimension(968, 570));
			jFrame.setResizable(false);
			centerComponent(jFrame);
			jFrame.setContentPane(getJPanelMain());
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
//				getJPanel().removeAll();
//				getJFrame().setVisible(visivel);
			}
			else {
				jContentPane = pilha.lastElement();
				getJPanel().removeAll();
				getJPanel().add(jContentPane, BorderLayout.CENTER);
				getJFrame().setTitle(jContentPane.getName());
				getJFrame().repaint();
//				getJFrame().printAll(getJFrame().getGraphics());
				getJFrame().setVisible(true);
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
	
	private void centerComponent(Component comp) {
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension compSize = comp.getSize();
		int centerX = (screenDim.width - compSize.width) >> 1;
		int centerY = (screenDim.height - compSize.height) >> 2;
		comp.setLocation(centerX, centerY);
	}
	
	/**
	 * This method initializes jPanelMain
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelMain() {
		if (jPanelMain == null) {
			jPanelMain = new MyPicturePanel();
			jPanelMain.setLayout(null);
			jPanelMain.add(getJPanel(), null);
			jPanelMain.add(getJButtonGerenciamentoDePedidos(), null);
			jPanelMain.add(getJButtonGerenciamentoDeClientes(), null);
			jPanelMain.add(getJButtonGerenciamentoDeConta(), null);
			jPanelMain.add(getJButtonPreferencias(), null);
		}
		return jPanelMain;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new BorderLayout());
			jPanel.setBounds(new Rectangle(435, 31, 496, 480));
			jPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		}
		return jPanel;
	}

	/**
	 * This method initializes jButtonGerenciamentoDePedidos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGerenciamentoDePedidos() {
		if (jButtonGerenciamentoDePedidos == null) {
			jButtonGerenciamentoDePedidos = new JButton();
			jButtonGerenciamentoDePedidos.setBounds(new Rectangle(124, 271, 274, 100));
			jButtonGerenciamentoDePedidos.setPressedIcon(new ImageIcon("imagens\\gerenciamentoDePedidosClicado.png"));
			jButtonGerenciamentoDePedidos.setIcon(new ImageIcon("imagens\\gerenciamentoDePedidos.png"));
//			Deixa o fundo do botão transparente 
			jButtonGerenciamentoDePedidos.setContentAreaFilled(false);
//			Tira a borda do botão 
			jButtonGerenciamentoDePedidos.setBorderPainted(false);
//			Tira borda desenhada em volta do label do botão
			jButtonGerenciamentoDePedidos.setFocusPainted(false);
			jButtonGerenciamentoDePedidos
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							comandaDigital.registrarPedido();
						}
					});
		}
		return jButtonGerenciamentoDePedidos;
	}

	/**
	 * This method initializes jButtonGerenciamentoDeClientes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGerenciamentoDeClientes() {
		if (jButtonGerenciamentoDeClientes == null) {
			jButtonGerenciamentoDeClientes = new JButton();
			jButtonGerenciamentoDeClientes.setBounds(new Rectangle(94, 29, 285, 99));
			jButtonGerenciamentoDeClientes.setPressedIcon(new ImageIcon("imagens\\gerenciamentoDeClientesClicado.png"));
			jButtonGerenciamentoDeClientes.setIcon(new ImageIcon("imagens\\gerenciamentoDeClientes.png"));
//			Deixa o fundo do botão transparente 
			jButtonGerenciamentoDeClientes.setContentAreaFilled(false);
//			Tira a borda do botão 
			jButtonGerenciamentoDeClientes.setBorderPainted(false);
//			Tira borda desenhada em volta do label do botão
			jButtonGerenciamentoDeClientes.setFocusPainted(false);
			jButtonGerenciamentoDeClientes
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							comandaDigital.cadastrarCliente();
						}
					});
		}
		return jButtonGerenciamentoDeClientes;
	}

	/**
	 * This method initializes jButtonGerenciamentoDeConta	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGerenciamentoDeConta() {
		if (jButtonGerenciamentoDeConta == null) {
			jButtonGerenciamentoDeConta = new JButton();
			jButtonGerenciamentoDeConta.setBounds(new Rectangle(61, 397, 280, 100));
			jButtonGerenciamentoDeConta.setPressedIcon(new ImageIcon("imagens\\gerenciamentoDeContaClicado.png"));
			jButtonGerenciamentoDeConta.setIcon(new ImageIcon("imagens\\gerenciamentoDeConta.png"));
//			Deixa o fundo do botão transparente 
			jButtonGerenciamentoDeConta.setContentAreaFilled(false);
//			Tira a borda do botão 
			jButtonGerenciamentoDeConta.setBorderPainted(false);
//			Tira borda desenhada em volta do label do botão
			jButtonGerenciamentoDeConta.setFocusPainted(false);
			jButtonGerenciamentoDeConta
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							comandaDigital.fecharConta();						}
					});
		}
		return jButtonGerenciamentoDeConta;
	}

	/**
	 * This method initializes jButtonPreferencias	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPreferencias() {
		if (jButtonPreferencias == null) {
			jButtonPreferencias = new JButton();
			jButtonPreferencias.setBounds(new Rectangle(43, 157, 273, 100));
			jButtonPreferencias.setPressedIcon(new ImageIcon("imagens\\PreferenciasClicado.png"));
			jButtonPreferencias.setIcon(new ImageIcon("imagens\\Preferencias.png"));
//			Deixa o fundo do botão transparente 
			jButtonPreferencias.setContentAreaFilled(false);
//			Tira a borda do botão 
			jButtonPreferencias.setBorderPainted(false);
//			Tira borda desenhada em volta do label do botão
			jButtonPreferencias.setFocusPainted(false);
			jButtonPreferencias.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					comandaDigital.editarPreferencias();
				}
			});
		}
		return jButtonPreferencias;
	}

	public void setComandaDigital(ComandaDigital comandaDigital) {
		this.comandaDigital = comandaDigital;
	}
	
	public void trocar(Mdi mdi) {
		mdi.setPilha(pilha);
		getJFrame().dispose();
		mdi.setComandaDigital(comandaDigital);
		mdi.setVisible(true);
		mdi.dispose();
	}

	public void setPilha(Stack<JPanel> pilha) {
		this.pilha = pilha;
	}

	public String getEstilo() {
		return Mdi.COLOR;
	}

}
