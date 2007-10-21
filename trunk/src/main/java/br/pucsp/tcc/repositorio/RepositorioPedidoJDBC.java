package br.pucsp.tcc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.pucsp.tcc.modelo.Conta;
import br.pucsp.tcc.modelo.ItemCardapio;
import br.pucsp.tcc.modelo.ItemPedido;
import br.pucsp.tcc.modelo.Pedido;

public class RepositorioPedidoJDBC implements RepositorioPedido
{
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public int salvar(Pedido pedido, Conta conta) {
		String sql = "";
		int pedidoID = -1;
		try {
			// cria o pedido
			sql = "insert into Pedido values (?)";
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);			
			stmt.setInt(1, conta.getId());
			stmt.execute();
			
			// recupera o pedido criado					
			sql = "select max(pedidoID) as pedidoID from Pedido";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			pedidoID = rs.getInt("PedidoID");
			
			// cria os itens do pedido
			for (ItemPedido item : pedido.getItensPedido()) {						
				sql = "insert into ItemPedido values (?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, item.getQuantidade());
				ItemCardapio itemCardapio = item.getItemCardapio();
				stmt.setInt(2, itemCardapio.getId());
				stmt.setInt(3, pedidoID);
				stmt.execute();
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {				
				throw new RuntimeException("");
			}
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				throw new RuntimeException("");
			}
		}
		return pedidoID;
	}
	
	public void excluir(Pedido pedido) {
		String sql = "delete from Pedido where PedidoID = ?";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pedido.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<ItemPedido> obterItens(Pedido pedido) {
		String sql = "select * from ItemPedido where pedidoID = ?";
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		ItemPedido item = null;
		RepositorioItemCardapio repositorio = new RepositorioItemCardapioJDBC();
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pedido.getId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				ItemCardapio itemCardapio = repositorio.buscarPorId(rs.getInt("itemCardapioID"));
				item = new ItemPedido(itemCardapio);
				item.setId(rs.getInt("itemPedidoID"));
				item.setQuantidade(rs.getInt("quantidade"));
				itens.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itens;
	}

	public void adicionarItem(ItemPedido item, Pedido pedido) {
		String sql = "insert into ItemPedido values (?,?,?)";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, item.getQuantidade());
			ItemCardapio itemCardapio = item.getItemCardapio();
			stmt.setInt(2, itemCardapio.getId());
			stmt.setInt(3, pedido.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void excluirItem(ItemPedido item) {
		String sql = "delete from ItemPedido where itemPedidoID = ?";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, item.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
