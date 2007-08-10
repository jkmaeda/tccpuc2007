package br.pucsp.tcc.modelo;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Pedido
{
    private List<ItemPedido> itensPedido;
    
    public Pedido() {
        this.setItensPedido(new LinkedList<ItemPedido>());
    }
    
    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }
    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(Pedido.class);
}
