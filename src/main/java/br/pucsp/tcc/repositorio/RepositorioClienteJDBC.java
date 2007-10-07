package br.pucsp.tcc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.ItemCardapio;
import br.pucsp.tcc.modelo.ItemPedido;
import br.pucsp.tcc.modelo.Pedido;

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
			stmt.setString(3, cliente.getNome());
			stmt.setString(3, cliente.getCpf());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> obterClientes() {
		
//		List<Cliente> clientes  
//		Cliente ret = null;
//		PreparedStatement stmtIP = null;
//		ResultSet rsIP = null;
//		PreparedStatement stmtIC = null;
//		ResultSet rsIC = null;
//		RepositorioIdentificacao repIdentificacao = new RepositorioImpressaoDigitalJDBC();
//		RepositorioConta repConta = new RepositorioContaJDBC();
//		String sql = "select * from Cliente";
//		try {
//			conn = DBConnection.getConnection();
//			stmt = conn.prepareStatement(sql);
//			rs = stmt.executeQuery();
//			if (rs.next()) {
//				ret = new Cliente();
//				ret.setCpf(rs.getString("cpf"));
//				ret.setNome(rs.getString("nome"));
//				ret.setIdentificacao(repIdentificacao.obterIdentificacao(id);
//				ret.setConta(repConta.obterConta(id);
//			}
		return null;
	}

	public Cliente obterPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente obterPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
}
