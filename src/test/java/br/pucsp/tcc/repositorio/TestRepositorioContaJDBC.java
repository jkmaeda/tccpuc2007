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
		//ITEM CARDAPIO
		ItemCardapio itemCardapioEsperado = new ItemCardapio();
		itemCardapioEsperado.setDescricao("Item para ser testado no JUnit");
		itemCardapioEsperado.setNome("Item teste JUnit");
		itemCardapioEsperado.setPreco(2.00);
		// ITEM PEDIDO
		ItemPedido itemPedidoEsperado = new ItemPedido(itemCardapioEsperado);
		itemPedidoEsperado.setQuantidade(3);
		// PEDIDO
		Pedido pedidoEsperado = new Pedido();
		pedidoEsperado.adicionarPedido(itemPedidoEsperado);
		// CONTA
		Conta contaEsperada = new Conta();
		contaEsperada.setObservacao("Esta é uma conta de exemplo " +
				"criada pelo eclipse e com pedidos");
		contaEsperada.adicionarPedido(pedidoEsperado);
				
		RepositorioConta repositorio = new RepositorioContaJDBC();
		int idConta = repositorio.salvar(contaEsperada);

		Conta contaObtida = repositorio.obterConta(idConta);

		assertEquals(contaEsperada.saldo(), contaObtida.saldo());
		Pedido pedidoObtido = contaObtida.getPedidos().get(0);
		ItemPedido itemPedidoObtido = pedidoObtido.getItensPedido().get(0);
		assertEquals(itemPedidoEsperado.getQuantidade(), itemPedidoObtido.getQuantidade());
		
		ItemCardapio itemCardapioObtido = itemPedidoObtido.getItemCardapio();
		assertEquals(itemCardapioEsperado.getNome(), itemCardapioObtido.getNome());
		assertEquals(itemCardapioEsperado.getPreco(), itemCardapioObtido.getPreco());
		assertEquals(itemCardapioEsperado.getDescricao(), itemCardapioObtido.getDescricao());
	}
	
	public void testObterContaPorID()
	{
		RepositorioConta repositorio = new RepositorioContaJDBC();
		Conta conta = repositorio.obterConta(1);
		assertTrue(conta.getPedidos().size() > 0);		
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
		repositorio.atualizar(conta);		
		Conta contaObtida = repositorio.obterConta(1);				
		assertEquals("Nova observação", contaObtida.getObservacao());
	}
}
