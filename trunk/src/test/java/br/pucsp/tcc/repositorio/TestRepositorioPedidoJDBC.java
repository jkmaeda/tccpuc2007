package br.pucsp.tcc.repositorio;

import java.util.List;

import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.ItemCardapio;
import br.pucsp.tcc.modelo.ItemPedido;
import br.pucsp.tcc.modelo.Pedido;
import junit.framework.TestCase;

public class TestRepositorioPedidoJDBC 
extends TestCase 
{
	public void testSalvarPedido() throws Exception
	{
		// cria a conta para relacionar o pedido
		Conta conta = new Conta();
		conta.setId(25);
		
		// cria o pedido
		Pedido pedido = new Pedido();
		ItemCardapio ic = null;
		ic = new ItemCardapio();
		ic.setId(9); // refrigerante
		ItemPedido item = null;
		item = new ItemPedido(ic);
		
		// adicionou o refrigerante
		pedido.adicionarPedido(item);
		
		ic = new ItemCardapio();
		ic.setId(10); // bauru
		item = new ItemPedido(ic);
		
		// adicinou o bauru
		pedido.adicionarPedido(item);
		
		RepositorioPedido rep = new RepositorioPedidoJDBC();
		rep.salvar(pedido, conta);			
	} 
	
	public void testExcluirPedido() throws Exception
	{
		Pedido pedido = new Pedido();
		pedido.setId(34);
		RepositorioPedido rep = new RepositorioPedidoJDBC();
		rep.excluir(pedido);
	}
	
	public void testObterItens() throws Exception
	{
		// pedido para recuperar os itens
		Pedido pedido = new Pedido();
		pedido.setId(33);
		
		RepositorioPedido rep = new RepositorioPedidoJDBC();
		List<ItemPedido> itens = rep.obterItens(pedido);
		assertFalse(itens.isEmpty());
	}
	
	public void testAdicionarItem()
	{
		// pedido para recuperar os itens
		Pedido pedido = new Pedido();
		pedido.setId(33);
		
		RepositorioPedido rep = new RepositorioPedidoJDBC();
		
		// cria itens para adicionar ao pedido
		
		ItemCardapio item1 = new ItemCardapio();
		item1.setId(9);
		ItemCardapio item2 = new ItemCardapio();
		item2.setId(10);
		
		ItemPedido ip1 = new ItemPedido(item1);
		ItemPedido ip2 = new ItemPedido(item2);
				
		rep.adicionarItem(ip1, pedido);
		rep.adicionarItem(ip2, pedido);				
	}
	
	public void testExcluirItem()
	{
		RepositorioPedido rep = new RepositorioPedidoJDBC();
		ItemPedido item = new ItemPedido(null);
		item.setId(60);
		rep.excluirItem(item);
	}
}
