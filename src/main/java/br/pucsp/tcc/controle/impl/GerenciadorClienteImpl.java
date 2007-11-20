//package br.pucsp.tcc.controle.impl;
//
//import br.pucsp.tcc.controle.GerenciadorCliente;
//import br.pucsp.tcc.exception.ClienteNaoEncontrado;
//import br.pucsp.tcc.exception.IdentificacaoInvalidaException;
//import br.pucsp.tcc.modelo.ClienteIndividual;
//import br.pucsp.tcc.modelo.ImpressaoDigital;
//import br.pucsp.tcc.repositorio.FabricaRepositorio;
//import br.pucsp.tcc.repositorio.RepositorioCliente;
//
//public class GerenciadorClienteImpl implements GerenciadorCliente
//{
//    FabricaRepositorio fabRepositorios;    
//    RepositorioCliente repCliente;
//    
//    public GerenciadorClienteImpl() {
//        fabRepositorios = new FabricaRepositorio();        
//        repCliente = fabRepositorios.getRepCliente();
//    }
//    
//    public ClienteIndividual cadastrarClienteIndividual(
//            ImpressaoDigital digital, String nome)
//            throws IdentificacaoInvalidaException
//    {
//        // verificar se já existe uma identificação igual
//        if(repCliente.existeCliente(digital)) {
//            throw new IdentificacaoInvalidaException("Identificação já existente");
//        }
//        
//        // realizar o cadastro do cliente no sistema
//        ClienteIndividual cliente = new ClienteIndividual();
//        cliente.setNome(nome);
//        cliente.setIdentificacao(digital);
//        
//        // persistir informações
//        repCliente.editar(cliente);
//        
//        return cliente;
//    }
//
//	public ClienteIndividual editarClienteIndividual(ClienteIndividual clienteIndividual)
//	throws ClienteNaoEncontrado {
//        // verificar se já existe uma identificação igual
//        if(!repCliente.existeCliente(clienteIndividual.getIdentificacao())) {
//            throw new ClienteNaoEncontrado("O cliente n�o pode ser encontrado");
//        }
//        
//        // persistir informações
//        repCliente.editar(clienteIndividual);
//        
//        return clienteIndividual;
//    }
//}
