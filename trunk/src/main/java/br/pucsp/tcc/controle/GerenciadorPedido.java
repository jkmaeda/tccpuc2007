package br.pucsp.tcc.controle;

import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.exception.RegistroNaoEncontradoException;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.Pedido;

public interface GerenciadorPedido
{
    void registrarPedido(Cliente cliente, Pedido pedido)
        throws OperacaoInvalidaException;
    
    Pedido obterPedido(int id)
        throws RegistroNaoEncontradoException;
    
    void finalizarPedido(Pedido pedido)
        throws OperacaoInvalidaException;
}
