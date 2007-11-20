package br.pucsp.tcc.gui.registrarPedido.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;
import br.pucsp.tcc.gui.mdi.Mdi;
import br.pucsp.tcc.gui.registrarPedido.RegistrarPedidos;
import br.pucsp.tcc.modelo.Cardapio;
import br.pucsp.tcc.modelo.ItemCardapio;
import java.awt.GridBagLayout;

public class RegistradorPedidosGui 
	implements RegistrarPedidosGui {

	private RegistrarPedidos registradorPedidos;  //  @jve:decl-index=0:
	private Mdi jFrame = null;
	private JPanel jContentPane = null;
	private JPanel jPanelCENTER = null;
	private GridLayout gridLayout;
	private JScrollPane jScrollPane = null;
	private JPanel jPanelFinalizarPedido = null;
	private JButton jButtonFinalizarPedido = null;
	private JPanel jPanelBotoes = null;
	private JButton jButtonCancelar = null;
	
	private JPanel getJPanelFinalizarPedido() {
		if(jPanelFinalizarPedido == null) {
			jPanelFinalizarPedido = new JPanel();
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(40);
//			borderLayout.setVgap(5);
			jPanelFinalizarPedido.setLayout(borderLayout);
			jPanelFinalizarPedido.add(getJPanelBotoes(), BorderLayout.CENTER);
			jPanelFinalizarPedido.add(new JPanel(), BorderLayout.EAST);
			jPanelFinalizarPedido.add(new JPanel(), BorderLayout.WEST);
			jPanelFinalizarPedido.add(new JPanel(), BorderLayout.NORTH);
			jPanelFinalizarPedido.add(new JPanel(), BorderLayout.SOUTH);
		}
		return jPanelFinalizarPedido;
	}

	private JButton getJButtonFinalizarPedido() {
		if(jButtonFinalizarPedido == null) {
			jButtonFinalizarPedido = new JButton();
			jButtonFinalizarPedido.setText("Finalizar Pedido");
//			jButtonFinalizarPedido.setMinimumSize(new Dimension(100, 60));
//			jButtonFinalizarPedido.setPreferredSize(new Dimension(100, 60));
			jButtonFinalizarPedido.addActionListener(new AcaoBotaoFinalizar());			
		}
		return jButtonFinalizarPedido;
	}

	private JScrollPane getJScrollPane() {
		if(jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJPanelCENTER());
		}
		return jScrollPane;
	}

	public RegistradorPedidosGui() {
		jFrame = getJFrame();
//		centralizar(jFrame);
	}
	
	public void exibir() {
//		getJFrame().setVisible(true);
		FactorySingletonMdi.Construir().setVisible(true);
	}

	public void setRegistradorPedidos(RegistrarPedidos registradorPedidos) {
		this.registradorPedidos = registradorPedidos;
	}

	public void setCardapio(Cardapio cardapio) {
		List<ItemCardapio> itensCardapio = cardapio.getItensCardapio();
		gridLayout.setRows(itensCardapio.size());
		jPanelCENTER.setLayout(gridLayout);
		for(ItemCardapio item : itensCardapio) {
			JPanel itemCardapioVisual = new ItemCardapioVisual(item, registradorPedidos);
			getJPanelCENTER().add(itemCardapioVisual);
		}
		getJFrame().setVisible(true);
	}
	

	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private Mdi getJFrame() {
		if (jFrame == null) {
			jFrame = FactorySingletonMdi.Construir();
//			jFrame.setSize(new Dimension(400, 650));
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
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(5);
			borderLayout.setVgap(5);
			jContentPane = new JPanel();
			jContentPane.setName("Cardápio");
			jContentPane.setLayout(borderLayout);
			jContentPane.add(getJScrollPane(), BorderLayout.CENTER);
			jContentPane.add(new JPanel(), BorderLayout.NORTH);
			jContentPane.add(getJPanelFinalizarPedido(), BorderLayout.SOUTH);
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
			gridLayout = new GridLayout();
			gridLayout.setRows(1);
			gridLayout.setColumns(1);
			gridLayout.setVgap(2);
			jPanelCENTER = new JPanel();
			jPanelCENTER.setLayout(gridLayout);
		}
		return jPanelCENTER;
	}
	
	public class AcaoBotaoFinalizar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			registradorPedidos.fecharPedido();
			getJFrame().dispose();
		}
		
	}

	/**
	 * This method initializes jPanelBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBotoes() {
		if (jPanelBotoes == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			gridLayout1.setHgap(50);
			gridLayout1.setColumns(2);
			jPanelBotoes = new JPanel();
			jPanelBotoes.setLayout(gridLayout1);
			jPanelBotoes.add(getJButtonFinalizarPedido(), null);
			jPanelBotoes.add(getJButtonCancelar(), null);
			
		}
		return jPanelBotoes;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getJFrame().dispose();
				}
			});
		}
		return jButtonCancelar;
	}

}
