package br.pucsp.tcc.gui.registrarPedido.impl;

import br.pucsp.tcc.gui.registrarPedido.RegistrarPedidos;
import br.pucsp.tcc.modelo.Cardapio;
import br.pucsp.tcc.modelo.ItemCardapio;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RegistradorPedidosGui 
	implements RegistrarPedidosGui {

	private RegistrarPedidos registradorPedidos;
	private JFrame jFrame = null;
	private JPanel jContentPane = null;
	private JPanel jPanelCENTER = null;
	private GridLayout gridLayout;
	private JScrollPane jScrollPane = null;
	private JPanel jPanelFinalizarPedido = null;
	private JButton jButtonFinalizarPedido = null;
	
	private JPanel getJPanelFinalizarPedido() {
		if(jPanelFinalizarPedido == null) {
			jPanelFinalizarPedido = new JPanel();
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(5);
			borderLayout.setVgap(5);
			jPanelFinalizarPedido.setLayout(borderLayout);
			jPanelFinalizarPedido.add(getJButtonFinalizarPedido(), BorderLayout.CENTER);
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
			jButtonFinalizarPedido.setText("Finalizar");
			jButtonFinalizarPedido.setMinimumSize(new Dimension(100, 60));
			jButtonFinalizarPedido.setPreferredSize(new Dimension(100, 60));
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
		centralizar(jFrame);
	}
	
	public void exibir() {
		getJFrame().setVisible(true);
	}

	public void setRegistradorPedidos(RegistrarPedidos registradorPedidos) {
		this.registradorPedidos = registradorPedidos;
	}

	public void setCardapio(Cardapio cardapio) {
		List<ItemCardapio> itensCardapio = cardapio.getItensCardapio();
		gridLayout.setRows(itensCardapio.size());
		jPanelCENTER.setLayout(gridLayout);
		for(ItemCardapio item : itensCardapio) {
			BotaoCardapio botaoCardapio = new BotaoCardapio(item, registradorPedidos);
			getJPanelCENTER().add(botaoCardapio);
		}
		getJFrame().setVisible(true);
	}
	

	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setSize(new Dimension(400, 650));
			jFrame.setTitle("Cardápio");
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
	
	private void centralizar(Component component){
  	    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
  	    Dimension compSize = component.getSize();
  	    int centerX = (screenDim.width - compSize.width) >> 1;
  	    int centerY = (screenDim.height - compSize.height) >> 1;
  	    component.setLocation(centerX, centerY);
	}
	
	public class AcaoBotaoFinalizar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			registradorPedidos.fecharPedido();
		}
		
	}

}
