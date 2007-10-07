package br.pucsp.tcc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;

public class RepositorioClienteJDBC implements RepositorioCliente 
{	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public void salvar(Cliente cliente) {
		String sql = "insert into cliente values (?,?,?,?,1,null,1)";
		RepositorioConta repositorioConta = new RepositorioContaJDBC();
		RepositorioIdentificacao repIdentificacao = new RepositorioImpressaoDigitalJDBC();
		try {
			int contaID = repositorioConta.salvar(cliente.getConta());
			int identificacaoID = repIdentificacao.salvar(cliente.getIdentificacao());
			conn = DBConnection.getConnection();			
			stmt = conn.prepareStatement(sql);			
			stmt.setInt(1, contaID);
			stmt.setInt(2, identificacaoID);
			stmt.setString(3, ((ClienteIndividual) cliente).getNome());
			stmt.setString(3, ((ClienteIndividual) cliente).getCpf());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> obterClientes() {
		
		List<Cliente> ret = new ArrayList<Cliente>();  
		ClienteIndividual cliente = null;		
		RepositorioIdentificacao repIdentificacao = new RepositorioImpressaoDigitalJDBC();		
		RepositorioConta repConta = new RepositorioContaJDBC();		
		String sql = "select * from Cliente";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				cliente = new ClienteIndividual();				
				cliente.setCpf(rs.getString("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setIdentificacao(repIdentificacao.obterIdentificacaoPorId(rs.getInt("identificacaoID")));
				cliente.setConta(repConta.obterConta(rs.getInt("contaID")));
				cliente.setMesa(rs.getInt("clienteMesaID"));
				ret.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public Cliente obterPorId(int id) {
		String sql = "select * from Cliente where clienteID = ? and tipoClienteID = 1";
		ClienteIndividual ret = new ClienteIndividual();
		RepositorioIdentificacao repIdentificacao = new RepositorioImpressaoDigitalJDBC();		
		RepositorioConta repConta = new RepositorioContaJDBC();		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = new ClienteIndividual();				
				ret.setCpf(rs.getString("cpf"));
				ret.setNome(rs.getString("nome"));
				ret.setIdentificacao(repIdentificacao.obterIdentificacaoPorId(rs.getInt("identificacaoID")));
				ret.setConta(repConta.obterConta(rs.getInt("contaID")));
				ret.setMesa(rs.getInt("clienteMesaID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	public Cliente obterPorNome(String nome) {
		String sql = "select * from Cliente where nome like ?";
		ClienteIndividual ret = new ClienteIndividual();
		RepositorioIdentificacao repIdentificacao = new RepositorioImpressaoDigitalJDBC();		
		RepositorioConta repConta = new RepositorioContaJDBC();		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = new ClienteIndividual();				
				ret.setCpf(rs.getString("cpf"));
				ret.setNome(rs.getString("nome"));
				ret.setIdentificacao(repIdentificacao.obterIdentificacaoPorId(rs.getInt("identificacaoID")));
				ret.setConta(repConta.obterConta(rs.getInt("contaID")));
				ret.setMesa(rs.getInt("clienteMesaID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
