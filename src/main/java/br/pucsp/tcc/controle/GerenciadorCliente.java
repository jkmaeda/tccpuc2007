package br.pucsp.tcc.controle;

import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.exception.RegistroNaoEncontradoException;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.ClienteMesa;
import br.pucsp.tcc.modelo.Identificacao;

public interface GerenciadorCliente
{
    ClienteIndividual cadastrarClienteIndividual(ClienteMesa mesa,
            Identificacao identificacao, String nome)
        throws OperacaoInvalidaException;
    
    Cliente obterCliente(Identificacao identificacao)
        throws RegistroNaoEncontradoException;
}
