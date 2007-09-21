package br.pucsp.tcc.controle.impl;

import br.pucsp.tcc.controle.GerenciadorPedido;
import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.Pedido;

public class GerenciadorPedidoImpl implements GerenciadorPedido
{
    @Override
    public void registrarPedido(Cliente cliente, Pedido pedido)
            throws OperacaoInvalidaException
    {
        // verificar se o cliente possui uma conta
        Conta conta = cliente.getConta();
        if(conta == null) {
            throw new OperacaoInvalidaException("O cliente não possui uma conta");
        }
        
        // registrar pedido na conta do cliente
        conta.getPedidos().add(pedido);
    }
    
    @Override
    public void finalizarPedido(Pedido pedido)
    {
        pedido.finalizar();
    }
}
