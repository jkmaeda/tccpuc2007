package br.pucsp.tcc.gui.registrarPedido;

import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

public class SolicitadorRegistrarPedido {

	
	public static void main(String[] args) {
		Identificacao impressaoDigital = new ImpressaoDigital("12345678910");
		Conta conta = new Conta();
		ClienteIndividual clienteIndividual = new ClienteIndividual();
		clienteIndividual.setIdentificacao(impressaoDigital);
		clienteIndividual.setConta(conta);
		clienteIndividual.setNome("Cliente");
		RegistradorPedidos registradorPedidos = new RegistradorPedidos();
		registradorPedidos.abrirPedido(clienteIndividual);
		System.out.println(clienteIndividual);
	}
	
}
