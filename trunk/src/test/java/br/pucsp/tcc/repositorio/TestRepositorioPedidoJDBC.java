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
		conta.setId(1);
		
		// cria o pedido
		Pedido pedido = new Pedido();
		ItemCardapio ic = null;
		ic = new ItemCardapio();
		ic.setId(1); // coca-cola
		ItemPedido item = null;
		item = new ItemPedido(ic);
		
		// adicionou o refrigerante
		pedido.adicionarItemPedido(item);			
		
		RepositorioPedido rep = new RepositorioPedidoJDBC();
		rep.salvar(pedido, conta);			
	} 
	
	public void testExcluirPedido() throws Exception
	{
		RepositorioPedido rep = new RepositorioPedidoJDBC();							
		RepositorioConta repConta = new RepositorioContaJDBC();
		Conta conta = repConta.obterConta(1);
		List<Pedido> pedidos = conta.getPedidos();
		int tamanho = pedidos.size();
		
		Pedido pedido = pedidos.get(tamanho-1);		
		rep.excluir(pedido);
	}
	
	public void testObterItens() throws Exception
	{
		// pedido para recuperar os itens
		Pedido pedido = new Pedido();
		pedido.setId(1);
		
		RepositorioPedido rep = new RepositorioPedidoJDBC();
		List<ItemPedido> itens = rep.obterItens(pedido);
		assertFalse(itens.isEmpty());
	}
	
	public void testAdicionarItem()
	{
		// pedido para recuperar os itens
		Pedido pedido = new Pedido();
		pedido.setId(1);
		
		RepositorioPedido rep = new RepositorioPedidoJDBC();
		
		// cria itens para adicionar ao pedido		
		ItemCardapio item1 = new ItemCardapio();
		item1.setId(1);	
		
		ItemPedido ip1 = new ItemPedido(item1);
		rep.adicionarItem(ip1, pedido);					
	}
	
	public void testExcluirItem()
	{
		RepositorioPedido rep = new RepositorioPedidoJDBC();						
		Pedido p = new Pedido();
		p.setId(1);
		List<ItemPedido> itens = rep.obterItens(p);
		int tamanho = itens.size(); 
		ItemPedido item = itens.get(tamanho-1);
		rep.excluirItem(item);
	}
}
