package br.pucsp.tcc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.pucsp.tcc.modelo.ItemCardapio;

public class RepositorioItemCardapioJDBC implements RepositorioItemCardapio {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public void atualizar(ItemCardapio item) {
		String sql = "update itemcardapio set preco = ? , descricao = ? where nome = ?";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, item.getPreco());
			stmt.setString(2, item.getDescricao());
			stmt.setString(3, item.getNome());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(ItemCardapio item) {
		String sql = "delete from itemcardapio where nome = ?";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, item.getNome());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ItemCardapio> obterItensCardapio() {
		List<ItemCardapio> ret = new ArrayList<ItemCardapio>();
		String sql = "select * from itemcardapio";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ItemCardapio item = new ItemCardapio();
				item.setNome(rs.getString("nome"));
				item.setPreco(rs.getDouble("preco"));
				item.setDescricao(rs.getString("descricao"));
				ret.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void salvar(ItemCardapio item) {
		String sql = "insert into itemcardapio values (?,?,?,1)";		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, item.getPreco());
			stmt.setString(2, item.getNome());
			stmt.setString(3, item.getDescricao());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ItemCardapio buscarPorNome(String nome) {
		ItemCardapio ret = null;
		String sql = "select * from itemcardapio where nome = ?";		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);			
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = new ItemCardapio();
				ret.setNome(rs.getString("nome"));
				ret.setPreco(rs.getDouble("preco"));
				ret.setDescricao(rs.getString("descricao"));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public ItemCardapio buscarPorId(int id) {
		ItemCardapio ret = null;
		String sql = "select * from itemcardapio where itemCardapioID = ?";		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);			
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = new ItemCardapio();
				ret.setId(rs.getInt("itemCardapioId"));
				ret.setNome(rs.getString("nome"));
				ret.setPreco(rs.getDouble("preco"));
				ret.setDescricao(rs.getString("descricao"));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
