package br.pucsp.tcc.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.ItemCardapio;
import br.pucsp.tcc.modelo.Pedido;
import br.pucsp.tcc.modelo.ItemPedido;
import junit.framework.TestCase;

public class TestRepositorioContaJDBC extends TestCase {

	public void testSalvarConta() throws Exception 
	{
		Conta conta = new Conta();
		
		conta.setObservacao("Esta é uma conta de exemplo " +
				"criada pelo eclipse e com pedidos");
		
		List<Pedido> pedidos = null;
		Pedido pedido = null;
		List<ItemPedido> itensPedido = null;
		ItemPedido itemPedido = null;
		ItemCardapio itemCardapio = null;
		
		pedidos = new ArrayList<Pedido>();
		pedido = new Pedido();
		itensPedido = new ArrayList<ItemPedido>();
		itemCardapio = new ItemCardapio();
		itemCardapio.setId(4);		
		
		itemPedido = new ItemPedido(itemCardapio);
		
		itemPedido.setItemCardapio(itemCardapio);
		itemPedido.setQuantidade(1);
		itensPedido.add(itemPedido);
		pedido.setItensPedido(itensPedido);
		
		pedidos.add(pedido);		
		conta.setPedidos(pedidos);
				
		RepositorioConta repositorio = new RepositorioContaJDBC();
		repositorio.salvar(conta);
	}
	
	public void testObterContaPorID()
	{
		RepositorioConta repositorio = new RepositorioContaJDBC();
		Conta conta = repositorio.obterConta(1);
		assertEquals(conta.getPedidos().size(), 2);		
	}
	
	public void testExcluirConta()
	{
		RepositorioConta repositorio = new RepositorioContaJDBC();
		Conta conta = new Conta();
		conta.setId(7);
		repositorio.excluir(conta);
		
		Conta contaObtida = repositorio.obterConta(7);
		assertEquals(null, contaObtida);
	}
	
	public void testAtualizarConta()
	{
		RepositorioConta repositorio = new RepositorioContaJDBC();
		Conta conta = repositorio.obterConta(1);
		
		conta.setObservacao("Nova observação");
		
		Pedido pedido = conta.getPedidos().get(1);
		pedido.getItensPedido().get(1).setQuantidade(10);
		
		//repositorio.atualizar(conta);
		
		conta = repositorio.obterConta(1);
		Pedido pedidoObtido = conta.getPedidos().get(1);
		int qtdObtida = pedidoObtido.getItensPedido().get(1).getQuantidade();
		assertEquals(10, qtdObtida);
	}
}
