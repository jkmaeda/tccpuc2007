package br.pucsp.tcc.modelo;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Pedido
{
	private int id;
    private List<ItemPedido> itensPedido;
    
    public Pedido() {
        logger.debug("Criando novo pedido");
        this.setItensPedido(new LinkedList<ItemPedido>());
    }
    
    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }
    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
    
    public void finalizar() {
        logger.debug("Pedido finalizado");
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(Pedido.class);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
