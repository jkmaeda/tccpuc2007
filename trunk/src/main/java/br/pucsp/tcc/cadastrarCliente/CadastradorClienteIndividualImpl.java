package br.pucsp.tcc.cadastrarCliente;

import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Identificacao;

class CadastradorClienteIndividualImpl implements CadastradorClienteIndividual {

	private Identificacao identificacao;
	private String nome;

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
	
	public void salvarCadastro() {
		ClienteIndividual clienteIndividual = new ClienteIndividual();
		clienteIndividual.setNome(nome);
		clienteIndividual.setIdentificacao(identificacao);
		//TODO realizar persistência do cliente
	}

}
