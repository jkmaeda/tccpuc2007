package br.pucsp.tcc.gui.cadastrarCliente;

import br.pucsp.tcc.gui.cadastrarCliente.impl.CadastroClienteIndividualGui;


public class FactoryTelaCadastro {

	public TelaCadastro fabricarTelaCadastro(CadastramentoClienteIndividual cadastradorClienteIndividual) {
		TelaCadastro telaCadastro = new CadastroClienteIndividualGui(cadastradorClienteIndividual);
		return telaCadastro;
	}
	
}
