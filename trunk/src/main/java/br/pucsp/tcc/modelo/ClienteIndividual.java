package br.pucsp.tcc.modelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClienteIndividual extends Cliente
{    
	private String nome;
	private String cpf;
    private int mesa;
    
    public ClienteIndividual() {
    }       
    
    public int getMesa() {
        return mesa;
    }
    
    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
    
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
    // configurar o logger
    static Log logger = LogFactory.getLog(ClienteIndividual.class);
}
