package br.pucsp.tcc.modelo;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Estabelecimento
{
    private String nome;
    
    private Cardapio cardapio;
    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;
    
    public Estabelecimento() {
        this.setFuncionarios(new LinkedList<Funcionario>());
        this.setClientes(new LinkedList<Cliente>());
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Cardapio getCardapio() {
        return cardapio;
    }
    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(Estabelecimento.class);
}
