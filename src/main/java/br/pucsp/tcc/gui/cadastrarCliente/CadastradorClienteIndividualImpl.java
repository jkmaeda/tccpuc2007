package br.pucsp.tcc.gui.cadastrarCliente;

import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.repositorio.FabricaRepositorio;
import br.pucsp.tcc.repositorio.RepositorioCliente;

public class CadastradorClienteIndividualImpl implements CadastrarClienteIndividual {

	private Identificacao identificacao;
	private String nome;
	private ClienteIndividual clienteIndividual;
	
	public CadastradorClienteIndividualImpl() {
		clienteIndividual = new ClienteIndividual();
	}

	public void solicitarInformacoesUsuario() {
		FactoryTelaCadastro factoryTelaCadastro = new FactoryTelaCadastro();
		TelaCadastro telaCadastro = factoryTelaCadastro.fabricarTelaCadastro(this);
		telaCadastro.exibir();
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
		clienteIndividual.setNome(nome);
		clienteIndividual.setIdentificacao(identificacao);
		//TODO realizar persistência do cliente
		FabricaRepositorio fabricaRepositorio = new FabricaRepositorio();
		RepositorioCliente repositorio = fabricaRepositorio.getRepCliente();
		repositorio.salvar(clienteIndividual);
	}

}
