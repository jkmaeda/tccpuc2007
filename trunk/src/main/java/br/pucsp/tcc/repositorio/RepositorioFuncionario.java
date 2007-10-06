package br.pucsp.tcc.repositorio;

import br.pucsp.tcc.modelo.Funcionario;

public interface RepositorioFuncionario {

	public void salvar (Funcionario funcionario);
	public void excluir (Funcionario funcionario);
	public void atualizar (Funcionario funcionario);
	public void obter (Funcionario funcionario);
}
