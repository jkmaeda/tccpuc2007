package br.pucsp.tcc.controle.impl;

import br.pucsp.tcc.controle.GerenciadorCliente;
import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.exception.RegistroNaoEncontradoException;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.ClienteMesa;
import br.pucsp.tcc.modelo.Identificacao;

public class GerenciadorClienteImpl implements GerenciadorCliente
{
    @Override
    public ClienteIndividual cadastrarClienteIndividual(ClienteMesa mesa,
            Identificacao identificacao, String nome)
        throws OperacaoInvalidaException
    {
        ClienteIndividual cliente = new ClienteIndividual();
        cliente.setNome(nome);
        cliente.setIdentificacao(identificacao);
        cliente.setMesa(mesa);
        
        //RepositorioCliente.inserir(cliente);
        
        return cliente;
    }

    @Override
    public Cliente obterCliente(Identificacao identificacao)
            throws RegistroNaoEncontradoException {
        return null;
    }
}
