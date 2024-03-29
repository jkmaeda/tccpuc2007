//package br.pucsp.tcc.controle.impl;
//
//import br.pucsp.tcc.exception.OperacaoInvalidaException;
//import br.pucsp.tcc.modelo.Cliente;
//import br.pucsp.tcc.modelo.Conta;
//import br.pucsp.tcc.repositorio.FabricaRepositorio;
//import br.pucsp.tcc.repositorio.RepositorioConta;
//
//public class GerenciadorContaImpl implements br.pucsp.tcc.controle.GerenciadorConta
//{
//    FabricaRepositorio fabRepositorios;
//    RepositorioConta repConta;
//    
//    public GerenciadorContaImpl() {
//        fabRepositorios = new FabricaRepositorio();
//        repConta = fabRepositorios.getRepConta();
//    }
//    
//    public void abrirConta(Cliente cliente) throws OperacaoInvalidaException
//    {
//        // verificar se o cliente já possui uma conta
//        Conta conta = cliente.getConta();
////        if(conta != null) {
////            throw new OperacaoInvalidaException("O cliente já possui uma conta");
////        }
//        
//        // criar uma nova conta
//        Conta novaConta = new Conta();
//        
//        // registrar a nova conta no cliente
//        cliente.setConta(novaConta);
//        
//        // persistir informações
//        repConta.salvar(conta);
//    }
//
//    public double consultarSaldoDaConta(Cliente cliente)
//            throws OperacaoInvalidaException
//    {
//        // verificar se o cliente possui uma conta
//        Conta conta = cliente.getConta();
//        if(conta == null) {
//            throw new OperacaoInvalidaException("O cliente não possui uma conta");
//        }
//        
//        // calcular o saldo
//        double saldo = conta.saldo();
//        return saldo;
//    }
//
//    public void fecharConta(Cliente cliente)
//            throws OperacaoInvalidaException
//    {
//        // verificar se o cliente possui uma conta
//        Conta conta = cliente.getConta();
//        if(conta == null) {
//            throw new OperacaoInvalidaException("O cliente não possui uma conta");
//        }
//        
//        // fechar conta
//        cliente.setConta(null);
//        
//        // persistir informações
//        repConta.salvar(conta);
//    }
//}
