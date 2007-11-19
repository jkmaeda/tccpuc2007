package br.pucsp.tcc.gui.registrarPedido;

import br.pucsp.tcc.modelo.Cardapio;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ItemPedido;

public interface RegistrarPedidos {

	public void abrirPedido(Cliente cliente);
	public Cardapio obterCardapio();
	public void adicionarItem(ItemPedido itemPedido);
	public void fecharPedido();
	
	
}
