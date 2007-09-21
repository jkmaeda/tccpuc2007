package br.pucsp.tcc.controle.impl;

import br.pucsp.tcc.controle.GerenciadorCliente;
import br.pucsp.tcc.exception.IdentificacaoInvalidaException;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.ImpressaoDigital;
import br.pucsp.tcc.repositorio.FabricaRepositorio;
import br.pucsp.tcc.repositorio.RepositorioIdentificacao;

public class GerenciadorClienteImpl implements GerenciadorCliente
{
    FabricaRepositorio fabRepositorios;
    RepositorioIdentificacao repIdentificacao;
    
    public GerenciadorClienteImpl() {
        fabRepositorios = new FabricaRepositorio();
        repIdentificacao = fabRepositorios.getRepIdentificacao();
    }
    
    @Override
    public ClienteIndividual cadastrarClienteIndividual(
            ImpressaoDigital digital, String nome)
            throws IdentificacaoInvalidaException
    {
        // verificar se já existe uma identificação igual
        if(repIdentificacao.existeIdentificacao(digital)) {
            throw new IdentificacaoInvalidaException("Identificação já existente");
        }
        
        // realizar o cadastro do cliente no sistema
        ClienteIndividual cliente = new ClienteIndividual();
        cliente.setNome(nome);
        cliente.setIdentificacao(digital);
        
        return cliente;
    }
}
