package br.pucsp.tcc.registrarPedido;

import java.util.List;

import br.pucsp.tcc.modelo.Cardapio;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.ItemCardapio;
import br.pucsp.tcc.modelo.ItemPedido;
import br.pucsp.tcc.modelo.Pedido;
import br.pucsp.tcc.registrarPedidoGui.RegistrarPedidosGui;
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
		this.cliente = cliente;
		pedido = new Pedido();
	}
	
	public Cardapio obterCardapio() {
		//TODO chamar cardápio
		return inventarCardapio();
	}
	
	public void adicionarItem(ItemCardapio itemCardapio) {
		ItemPedido itemPedido = new ItemPedido(itemCardapio);
		pedido.adicionarPedido(itemPedido);
		System.out.println("item adicionado ao cardapio");
	}
	
	public void fecharPedido() {
		Conta conta = cliente.getConta();
		conta.adicionarPedido(pedido);
		RepositorioConta repositorio = new FabricaRepositorio().getRepConta();
		repositorio.salvar(conta);
	}
	
	///HardCode
	private Cardapio inventarCardapio() {
//		new FabricaRepositorio().
		RepositorioCardapio repositorioCardapio = new FabricaRepositorio().getRepCardapio();
		
		List<Cardapio> cardapios = repositorioCardapio.obterCardapios();
//		Cardapio cardapio = new Cardapio();
//		List<ItemCardapio> itensCardapio = new ArrayList<ItemCardapio>();
//		//Item 1
//		ItemCardapio itemCardapio1 = new ItemCardapio();
//		itemCardapio1.setDescricao("Um produto estranho");
//		itemCardapio1.setId(1);
//		itemCardapio1.setNome("Estranho");
//		itemCardapio1.setPreco(12.90);
//		itensCardapio.add(itemCardapio1);
//		//Item 2
//		ItemCardapio itemCardapio2 = new ItemCardapio();
//		itemCardapio2.setDescricao("Um produto caro");
//		itemCardapio2.setId(1);
//		itemCardapio2.setNome("Caro");
//		itemCardapio2.setPreco(200.90);
//		itensCardapio.add(itemCardapio2);
//		//Item 3
//		ItemCardapio itemCardapio3 = new ItemCardapio();
//		itemCardapio3.setDescricao("Um produto ruim");
//		itemCardapio3.setId(1);
//		itemCardapio3.setNome("Ruim");
//		itemCardapio3.setPreco(0.1);
//		itensCardapio.add(itemCardapio3);
//		cardapio.setItensCardapio(itensCardapio);
//		cardapio.setItensCardapio(itensCardapio);
		return cardapios.get(0);
	}
	
}
