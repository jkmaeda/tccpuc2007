package br.pucsp.tcc.controle;

import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.modelo.Cliente;

/**
 * Realização do(s) caso(s) de uso:
 *  "2.2 Abrir conta do Cliente"
 *  "4.1 Consultar conta do Cliente"
 *  "4.2 Fechar conta do Cliente"
 *  
 * @author Gustavo Steigert
 * @since 0.0.1 (Sep 20, 2007)
 */
public interface GerenciadorConta
{
    /**
     * Abre a conta do cliente especificado.
     * 
     * @param cliente  o cliente para quem a conta está sendo aberta
     * @throws OperacaoInvalidaException - caso já exista uma conta aberta para o cliente
     */
    void abrirConta(Cliente cliente)
        throws OperacaoInvalidaException;
    
    /**
     * Fecha a conta do cliente especificado.
     * 
     * @param cliente  o cliente para quem a conta está sendo fechada
     * @throws OperacaoInvalidaException - caso não exista uma conta aberta para o cliente
     */
    void fecharConta(Cliente cliente)
        throws OperacaoInvalidaException;
    
    /**
     * Consulta o saldo da conta do cliente espeficicado.
     * 
     * @param cliente  o cliente para quem o saldo está sendo verificado
     * @return o saldo total da conta
     * @throws OperacaoInvalidaException - caso não exista uma conta aberta para o cliente
     */
    double consultarSaldoDaConta(Cliente cliente)
        throws OperacaoInvalidaException;
}
