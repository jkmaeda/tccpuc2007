package br.pucsp.tcc.repositorio;

import br.pucsp.tcc.modelo.Conta;

public interface RepositorioConta
{
    public int salvar(Conta conta);
    public void excluir(Conta conta);
    public Conta obterConta(int id);
    public void atualizar(Conta conta);
}
