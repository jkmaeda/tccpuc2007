package br.pucsp.tcc.registrarPedidoGui;

import br.pucsp.tcc.modelo.Cardapio;
import br.pucsp.tcc.registrarPedido.RegistrarPedidos;

public interface RegistrarPedidosGui {

	public void exibir();
	public void setRegistradorPedidos(RegistrarPedidos registradorPedidos);
	public void setCardapio(Cardapio cardapio);
	
}
