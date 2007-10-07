package br.pucsp.tcc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.pucsp.tcc.modelo.Cardapio;
import br.pucsp.tcc.modelo.ItemCardapio;

public class RepositorioCardapioJDBC 
	implements RepositorioCardapio 
{
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private ResultSet rsItem;
	
	public List<Cardapio> obterCardapios() {
		List<Cardapio> ret = new ArrayList<Cardapio>();
		List<ItemCardapio> itens = new ArrayList<ItemCardapio>();
		Cardapio cardapio = null;
		ItemCardapio item = null;
		RepositorioItemCardapio repItemCardapio = new RepositorioItemCardapioJDBC();
		String sql = "Select * from Cardapio";
		try {
			conn = DBConnection.getConnection();			
			stmt = conn.prepareStatement(sql);			
			rs = stmt.executeQuery();
			while (rs.next()) {
				cardapio = new Cardapio();
				sql = "select itemCardapioID from ItemCardapio where cardapioID = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, rs.getInt("cardapioID"));
				rsItem = stmt.executeQuery();
				while (rsItem.next()) {
					item = repItemCardapio.buscarPorId(rsItem.getInt("itemCardapioID"));
					itens.add(item);
				}
				cardapio.setItensCardapio(itens);
				ret.add(cardapio);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}	
}
