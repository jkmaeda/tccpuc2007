package br.pucsp.tcc.gui.registrarPedido.impl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.pucsp.tcc.gui.registrarPedido.RegistrarPedidos;
import br.pucsp.tcc.modelo.ItemCardapio;


public class BotaoCardapio extends JButton {

	private ItemCardapio itemCardapio;
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
