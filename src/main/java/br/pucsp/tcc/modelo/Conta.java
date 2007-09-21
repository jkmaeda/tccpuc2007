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
    
    public double saldo()
    {
        double saldo = 0;
        for(Pedido pedido : this.getPedidos())
        {
            for(ItemPedido item : pedido.getItensPedido())
            {
                saldo+= item.getQuantidade() * item.getItemCardapio().getPreco();
            }
        }
        return saldo;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(Conta.class);
}
