package br.pucsp.tcc.cadastrarCliente;

public class Main {

	public static void main(String[] args) {
		CadastradorCliente cadastradorCliente = new CadastrarCliente(new FactoryCadastradorCliente());
		cadastradorCliente.cadastrarCliente();
	}
}
