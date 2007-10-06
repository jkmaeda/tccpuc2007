package br.pucsp.tcc.repositorio;

import br.pucsp.tcc.modelo.TipoIdentificacao;

/**
 * Uma fábrica de repositórios.
 * 
 * @author Gustavo Steigert
 * @since 0.0.1 (Sep 20, 2007)
 */
public class FabricaRepositorio
{
    public RepositorioIdentificacao getRepIdentificacao(TipoIdentificacao identificacao)
    {
    	RepositorioIdentificacao repositorio = null;
    	switch (identificacao) {
    		case MESA:  repositorio = new RepositorioNumeroMesaJDBC(); break;
    		case IMPRESSAO_DIGITAL: repositorio = new RepositorioImpressaoDigitalJDBC();
    	}
        return repositorio;
    }
    
    public RepositorioCliente getRepCliente()
    {
        return new RepositorioClienteJDBC();
    }
    
    public RepositorioConta getRepConta()
    {
        return new RepositorioContaJDBC();
    }
}
