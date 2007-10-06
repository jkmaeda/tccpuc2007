package br.pucsp.tcc.controle.impl;

import br.pucsp.tcc.controle.GerenciadorPedido;
import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.Pedido;
import br.pucsp.tcc.repositorio.FabricaRepositorio;
import br.pucsp.tcc.repositorio.RepositorioPedido;

public class GerenciadorPedidoImpl implements GerenciadorPedido
{
    FabricaRepositorio fabRepositorios;
    RepositorioPedido repPedido;
    
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
        
        // persistir informações
        //repPedido.salvar(pedido);
    }
    
    public void finalizarPedido(Pedido pedido) {
        pedido.finalizar();
        //repPedido.salvar(pedido);
    }
}
