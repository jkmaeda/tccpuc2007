package br.pucsp.tcc.gui.cadastrarCliente;

import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.Identificacao;

public interface CadastrarCliente {

	public void setIdentificacao(Identificacao identificacao);
	public void salvarCadastro();
	public void solicitarInformacoesUsuario();
	public void setCliente(Cliente cliente);
	
	public Identificacao getIdentificacao();
	
}
