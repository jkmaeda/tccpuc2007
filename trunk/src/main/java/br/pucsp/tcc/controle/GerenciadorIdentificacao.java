package br.pucsp.tcc.controle;

import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.TipoIdentificacao;

/**
 * Realização do(s) caso(s) de uso:
 *  "1.1 Gerar Identificação".
 * 
 * @author Gustavo Steigert
 * @since 0.0.1 (Sep 20, 2007)
 */
public interface GerenciadorIdentificacao
{
    /**
     * Gera uma identificação de acordo com os valores fornecidos.
     * 
     * @param info  conteúdo da identificação
     * @param tipo  tipo da identificação
     * @return uma identificação para um cliente
     * @throws OperacaoInvalidaException - caso o tipo da identificação seja desconhecido
     */
    Identificacao gerarIdentificacao(String info, TipoIdentificacao tipo)
        throws OperacaoInvalidaException;
}
