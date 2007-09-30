package br.pucsp.tcc.modelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ImpressaoDigital extends Identificacao
{
	private int id;
    private String info;
    
    public ImpressaoDigital(String info) {
        this.setInfo(info);
    }
    
    public String getInfo() {
        return info;
    }
    public void setInfo(String hash) {
        this.info = hash;
    }
    
    public String toString() {
    	return info;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(ImpressaoDigital.class);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
