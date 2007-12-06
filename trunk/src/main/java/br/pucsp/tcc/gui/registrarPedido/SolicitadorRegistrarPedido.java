package br.pucsp.tcc.gui.registrarPedido;

import br.pucsp.tcc.mock.biometria.ImpressaoDigitalMock;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.Identificacao;

public class SolicitadorRegistrarPedido {

	
	public static void main(String[] args) {
		Identificacao impressaoDigital = ImpressaoDigitalMock.digital9;
		Conta conta = new Conta();
		ClienteIndividual clienteIndividual = new ClienteIndividual();
		clienteIndividual.setIdentificacao(impressaoDigital);
		clienteIndividual.setConta(conta);
		clienteIndividual.setNome("Cliente");
		RegistradorPedidos registradorPedidos = new RegistradorPedidos();
		registradorPedidos.abrirPedido(clienteIndividual);
	}
	
}
