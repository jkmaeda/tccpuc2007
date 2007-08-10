package br.pucsp.tcc.modelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class Cliente
{
    private String nome;
    
    private Conta conta;
    private Identificacao identificacao;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    public Identificacao getIdentificacao() {
        return identificacao;
    }
    public void setIdentificacao(Identificacao identificacao) {
        this.identificacao = identificacao;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(Cliente.class);
}
