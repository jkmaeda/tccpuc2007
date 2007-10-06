package br.pucsp.tcc.modelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Funcionario
{
    private String nome;
    private int id;
    
    public Funcionario() {
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(Funcionario.class);
}
