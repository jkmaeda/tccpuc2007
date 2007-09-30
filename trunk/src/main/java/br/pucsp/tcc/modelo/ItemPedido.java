package br.pucsp.tcc.modelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ItemPedido
{
	private int id;
    private int quantidade;    
    private ItemCardapio itemCardapio;
    
    public ItemPedido() {
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }
    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(ItemPedido.class);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
