package br.pucsp.tcc.gui.fecharConta.impl;

import javax.swing.JComponent;

import br.pucsp.tcc.gui.formataString.Formatacao;
import br.pucsp.tcc.modelo.ItemPedido;

@SuppressWarnings("serial")
public class ItemPedidoVisual extends JComponent {

	private ItemPedido itemPedido;

	public ItemPedidoVisual(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
		this.setToolTipText(itemPedido.getItemCardapio().getDescricao());
	}
	
	public String toString() {
		String resultado = "";
		resultado += itemPedido.getQuantidade();
		resultado += " ";
		resultado += itemPedido.getItemCardapio().getNome();
		resultado += " (R$ ";
		double precoDouble = itemPedido.getItemCardapio().getPreco();
		String precoString = String.valueOf(precoDouble);
		precoString = Formatacao.arredondar(precoString);
		resultado += precoString;
		resultado += ")";
		return resultado;
	}
	
}
