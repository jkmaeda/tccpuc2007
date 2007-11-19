package br.pucsp.tcc.gui.fecharConta;

import br.pucsp.tcc.modelo.Cliente;

public interface FechamentoDeContaGui {

	public void exibir();

	public void setCliente(Cliente cliente);

	public void setTotal(double total);

	public void setFechadorDeConta(FechamentoDeConta conta);
	
}
