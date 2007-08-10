package br.pucsp.tcc.modelo;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Cardapio
{
    private List<ItemCardapio> itensCardapio;
    
    public Cardapio() {
        this.setItensCardapio(new LinkedList<ItemCardapio>());
    }
    
    public List<ItemCardapio> getItensCardapio() {
        return itensCardapio;
    }
    public void setItensCardapio(List<ItemCardapio> itensCardapio) {
        this.itensCardapio = itensCardapio;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(Cardapio.class);
}
