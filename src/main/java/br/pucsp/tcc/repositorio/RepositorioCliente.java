package br.pucsp.tcc.repositorio;

import java.util.List;

import br.pucsp.tcc.modelo.Cliente;

public interface RepositorioCliente
{
    public int salvar(Cliente cliente);
    public Cliente obterPorNome(String nome);
    public Cliente obterPorId(int id);
    public void excluir(Cliente cliente);
    public List<Cliente> obterClientes();
}
