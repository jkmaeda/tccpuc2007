package br.pucsp.tcc.modelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClienteIndividual extends Cliente
{
    private String nome;
    private ClienteMesa mesa;
    
    public ClienteIndividual() {
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ClienteMesa getMesa() {
        return mesa;
    }
    public void setMesa(ClienteMesa mesa) {
        this.mesa = mesa;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(ClienteIndividual.class);
}
