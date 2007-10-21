package br.pucsp.tcc.modelo;

import java.awt.Image;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClienteIndividual extends Cliente
{    
	private String nome;
	private String cpf;
	private Image foto;
    
    public ClienteIndividual() {
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
	public Image getFoto() {
		return foto;
	}
	public void setFoto(Image foto) {
		this.foto = foto;
	}
	
    // configurar o logger
    static Log logger = LogFactory.getLog(ClienteIndividual.class);
}
