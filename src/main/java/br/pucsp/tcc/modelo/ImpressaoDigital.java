package br.pucsp.tcc.modelo;

import java.awt.Image;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ImpressaoDigital extends Identificacao
{	
    private Image info;
    private int templateId;
    
    public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public ImpressaoDigital(Image info, int templateId2) {
    	this.setInfo(info);
    	this.setTemplateId(templateId2);
	}
    
    public Image getInfo() {
        return info;
    }
    public void setInfo(Image hash) {
        this.info = hash;
    }
    
    public String toString() {
    	return String.format("ImpressaoDigital[id=%d]", "Não existe mais id!!!");
    }
       
    // configurar o logger
    static Log logger = LogFactory.getLog(ImpressaoDigital.class);	
}
