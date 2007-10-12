package br.pucsp.tcc.gui.registrarPedido.impl;

import br.pucsp.tcc.gui.registrarPedido.RegistrarPedidos;
import br.pucsp.tcc.modelo.Cardapio;

public interface RegistrarPedidosGui {

	public void exibir();
	public void setRegistradorPedidos(RegistrarPedidos registradorPedidos);
	public void setCardapio(Cardapio cardapio);
	
}
