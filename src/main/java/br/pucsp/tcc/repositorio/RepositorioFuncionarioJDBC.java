package br.pucsp.tcc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.pucsp.tcc.modelo.Atendente;
import br.pucsp.tcc.modelo.Caixa;
import br.pucsp.tcc.modelo.Gerente;
import br.pucsp.tcc.modelo.Recepcionista;
import br.pucsp.tcc.modelo.Funcionario;

public class RepositorioFuncionarioJDBC implements RepositorioFuncionario {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	/**
	 * Atualiza o nome do funcionário
	 */
	public void atualizar(Funcionario funcionario) {
		
		try {
			String sql = "update Funcionario set nome = ? where funcionarioID = ?";
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setInt(2, rs.getInt("funcionarioID"));
			stmt.execute();						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Apaga o funcionário do banco de dados buscando-o pelo nome
	 */
	public void excluir(Funcionario funcionario) {
		String sql = "delete from Funcionario where nome = ?";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Insere o funcionário
	 */
	public void salvar(Funcionario funcionario) {
		String sql = "insert into Funcionario values(?,?,?,1)";
		try{
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, funcionario.getId());
			stmt.setString(2, funcionario.getNome());
			if (funcionario instanceof Atendente)
				stmt.setInt(3, 1);
			else if (funcionario instanceof Caixa)
				stmt.setInt(3, 2);
			else if (funcionario instanceof Gerente)
				stmt.setInt(3, 3);
			else if (funcionario instanceof Recepcionista)
				stmt.setInt(3, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Obtém o funcionário buscando-o pelo nome
	 */
	public void obter(Funcionario funcionario) {
		String sql = "select * from Funcionario where nome = ?";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
