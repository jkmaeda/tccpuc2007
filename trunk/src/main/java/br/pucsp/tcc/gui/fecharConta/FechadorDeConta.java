package br.pucsp.tcc.gui.fecharConta;

import br.pucsp.tcc.controle.impl.GerenciadorContaImpl;
import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ItemCardapio;
import br.pucsp.tcc.modelo.ItemPedido;
import br.pucsp.tcc.modelo.Pedido;

public class FechadorDeConta implements FechamentoDeConta {

	public Cliente cliente = null;
	
	public void solicitarConfirmacaoFechamentoConta(Identificacao identificacao) {
		FechamentoDeContaGui fechadorDecontaGui = FactoryFechamentoDeContaGui.criarTela();
		//TODO resgatar cliente do BD
		cliente = obterCliente(identificacao);
		Conta conta = cliente.getConta();
		fechadorDecontaGui.setCliente(cliente);
		fechadorDecontaGui.setFechadorDeConta(this);
		fechadorDecontaGui.setTotal(conta.saldo());
		fechadorDecontaGui.exibir();
	}

	public void fecharConta() {
		GerenciadorContaImpl contaImpl = new GerenciadorContaImpl();
		try {
			contaImpl.fecharConta(cliente);
		} catch (OperacaoInvalidaException e) {
			e.printStackTrace();
		}
	}

	private Cliente obterCliente(Identificacao identificacao) {
//	RepositorioCliente repositorioCliente = new FabricaRepositorio().getRepCliente();
//	ClienteIndividual clienteIndividual = repositorioCliente.obterCliente(identificacao);
//	return clienteIndividual;
		return inventarCliente(identificacao);
		//TODO remover o método inventar cliente quano o bd estiver funcionando
	}
	
	private ClienteIndividual inventarCliente(Identificacao identificacao) {
			Pedido pedido1 = new Pedido();
	//		Item 1
			ItemCardapio itemCardapio1 = new ItemCardapio();
			itemCardapio1.setDescricao("Um produto estranho");
			itemCardapio1.setId(1);
			itemCardapio1.setNome("Estranho");
			itemCardapio1.setPreco(12.90);
			ItemPedido itemPedido1 = new ItemPedido(itemCardapio1);
			itemPedido1.setQuantidade(1);
			pedido1.adicionarPedido(itemPedido1);
			//Item 2
			ItemCardapio itemCardapio2 = new ItemCardapio();
			itemCardapio2.setDescricao("Um produto caro");
			itemCardapio2.setId(1);
			itemCardapio2.setNome("Caro");
			itemCardapio2.setPreco(200.90);
			ItemPedido itemPedido2 = new ItemPedido(itemCardapio2);
			itemPedido2.setQuantidade(1);
			pedido1.adicionarPedido(itemPedido2);
			//Item 3
			ItemCardapio itemCardapio3 = new ItemCardapio();
			itemCardapio3.setDescricao("Um produto ruim");
			itemCardapio3.setId(1);
			itemCardapio3.setNome("Ruim");
			itemCardapio3.setPreco(0.1);
			ItemPedido itemPedido3 = new ItemPedido(itemCardapio3);
			itemPedido3.setQuantidade(6);
			pedido1.adicionarPedido(itemPedido3);
			Pedido pedido2 = new Pedido();
			//Item 4
			ItemCardapio itemCardapio4 = new ItemCardapio();
			itemCardapio4.setDescricao("Água mineral");
			itemCardapio4.setId(1);
			itemCardapio4.setNome("Água");
			itemCardapio4.setPreco(0.1);
			ItemPedido itemPedido4 = new ItemPedido(itemCardapio4);
			itemPedido4.setQuantidade(3);
			pedido2.adicionarPedido(itemPedido4);
			//Item 5
			ItemCardapio itemCardapio5 = new ItemCardapio();
			itemCardapio5.setDescricao("Bolo de chocolate");
			itemCardapio5.setId(1);
			itemCardapio5.setNome("Bolo");
			itemCardapio5.setPreco(0.1);
			ItemPedido itemPedido5 = new ItemPedido(itemCardapio5);
			itemPedido5.setQuantidade(1);
			pedido2.adicionarPedido(itemPedido5);
			//Item 6
			ItemCardapio itemCardapio6 = new ItemCardapio();
			itemCardapio6.setDescricao("Sanduiche de frango");
			itemCardapio6.setId(1);
			itemCardapio6.setNome("Sanduba");
			itemCardapio6.setPreco(0.1);
			ItemPedido itemPedido6 = new ItemPedido(itemCardapio6);
			itemPedido6.setQuantidade(5);
			pedido2.adicionarPedido(itemPedido6);
			//Item 7
			ItemCardapio itemCardapio7 = new ItemCardapio();
			itemCardapio7.setDescricao("Coca-cola com menos calorias");
			itemCardapio7.setId(1);
			itemCardapio7.setNome("Coca-Zero");
			itemCardapio7.setPreco(0.1);
			ItemPedido itemPedido7 = new ItemPedido(itemCardapio7);
			itemPedido7.setQuantidade(1);
			pedido2.adicionarPedido(itemPedido7);
			//Item 8
			ItemCardapio itemCardapio8 = new ItemCardapio();
			itemCardapio8.setDescricao("Coca-cola gelada ou sem gelo");
			itemCardapio8.setId(1);
			itemCardapio8.setNome("Coca-Cola");
			itemCardapio8.setPreco(0.1);
			ItemPedido itemPedido8 = new ItemPedido(itemCardapio8);
			itemPedido8.setQuantidade(1);
			pedido2.adicionarPedido(itemPedido8);
			//Item 9
			ItemCardapio itemCardapio9 = new ItemCardapio();
			itemCardapio9.setDescricao("Soda Antártica");
			itemCardapio9.setId(1);
			itemCardapio9.setNome("Soda");
			itemCardapio9.setPreco(0.1);
			ItemPedido itemPedido9 = new ItemPedido(itemCardapio9);
			itemPedido9.setQuantidade(3);
			pedido2.adicionarPedido(itemPedido9);
			
			Conta conta = new Conta();
			conta.adicionarPedido(pedido1);
			conta.adicionarPedido(pedido2);
			conta.adicionarPedido(pedido1);
			conta.adicionarPedido(pedido2);
			conta.adicionarPedido(pedido1);
			conta.adicionarPedido(pedido2);
			ClienteIndividual cliente = new ClienteIndividual();
			cliente.setConta(conta);
			cliente.setIdentificacao(identificacao);
			cliente.setNome("Fulano");
			return cliente;
		}

}
