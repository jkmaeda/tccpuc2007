package br.pucsp.tcc.gui.cadastrarCliente;

import br.pucsp.tcc.exception.ClienteNaoEncontrado;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;
import br.pucsp.tcc.repositorio.FabricaRepositorio;
import br.pucsp.tcc.repositorio.RepositorioCliente;

public class CadastradorClienteIndividualImpl implements CadastramentoClienteIndividual {

	private Identificacao identificacao;
	private String nome;
	private ClienteIndividual clienteIndividual;
	private RepositorioCliente repositorioCliente;
	private int id;
	private int templateId;
	private String celular;
	private String eMail;
	private String nascimento;
	private String telefoneFixo;
	
	public CadastradorClienteIndividualImpl() {
		clienteIndividual = new ClienteIndividual();
	}

	public void solicitarInformacoesUsuario() {
		FactoryTelaCadastro factoryTelaCadastro = new FactoryTelaCadastro();
		TelaCadastro telaCadastro = factoryTelaCadastro.fabricarTelaCadastro(this);
		if(isClienteCadastrado()) {
			ClienteIndividual clienteObtido = getRepositorioCliente().obterCliente(templateId);
			this.setCliente(clienteObtido);
			telaCadastro.setNome(clienteIndividual.getNome());
			telaCadastro.setNascimento(clienteIndividual.getNascimento());
			telaCadastro.setTelefoneFixo(clienteIndividual.getTelefoneFixo());
			telaCadastro.setCelular(clienteIndividual.getCelular());
			telaCadastro.setEmail(clienteIndividual.getEmail());
			telaCadastro.editarCliente();
		}
		telaCadastro.exibir();
	}
	
	public void setId(int id) {
		this.id = id;
	}

	private boolean isClienteCadastrado() {
		RepositorioCliente repositorioCliente = new FabricaRepositorio().getRepCliente();
		boolean estaCadastrado = repositorioCliente.existeCliente(templateId);
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
		ImpressaoDigital ip = (ImpressaoDigital)identificacao;
		this.templateId = ip.getTemplateId();
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	
	public void setCliente(Cliente cliente) {
		this.clienteIndividual = (ClienteIndividual)cliente;
		this.setIdentificacao(clienteIndividual.getIdentificacao());
		this.setNome(clienteIndividual.getNome());
		this.setNascimento(clienteIndividual.getNascimento());
		this.setTelefoneFixo(clienteIndividual.getTelefoneFixo());
		this.setCelular(clienteIndividual.getCelular());
		this.setEMail(clienteIndividual.getEmail());
		this.setId(clienteIndividual.getId());
	}
	
	public void salvarCadastro() {
		clienteIndividual.setConta(new Conta());
		clienteIndividual.setNome(nome);
		clienteIndividual.setNascimento(nascimento);
		clienteIndividual.setTelefoneFixo(telefoneFixo);
		clienteIndividual.setCelular(celular);
		clienteIndividual.setEmail(eMail);
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
		clienteIndividual.setNascimento(nascimento);
		clienteIndividual.setTelefoneFixo(telefoneFixo);
		clienteIndividual.setCelular(celular);
		clienteIndividual.setEmail(eMail);
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
