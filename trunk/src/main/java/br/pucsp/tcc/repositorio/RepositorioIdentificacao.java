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
    /**
     * Obtem uma identificação
     * @param id a identificação a ser obtida 
     * @return Identificacao
     */
    public Identificacao obterIdentificacao(Object id);
    /**
     * Insere uma identificação 
     * @param id Identificação a ser inserida
     */
    public int salvar(Identificacao id);
    /**
     * Exclui uma identificacao
     * @param id Identificacao a ser excluida
     */
    public void excluir(Identificacao id);
    
}
