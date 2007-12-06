package br.pucsp.tcc.gui.cadastrarCliente;

public interface CadastramentoClienteIndividual extends CadastramentoCliente {

	public void setNome(String nome);

	public void editarCadastro();

	public void setNascimento(String nascimento);

	public void setTelefoneFixo(String telefoneFixo);

	public void setCelular(String celular);

	public void setEMail(String eMail);
	
}
