package br.pucsp.tcc.cadastrarCliente;

import br.pucsp.tcc.cadastrarClienteGui.CadastroClienteIndividualGui;


public class FactoryTelaCadastro {

	public TelaCadastro fabricarTelaCadastro(CadastradorClienteIndividual cadastradorClienteIndividual) {
		TelaCadastro telaCadastro = new CadastroClienteIndividualGui(cadastradorClienteIndividual);
		return telaCadastro;
	}
	
}
