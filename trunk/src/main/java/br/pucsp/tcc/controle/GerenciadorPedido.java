package br.pucsp.tcc.controle;

import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.Pedido;

/**
 * Realização do(s) caso(s) de uso:
 *  "3.1 Registrar Pedido" 
 *  "3.2 Finalizar Pedido" 
 * 
 * @author Gustavo Steigert
 * @since 0.0.1 (Sep 20, 2007)
 */
public interface GerenciadorPedido
{
    /**
     * Realiza o registro de um pedido no sistema.
     * Neste momento, o pedido é adicionado à conta do cliente.
     * 
     * @param cliente  o cliente que está fazendo o pedido
     * @param pedido   o pedido que está sendo feito
     * @throws OperacaoInvalidaException - caso não haja uma conta aberta para o cliente
     */
    void registrarPedido(Cliente cliente, Pedido pedido)
        throws OperacaoInvalidaException;
    
    /**
     * Realiza a entrega de um pedido.
     * 
     * @param pedido  o pedido sendo entregue
     */
    void finalizarPedido(Pedido pedido)
        throws OperacaoInvalidaException;
}
