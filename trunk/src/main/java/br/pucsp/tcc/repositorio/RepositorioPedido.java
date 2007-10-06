package br.pucsp.tcc.repositorio;

import java.util.List;

import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.ItemPedido;
import br.pucsp.tcc.modelo.Pedido;

public interface RepositorioPedido
{
    public void salvar(Pedido pedido, Conta conta);
    public void excluir(Pedido pedido);       
    public List<ItemPedido> obterItens(Pedido pedido);
    public void adicionarItem(ItemPedido item, Pedido pedido);
    public void excluirItem(ItemPedido item);
}
