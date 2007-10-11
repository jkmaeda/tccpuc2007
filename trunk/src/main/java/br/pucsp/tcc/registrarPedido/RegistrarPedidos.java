package br.pucsp.tcc.registrarPedido;

import br.pucsp.tcc.modelo.Cardapio;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ItemCardapio;

public interface RegistrarPedidos {

	public void abrirPedido(Cliente cliente);
	public Cardapio obterCardapio();
	public void adicionarItem(ItemCardapio itemCardapio);
	public void fecharPedido();
	
	
}
