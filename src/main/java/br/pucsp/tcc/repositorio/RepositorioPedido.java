package br.pucsp.tcc.repositorio;

import java.util.List;

import br.pucsp.tcc.modelo.ItemPedido;
import br.pucsp.tcc.modelo.Pedido;

public interface RepositorioPedido
{
    public void salvar(Pedido pedido);
    public void excluir(Pedido pedido);
    public void atualizar(Pedido pedido);
    public List<ItemPedido> obterItens(Pedido pedido);    
}
