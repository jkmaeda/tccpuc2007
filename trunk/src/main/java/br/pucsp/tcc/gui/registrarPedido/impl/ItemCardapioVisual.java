package br.pucsp.tcc.gui.registrarPedido.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.pucsp.tcc.gui.componentesPersonalizados.MyJTextField;
import br.pucsp.tcc.gui.formataString.Formatacao;
import br.pucsp.tcc.gui.registrarPedido.RegistrarPedidos;
import br.pucsp.tcc.modelo.ItemCardapio;
import br.pucsp.tcc.modelo.ItemPedido;


@SuppressWarnings("serial")
public class ItemCardapioVisual extends JPanel {

	private ItemCardapio itemCardapio;
	private ItemPedido itemPedido;
	private RegistrarPedidos registradorPedidos;
//	private int quantidade = 0;
	private JButton jButton = null;
	private JTextField jTextField;
	private JPanel jPanelQuantidade;
	private JPanel jPanelCENTER = null;
	private JButton jButtonMenos = null;
	
	public ItemCardapioVisual(ItemCardapio itemCardapio, RegistrarPedidos registradorPedidos) {
		super();
		this.itemCardapio = itemCardapio;
		this.registradorPedidos = registradorPedidos;
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setPreferredSize(new Dimension(100, 40));
		this.setMinimumSize(new Dimension(100, 40));
		this.setToolTipText(itemCardapio.getDescricao());
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
        this.setLayout(new BorderLayout());
        this.add(getJPanelCENTER(), BorderLayout.CENTER);
        this.add(new JPanel(), BorderLayout.WEST);
        this.add(new JPanel(), BorderLayout.EAST);
			
	}

	private JTextField getJTextField() {
		if(jTextField == null) {
			jTextField = new MyJTextField();
			jTextField.setColumns(5);
			jTextField.setHorizontalAlignment(JTextField.RIGHT);
			mostrarQuantidade();
		}
		return jTextField;
	}
	
	private JPanel getJPanelQuantidade() {
		if(jPanelQuantidade == null) {
			BorderLayout borderLayout = new BorderLayout();
			jPanelQuantidade = new JPanel(borderLayout);
			jPanelQuantidade.add(getJTextField(), BorderLayout.CENTER);
		}
		return jPanelQuantidade;
	}
	
	private JButton getJButton() {
		if(jButton == null) {
			jButton = new JButton();
			jButton.setText(itemCardapio.getNome());
			jButton.addActionListener(new AcaoBotao());
			String toolTip = itemCardapio.getDescricao();
			toolTip += ". R$";
			String preco = String.valueOf(itemCardapio.getPreco());
			preco = Formatacao.arredondar(preco);
			toolTip += preco;
			jButton.setToolTipText(toolTip);
		}
		return jButton;
	}

//	private ItemPedido getItemPedido() {
//		return itemPedido;
//	}

	private ItemCardapio getItemCardapio() {
		return itemCardapio;
	}

	private void mostrarQuantidade() {
		if(itemPedido != null) {
			int quantidade = itemPedido.getQuantidade();
			String representacaoQuantidade = String.valueOf(quantidade);
			getJTextField().setText(representacaoQuantidade);
		}
		else {
			getJTextField().setText("0");
		}
	}

	public void setItemCardapio(ItemCardapio itemCardapio) {
		this.itemCardapio = itemCardapio;
	}
	
	public class AcaoBotao implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(itemPedido == null) {
				itemPedido = new ItemPedido(getItemCardapio());
				registradorPedidos.adicionarItem(itemPedido);
			}
			int quantidade = itemPedido.getQuantidade();
			quantidade++;
			itemPedido.setQuantidade(quantidade);
			mostrarQuantidade();
		}
		
	}

	/**
	 * This method initializes jPanelCENTER	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCENTER() {
		if (jPanelCENTER == null) {
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setHgap(5);
			jPanelCENTER = new JPanel();
			jPanelCENTER.setLayout(borderLayout1);
			jPanelCENTER.add(getJPanelQuantidade(), BorderLayout.WEST);
			jPanelCENTER.add(getJButton(), java.awt.BorderLayout.CENTER);
			jPanelCENTER.add(getJButtonMenos(), BorderLayout.EAST);
		}
		return jPanelCENTER;
	}

	/**
	 * This method initializes jButtonMenos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMenos() {
		if (jButtonMenos == null) {
			jButtonMenos = new JButton();
			jButtonMenos.setText(" - ");
			jButtonMenos.setFont(new Font("Dialog", Font.BOLD, 15));
			jButtonMenos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(itemPedido != null) {
						int quantidade = itemPedido.getQuantidade();
						if(quantidade > 0) {
							quantidade--;
						}
						itemPedido.setQuantidade(quantidade);
						mostrarQuantidade();
					}
				}
			});
		}
		return jButtonMenos;
	}
	
}
