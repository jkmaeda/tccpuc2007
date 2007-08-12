package br.pucsp.tcc.controle;

import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.Conta;

public interface GerenciadorConta
{
    void abrirConta(Cliente cliente)
        throws OperacaoInvalidaException;
    
    void fecharConta(Conta conta)
        throws OperacaoInvalidaException;
    
    double consultarSaldoDaConta(Cliente cliente)
        throws OperacaoInvalidaException;
}
