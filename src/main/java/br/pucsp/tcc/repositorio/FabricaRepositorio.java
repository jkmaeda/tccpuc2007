package br.pucsp.tcc.repositorio;
/**
 * Uma fábrica de repositórios.
 * 
 * @author Gustavo Steigert
 * @since 0.0.1 (Sep 20, 2007)
 */
public class FabricaRepositorio
{       
    public RepositorioCliente getRepCliente()
    {
        return new RepositorioClienteJDBC();
    }
    
    public RepositorioConta getRepConta()
    {
        return new RepositorioContaJDBC();
    }
    
    public RepositorioItemCardapio getRepItemCardapio()
    {
        return new RepositorioItemCardapioJDBC();
    }
    
    public RepositorioCardapio getRepCardapio ()
    {
    	return new RepositorioCardapioJDBC();
    }
    
    public RepositorioPedido getRepPedido () 
    {
    	return new RepositorioPedidoJDBC();
    }

    public RepositorioFuncionario getRepFuncionario ()
    {
    	return new RepositorioFuncionarioJDBC();
    }
}
