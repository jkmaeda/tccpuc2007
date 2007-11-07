package br.pucsp.tcc.repositorio;

import java.util.List;

import br.pucsp.tcc.modelo.ItemCardapio;
import junit.framework.TestCase;

public class TestRepositorioItemCardapioJDBC extends TestCase {
	
	public void testObterItensCardapio() {
		RepositorioItemCardapio repositorio = new RepositorioItemCardapioJDBC();
		List<ItemCardapio> itens = repositorio.obterItensCardapio();
		assertTrue(!itens.isEmpty());
	}
	public void testBuscarItemCardapioPorNome() {
		RepositorioItemCardapio repositorio = new RepositorioItemCardapioJDBC();
		ItemCardapio itemEsperado = new ItemCardapio();
		itemEsperado.setNome("coca-cola");
		itemEsperado.setPreco(4.50);		
		ItemCardapio itemObtido = repositorio.buscarPorNome("coca-cola");
		assertEquals(itemEsperado.getNome(), itemObtido.getNome());
		assertEquals(itemEsperado.getPreco(), itemObtido.getPreco());
	}
	
	public void testSalvarItemCardapio() {
		RepositorioItemCardapio repositorio = new RepositorioItemCardapioJDBC();
		ItemCardapio itemEsperado = new ItemCardapio();
		itemEsperado.setNome("Beirute");
		itemEsperado.setPreco(10.00);
		itemEsperado.setDescricao("Beirute de rosbife");
		repositorio.salvar(itemEsperado);
		ItemCardapio itemObtido = repositorio.buscarPorNome("Beirute");
		assertEquals(itemEsperado.getNome(), itemObtido.getNome());
		assertEquals(itemEsperado.getPreco(), itemObtido.getPreco());		
	}
			
	public void testExcluirItemCaradapio() {
		RepositorioItemCardapio repositorio = new RepositorioItemCardapioJDBC();
		ItemCardapio itemEsperado = new ItemCardapio();
		itemEsperado.setNome("Beirute");
		itemEsperado.setPreco(10.00);
		itemEsperado.setDescricao("Beirute de rosbife");
		repositorio.excluir(itemEsperado);		
		ItemCardapio itemObtido = repositorio.buscarPorNome("Beirute");
		assertNull(itemObtido);
	}
	
	public void testAtualizarItemCardapio() {
		RepositorioItemCardapio repositorio = new RepositorioItemCardapioJDBC();
		ItemCardapio itemEsperado = new ItemCardapio();
		itemEsperado.setNome("coca-cola");
		itemEsperado.setPreco(4.50);		
		repositorio.atualizar(itemEsperado);		
		ItemCardapio itemObtido = repositorio.buscarPorNome("coca-cola");		
		assertEquals(itemEsperado.getPreco(), itemObtido.getPreco());
	}
}
