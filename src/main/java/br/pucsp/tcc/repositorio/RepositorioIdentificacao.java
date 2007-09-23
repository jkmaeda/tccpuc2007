package br.pucsp.tcc.repositorio;

import br.pucsp.tcc.modelo.Identificacao;

public interface RepositorioIdentificacao
{
    /**
     * Procura por uma identificação no sistema.
     * 
     * @param id  a identificação a ser procurada
     * @return true caso a identificação exista, falso caso contrário
     */
    public boolean existeIdentificacao(Identificacao id);    
    public Identificacao obterIdentificacao(Object id);
}
