package br.pucsp.tcc.gui.cadastrarCliente;

public interface TelaCadastro {

	public void exibir();
	public void confirmarEdicao();
	public void confirmarCadastro();
	public void setNome(String nome);
	public void setNascimento(String nascimento);
	public void setTelefoneFixo(String telefoneFixo);
	public void setCelular(String celular);
	public void setEmail(String email);
	public void editarCliente();
	
}
