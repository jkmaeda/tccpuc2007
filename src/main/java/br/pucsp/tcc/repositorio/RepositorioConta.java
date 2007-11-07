package br.pucsp.tcc.repositorio;

import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.Pedido;

public interface RepositorioConta
{
    public int salvar(Conta conta);
    public void excluir(Conta conta);
    public void atualizar(Conta conta);
    public Conta obterConta(int id);
    public void excluirPedido(Pedido pedido);
    public void adicionarPedido(Pedido pedido, Conta conta);
}
