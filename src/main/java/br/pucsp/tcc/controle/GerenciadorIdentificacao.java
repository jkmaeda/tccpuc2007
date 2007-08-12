package br.pucsp.tcc.controle;

import br.pucsp.tcc.exception.IdentificacaoInvalidaException;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.TipoIdentificacao;

public interface GerenciadorIdentificacao
{
    Identificacao gerarIdentificacao(Object dado, TipoIdentificacao tipo)
        throws IdentificacaoInvalidaException;
}
