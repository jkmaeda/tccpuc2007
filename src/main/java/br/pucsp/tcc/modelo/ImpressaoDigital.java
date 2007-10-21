package br.pucsp.tcc.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ImpressaoDigital extends Identificacao
{	
    private Image info;
    
    public ImpressaoDigital(Image info) {
    	this.setInfo(info);
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
    
    public byte[] getImage() {
        try {    		            
            ImageIcon i = new ImageIcon(info);
        	//i.
        		        
	        return null;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(ImpressaoDigital.class);	
}
