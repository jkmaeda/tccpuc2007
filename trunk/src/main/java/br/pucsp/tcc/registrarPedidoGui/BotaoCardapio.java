package br.pucsp.tcc.registrarPedidoGui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.pucsp.tcc.modelo.ItemCardapio;
import br.pucsp.tcc.registrarPedido.RegistrarPedidos;


public class BotaoCardapio extends JButton {

	private ItemCardapio itemCardapio;  //  @jve:decl-index=0:
	private RegistrarPedidos registradorPedidos;
	
	public BotaoCardapio(ItemCardapio itemCardapio, RegistrarPedidos registradorPedidos) {
		this.itemCardapio = itemCardapio;
		this.registradorPedidos = registradorPedidos;
		this.setPreferredSize(new Dimension(100, 40));
		this.setMinimumSize(new Dimension(100, 40));
		this.setText(itemCardapio.getNome());
		this.setToolTipText(itemCardapio.getDescricao());
		this.addActionListener(new AcaoBotao());
	}

	public ItemCardapio getItemCardapio() {
		return itemCardapio;
	}

	public void setItemCardapio(ItemCardapio itemCardapio) {
		this.itemCardapio = itemCardapio;
	}
	
	public class AcaoBotao implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			registradorPedidos.adicionarItem(getItemCardapio());
		}
		
	}
	
}
