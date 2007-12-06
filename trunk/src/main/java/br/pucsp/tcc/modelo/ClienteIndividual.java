package br.pucsp.tcc.modelo;

import java.awt.Image;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClienteIndividual extends Cliente
{    
	private String nome;
	private String nascimento;
	private String telefoneFixo;
	private String celular;
	private String email;
	private Image foto;
    
    public ClienteIndividual() {
    }             
    
    public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}

	public String getNascimento() {
		return nascimento;
	}

	public String getCelular() {
		return celular;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public Image getFoto() {
		return foto;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public void setFoto(Image foto) {
		this.foto = foto;
	}
	
    // configurar o logger
    static Log logger = LogFactory.getLog(ClienteIndividual.class);
}
