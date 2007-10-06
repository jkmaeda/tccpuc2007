package br.pucsp.tcc.repositorio;

import java.util.List;

import br.pucsp.tcc.modelo.ItemCardapio;

public interface RepositorioItemCardapio {
	/**
	 * Salva um ItemCardapio
	 * @param item cardapio a ser salvo
	 */
	public void salvar(ItemCardapio item);
	/**
	 * Exclui um ItemCardapio
	 * @param item cardapio a ser excluido
	 */
	public void excluir(ItemCardapio item);
	/**
	 * Atualiza um ItemCardapio
	 * @param item cardapio a ser atualizado
	 */
	public void atualizar(ItemCardapio item);
	/**
	 * Obtem uma lista com todos os objetos ItemCardapio
	 * @return lista de objetos ItemCardapio
	 */
	public List<ItemCardapio> obterItensCardapio();
	/**
	 * Obtem o item do cardapio por nome
	 * @param nome do item a ser buscado
	 * @return ItemCardapio
	 */
	public ItemCardapio buscarPorNome(String nome);
	public ItemCardapio buscarPorId(int id);
}
