package br.pucsp.tcc.controle;

import br.pucsp.tcc.exception.IdentificacaoInvalidaException;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.ImpressaoDigital;

/**
 * Realização do(s) caso(s) de uso:
 *  "2.1 Cadastrar Cliente"
 * 
 * @author Gustavo Steigert
 * @since 0.0.1 (Sep 20, 2007)
 */
public interface GerenciadorCliente
{
    /**
     * Cadastra um cliente individual no sistema.
     * Para um mesmo cliente, esse cadastro só precisa ser feito uma vez.
     * 
     * @param digital  a impressão digital do cliente
     * @param nome     o nome completo do cliente
     * @return uma instância funcional do cliente criado
     * @throws IdentificacaoInvalidaException - caso a impressão digital especificada já
     *      esteja cadastrada em outro cliente
     */
    ClienteIndividual cadastrarClienteIndividual(ImpressaoDigital digital, String nome)
        throws IdentificacaoInvalidaException;
}
