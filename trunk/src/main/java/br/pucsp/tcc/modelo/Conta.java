package br.pucsp.tcc.modelo;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Conta
{
    private List<Pedido> pedidos;
    
    public Conta() {
        this.setPedidos(new LinkedList<Pedido>());
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(Conta.class);
}
