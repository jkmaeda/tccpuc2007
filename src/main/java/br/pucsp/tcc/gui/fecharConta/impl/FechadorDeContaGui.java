package br.pucsp.tcc.gui.fecharConta.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import br.pucsp.tcc.gui.fecharConta.FechadorDeConta;
import br.pucsp.tcc.gui.fecharConta.FechamentoDeConta;
import br.pucsp.tcc.gui.fecharConta.FechamentoDeContaGui;
import br.pucsp.tcc.gui.formataString.Formatacao;
import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;
import br.pucsp.tcc.gui.mdi.Mdi;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.ItemPedido;
import br.pucsp.tcc.modelo.Pedido;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class FechadorDeContaGui implements FechamentoDeContaGui {

	private Mdi jFrame = null;
	private JPanel jContentPane = null;
	private ClienteIndividual cliente;
	private JPanel jPanelCENTER = null;
	private JPanel jPanelNome = null;
	private JLabel jLabelNome = null;
	private JTextField jTextFieldNome = null;
	private JScrollPane jScrollPanePedidos = null;
	private JPanel jPanelPedidos = null;
	private JButton jButtonFecharConta = null;
	private JPanel jPanelItens = null;
	private JPanel jPanelTotal = null;
	private JLabel jLabelTotal = null;
	private FechamentoDeConta fechadorDeConta;
	private JPanel jPanelBotoes = null;
	private JPanel jPanelCenterBotoes = null;
	private JButton jButtonCancelar = null;

//	public FechadorDeContaGui() {
//		getJFrame();
//	}
	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private Mdi getJFrame() {
		if (jFrame == null) {
			jFrame = FactorySingletonMdi.Construir();
//			jFrame.setSize(new Dimension(321, 181));
			jFrame.setContentPane(getJContentPane());
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setName("Fechamento de Conta");
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanelCENTER(), BorderLayout.CENTER);
			jContentPane.add(new JPanel(), BorderLayout.NORTH);
			jContentPane.add(new JPanel(), BorderLayout.SOUTH);
			jContentPane.add(new JPanel(), BorderLayout.EAST);
			jContentPane.add(new JPanel(), BorderLayout.WEST);
		}
		return jContentPane;
	}

	public void exibir() {
		getJFrame().setVisible(true);
	}

	public void setCliente(Cliente cliente) {
		this.cliente = (ClienteIndividual)cliente;
	}

	/**
	 * This method initializes jPanelCENTER	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCENTER() {
		if (jPanelCENTER == null) {
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setVgap(10);
			jPanelCENTER = new JPanel();
			jPanelCENTER.setLayout(borderLayout1);
			jPanelCENTER.add(getJPanelNome(), BorderLayout.NORTH);
			jPanelCENTER.add(getJPanelItens(), BorderLayout.CENTER);
			jPanelCENTER.add(getJPanelBotoes(), BorderLayout.SOUTH);
		}
		return jPanelCENTER;
	}

	/**
	 * This method initializes jPanelNome	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelNome() {
		if (jPanelNome == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setVgap(7);
			borderLayout.setHgap(7);
			jLabelNome = new JLabel();
			jLabelNome.setText("Nome:");
			jLabelNome.setHorizontalAlignment(SwingConstants.RIGHT);
			jPanelNome = new JPanel();
			jPanelNome.setLayout(borderLayout);
			jPanelNome.add(jLabelNome, BorderLayout.WEST);
			jPanelNome.add(getJTextFieldNome(), BorderLayout.CENTER);
		}
		return jPanelNome;
	}

	/**
	 * This method initializes jTextFieldNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNome() {
		if (jTextFieldNome == null) {
			jTextFieldNome = new JTextField();
			jTextFieldNome.setText(cliente.getNome());
		}
		return jTextFieldNome;
	}

	/**
	 * This method initializes jScrollPanePedidos	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPanePedidos() {
		if (jScrollPanePedidos == null) {
			jScrollPanePedidos = new JScrollPane();
			jScrollPanePedidos.setViewportView(getJPanelPedidos());
		}
		return jScrollPanePedidos;
	}

	/**
	 * This method initializes jPanelPedidos	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelPedidos() {
		if (jPanelPedidos == null) {
			GridLayout gridLayout = new GridLayout();
			Conta conta = cliente.getConta();
			List<Pedido> pedidos = conta.getPedidos();
			if(pedidos.size() == 0) {
				gridLayout.setRows(1);
			}
			else {
				gridLayout.setRows(pedidos.size());
			}
			gridLayout.setColumns(1);
			jPanelPedidos = new JPanel();
			jPanelPedidos.setLayout(gridLayout);
			mostrarPedidos(pedidos, jPanelPedidos);
		}
		return jPanelPedidos;
	}

	private void mostrarPedidos(List<Pedido> pedidos, JPanel panelPedidos) {
		int contador = 0;
		for(Pedido cadaPedido : pedidos) {
			contador++;
			JPanel panel = new JPanel(new BorderLayout());
			panel.setBorder(BorderFactory.createTitledBorder(null, "Pedido "+contador, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			mostrarItensPedidos(cadaPedido, panel);
			panelPedidos.add(panel);
		}
	}

	private void mostrarItensPedidos(Pedido pedido, JPanel panel) {
		JList list = null;
		list = new JList();
		DefaultListModel defaultListModel = new DefaultListModel();
		for(ItemPedido itemPedido : pedido.getItensPedido()) {
			defaultListModel.add(0, new ItemPedidoVisual(itemPedido));
		}
		if(list != null) {
			list.setModel(defaultListModel);
			panel.add(list, BorderLayout.CENTER);
		}
	}

	/**
	 * This method initializes jButtonFecharConta	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonFecharConta() {
		if (jButtonFecharConta == null) {
			jButtonFecharConta = new JButton();
			jButtonFecharConta.setText("Fechar Conta");
			jButtonFecharConta.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					fechadorDeConta.fecharConta();
					getJFrame().dispose();
				}
			
			});
		}
		return jButtonFecharConta;
	}

	public void setTotal(double total) {
		String jLabelText = "";
		String valor = String.valueOf(total);
		valor = Formatacao.arredondar(valor);
		jLabelText += valor;
		getJLabelTotal().setText(jLabelText);
	}

	/**
	 * This method initializes jPanelItens	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelItens() {
		if (jPanelItens == null) {
			BorderLayout borderLayout2 = new BorderLayout();
			borderLayout2.setVgap(7);
			jPanelItens = new JPanel();
			jPanelItens.setLayout(borderLayout2);
			jPanelItens.add(getJScrollPanePedidos(), BorderLayout.CENTER);
			jPanelItens.add(getJPanelTotal(), BorderLayout.SOUTH);
		}
		return jPanelItens;
	}

	/**
	 * This method initializes jPanelTotal	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelTotal() {
		if (jPanelTotal == null) {
			jPanelTotal = new JPanel();
			jPanelTotal.setLayout(new BorderLayout());
			jPanelTotal.setBorder(BorderFactory.createTitledBorder(null, "Total", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 18), Color.BLUE));
			jPanelTotal.add(getJLabelTotal(), BorderLayout.CENTER);
		}
		return jPanelTotal;
	}
	
	private JLabel getJLabelTotal() {
		if(jLabelTotal == null) {
			jLabelTotal = new JLabel();
			jLabelTotal.setText("");
			jLabelTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
			jLabelTotal.setForeground(Color.blue);
		}
		return jLabelTotal;
	}

	public void setFechadorDeConta(FechamentoDeConta fechadorDeConta) {
		this.fechadorDeConta = fechadorDeConta;
	}

	/**
	 * This method initializes jPanelBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBotoes() {
		if (jPanelBotoes == null) {
			BorderLayout borderLayout3 = new BorderLayout();
			borderLayout3.setHgap(40);
			jPanelBotoes = new JPanel();
			jPanelBotoes.setLayout(borderLayout3);
			jPanelBotoes.add(getJPanelCenterBotoes(), BorderLayout.CENTER);
			jPanelBotoes.add(new JPanel(), BorderLayout.WEST);
			jPanelBotoes.add(new JPanel(), BorderLayout.EAST);
		}
		return jPanelBotoes;
	}

	/**
	 * This method initializes jPanelCenterBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCenterBotoes() {
		if (jPanelCenterBotoes == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			gridLayout1.setHgap(50);
			gridLayout1.setColumns(2);
			jPanelCenterBotoes = new JPanel();
			jPanelCenterBotoes.setLayout(gridLayout1);
			jPanelCenterBotoes.add(getJButtonFecharConta(), null);
			jPanelCenterBotoes.add(getJButtonCancelar(), null);
		}
		return jPanelCenterBotoes;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jFrame.dispose();
				}
			});
		}
		return jButtonCancelar;
	}

}
