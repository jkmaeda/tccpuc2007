package br.pucsp.tcc.gui.registrarPedido;

import java.util.ArrayList;
import java.util.List;

import br.pucsp.tcc.controle.GerenciadorConta;
import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.gui.registrarPedido.impl.RegistrarPedidosGui;
import br.pucsp.tcc.modelo.Cardapio;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.ItemCardapio;
import br.pucsp.tcc.modelo.ItemPedido;
import br.pucsp.tcc.modelo.Pedido;
import br.pucsp.tcc.repositorio.FabricaRepositorio;
import br.pucsp.tcc.repositorio.RepositorioCardapio;
import br.pucsp.tcc.repositorio.RepositorioConta;

public class RegistradorPedidos 
	implements RegistrarPedidos {
	
	private FactoryRegistradorPedidosGui factoryRegistradorPedidosGui;
	private RegistrarPedidosGui registradorPedidosGui;
	private Cliente cliente;
	private Pedido pedido;
	
	public RegistradorPedidos() {
		factoryRegistradorPedidosGui = new FactoryRegistradorPedidosGui();
		registradorPedidosGui = factoryRegistradorPedidosGui.fabricarRegistrador(this);
		registradorPedidosGui.setCardapio(obterCardapio());
		registradorPedidosGui.exibir();
	}

	public void abrirPedido(Cliente cliente) {
//		GerenciadorContaImpl gerenciadorContaImpl = new GerenciadorContaImpl();
//		try {
//			gerenciadorContaImpl.abrirConta(cliente);
//		} catch (OperacaoInvalidaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		this.cliente = cliente;
		pedido = new Pedido();
	}
	
	public Cardapio obterCardapio() {
		RepositorioCardapio repositorioCardapio = new FabricaRepositorio().getRepCardapio();
		List<Cardapio> cardapios = repositorioCardapio.obterCardapios();
		return cardapios.get(0);
		//TODO chamar cardápio
//		return inventarCardapio();
	}
	
	public void adicionarItem(ItemPedido itemPedido) {
		pedido.adicionarItemPedido(itemPedido);
	}
	
	public void fecharPedido() {
		RepositorioConta repositorioConta = new FabricaRepositorio().getRepConta();
		Conta conta = cliente.getConta();
		conta.adicionarPedido(pedido);
		repositorioConta.salvar(conta);
//		GerenciadorPedidoImpl gerenciadorPedidoImpl = new GerenciadorPedidoImpl();
//		try {
//			gerenciadorPedidoImpl.registrarPedido(cliente, pedido);
//		} catch (OperacaoInvalidaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		Conta conta = cliente.getConta();
//		mostrarPedido();// TODO apagar este método quando não for mais útil
//		conta.adicionarPedido(pedido);
//		RepositorioConta repositorio = new FabricaRepositorio().getRepConta();
//		repositorio.salvar(conta);
	}
	
	private void mostrarPedido() {
		List<ItemPedido> itens = pedido.getItensPedido();
		for(ItemPedido cada : itens) {
			int quantidade = cada.getQuantidade();
			ItemCardapio itemCardapio = cada.getItemCardapio();
		}
	}

	///HardCode
	private Cardapio inventarCardapio() {
//		new FabricaRepositorio().
//		RepositorioCardapio repositorioCardapio = new FabricaRepositorio().getRepCardapio();
		
//		List<Cardapio> cardapios = repositorioCardapio.obterCardapios();
		Cardapio cardapio = new Cardapio();
		List<ItemCardapio> itensCardapio = new ArrayList<ItemCardapio>();
		//Item 1
		ItemCardapio itemCardapio1 = new ItemCardapio();
		itemCardapio1.setDescricao("Pizza Mussarela com azeitonas");
		itemCardapio1.setId(1);
		itemCardapio1.setNome("Pizza Mussarela");
		itemCardapio1.setPreco(12.90);
		itensCardapio.add(itemCardapio1);
		//Item 2
		ItemCardapio itemCardapio2 = new ItemCardapio();
		itemCardapio2.setDescricao("Pizza de calabreza com cebola");
		itemCardapio2.setId(1);
		itemCardapio2.setNome("Pizza de calabreza");
		itemCardapio2.setPreco(200.90);
		itensCardapio.add(itemCardapio2);
		//Item 3
		ItemCardapio itemCardapio3 = new ItemCardapio();
		itemCardapio3.setDescricao("Cheese Burguer de carne bovina");
		itemCardapio3.setId(1);
		itemCardapio3.setNome("Cheese Burger");
		itemCardapio3.setPreco(0.1);
		itensCardapio.add(itemCardapio3);
		//Item 4
		ItemCardapio itemCardapio4 = new ItemCardapio();
		itemCardapio4.setDescricao("Água mineral");
		itemCardapio4.setId(1);
		itemCardapio4.setNome("Água");
		itemCardapio4.setPreco(0.1);
		itensCardapio.add(itemCardapio4);
		//Item 5
		ItemCardapio itemCardapio5 = new ItemCardapio();
		itemCardapio5.setDescricao("Bolo de chocolate");
		itemCardapio5.setId(1);
		itemCardapio5.setNome("Bolo");
		itemCardapio5.setPreco(0.1);
		itensCardapio.add(itemCardapio5);
		//Item 6
		ItemCardapio itemCardapio6 = new ItemCardapio();
		itemCardapio6.setDescricao("Sanduiche de frango");
		itemCardapio6.setId(1);
		itemCardapio6.setNome("Sanduba");
		itemCardapio6.setPreco(0.1);
		itensCardapio.add(itemCardapio6);
		//Item 7
		ItemCardapio itemCardapio7 = new ItemCardapio();
		itemCardapio7.setDescricao("Coca-cola com menos calorias");
		itemCardapio7.setId(1);
		itemCardapio7.setNome("Coca-Zero");
		itemCardapio7.setPreco(0.1);
		itensCardapio.add(itemCardapio7);
		//Item 8
		ItemCardapio itemCardapio8 = new ItemCardapio();
		itemCardapio8.setDescricao("Coca-cola gelada ou sem gelo");
		itemCardapio8.setId(1);
		itemCardapio8.setNome("Coca-Cola");
		itemCardapio8.setPreco(0.1);
		itensCardapio.add(itemCardapio8);
		//Item 9
		ItemCardapio itemCardapio9 = new ItemCardapio();
		itemCardapio9.setDescricao("Soda Antártica");
		itemCardapio9.setId(1);
		itemCardapio9.setNome("Soda");
		itemCardapio9.setPreco(0.1);
		itensCardapio.add(itemCardapio9);
		//Item 10
		ItemCardapio itemCardapio10 = new ItemCardapio();
		itemCardapio10.setDescricao("Fanta Laranja ou uva");
		itemCardapio10.setId(1);
		itemCardapio10.setNome("Fanta");
		itemCardapio10.setPreco(0.1);
		itensCardapio.add(itemCardapio10);
		
		cardapio.setItensCardapio(itensCardapio);
		return cardapio;
	}
	
}
