package br.pucsp.tcc.gui.cadastrarCliente;

import br.pucsp.tcc.exception.ClienteNaoEncontrado;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.repositorio.FabricaRepositorio;
import br.pucsp.tcc.repositorio.RepositorioCliente;

public class CadastradorClienteIndividualImpl implements CadastramentoClienteIndividual {

	private Identificacao identificacao;
	private String nome;
	private ClienteIndividual clienteIndividual;
	private RepositorioCliente repositorioCliente;
	private int id;
	
	public CadastradorClienteIndividualImpl() {
		clienteIndividual = new ClienteIndividual();
	}

	public void solicitarInformacoesUsuario() {
		FactoryTelaCadastro factoryTelaCadastro = new FactoryTelaCadastro();
		TelaCadastro telaCadastro = factoryTelaCadastro.fabricarTelaCadastro(this);
		if(isClienteCadastrado()) {
			System.out.println("cliente cadastrado");
			clienteIndividual = getRepositorioCliente().obterCliente(identificacao);
			this.setIdentificacao(clienteIndividual.getIdentificacao());
			this.setNome(clienteIndividual.getNome());
			this.setId(clienteIndividual.getId());
			telaCadastro.setNome(clienteIndividual.getNome());
			telaCadastro.editarCliente();
		}
		telaCadastro.exibir();
	}
	
	public void setId(int id) {
		this.id = id;
	}

	private boolean isClienteCadastrado() {
		RepositorioCliente repositorioCliente = new FabricaRepositorio().getRepCliente();
		boolean estaCadastrado = repositorioCliente.existeCliente(identificacao);
		return estaCadastrado;
	}
	
	private RepositorioCliente getRepositorioCliente() {
		if(repositorioCliente == null) {
			repositorioCliente = new FabricaRepositorio().getRepCliente();
		}
		return repositorioCliente;
	}

	public void setIdentificacao(Identificacao identificacao) {
		this.identificacao = identificacao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCliente(Cliente cliente) {
		this.clienteIndividual = (ClienteIndividual)cliente;
	}
	
	public void salvarCadastro() {
		clienteIndividual.setConta(new Conta());
		clienteIndividual.setNome(nome);
		clienteIndividual.setIdentificacao(identificacao);
		//TODO realizar persistência do cliente
		FabricaRepositorio fabricaRepositorio = new FabricaRepositorio();
		RepositorioCliente repositorio = fabricaRepositorio.getRepCliente();
		repositorio.salvar(clienteIndividual);
	}

	public Identificacao getIdentificacao() {
		return identificacao;
	}

	public void editarCadastro() {
		clienteIndividual.setId(id);
		clienteIndividual.setNome(nome);
		clienteIndividual.setIdentificacao(identificacao);
		RepositorioCliente repositorioCliente = new FabricaRepositorio().getRepCliente();
		repositorioCliente.editar(clienteIndividual);
//		GerenciadorClienteImpl gerenciadorClienteImpl = new GerenciadorClienteImpl();
//		try {
//			gerenciadorClienteImpl.editarClienteIndividual(clienteIndividual);
//		} catch (ClienteNaoEncontrado e) {
//			e.printStackTrace();
//		}
	}

}
