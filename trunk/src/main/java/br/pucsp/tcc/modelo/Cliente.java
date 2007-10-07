package br.pucsp.tcc.modelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class Cliente
{	
	private int id;
    private Conta conta;    
    private Identificacao identificacao;
    
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
}
