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

public class RepositorioContaJDBC implements RepositorioConta{

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public int salvar(Conta conta) {
		String sql = "";
		int contaID = 0;		
		try {
			// cria a conta
			sql = "insert into Conta values (?)";
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);			
			stmt.setString(1, conta.getObservacao());		
			stmt.execute();
			
			// recupera a conta criada
			sql = "select max(contaID) as contaID from Conta";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			contaID = rs.getInt("contaID");
			
			// cria os pedidos					
			List<Pedido> pedidos = conta.getPedidos();	        
			if (!pedidos.isEmpty()) {
				for (Pedido pedido : pedidos) {									
					sql = "insert into Pedido values (?)";
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, contaID);
					stmt.execute();
					
					// recupera o pedido criado					
					sql = "select max(pedidoID) as pedidoID from Pedido";
					stmt = conn.prepareStatement(sql);
					rs = stmt.executeQuery();
					rs.next();
					int pedidoID = rs.getInt("PedidoID");
					
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
				}
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
		return contaID;
	}

	public Conta obterConta(int id) {
		Conta ret = null;
		PreparedStatement stmtIP = null;
		ResultSet rsIP = null;
		PreparedStatement stmtIC = null;
		ResultSet rsIC = null;		
		String sql = "select * from Conta where contaID = ?";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = new Conta();
				ret.setId(rs.getInt("contaID"));
				ret.setObservacao(rs.getString("observacao"));
				
				// recupera os pedidos
				Pedido pedido = null;
				ItemPedido itemPedido = null;
				ItemCardapio itemCardapio = null;
				
				sql = "select * from Pedido where contaID = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ret.getId());
				rs = stmt.executeQuery();
				List<Pedido> pedidos = new ArrayList<Pedido>();
				while (rs.next()) {
					pedido = new Pedido();
					pedido.setId(rs.getInt("pedidoID"));
					
					sql = "select * from ItemPedido where pedidoID = ?";
					stmtIP = conn.prepareStatement(sql);
					stmtIP.setInt(1, pedido.getId());
					rsIP = stmtIP.executeQuery();
					List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
					while (rsIP.next()) {
						itemPedido = new ItemPedido();
						itemPedido.setId(rsIP.getInt("itemPedidoID"));
						itemPedido.setQuantidade(rsIP.getInt("quantidade"));
						
						// recupera o item cardápio
						sql = "select * from ItemCardapio where itemCardapioID = ?";
						stmtIC = conn.prepareStatement(sql);
						stmtIC.setInt(1, rsIP.getInt("itemCardapioID"));
						rsIC= stmtIC.executeQuery();
						rsIC.next();
						itemCardapio = new ItemCardapio();
						itemCardapio.setId(rsIC.getInt("itemCardapioID"));
						itemCardapio.setPreco(rsIC.getDouble("preco"));
						itemCardapio.setNome(rsIC.getString("nome"));
						itemCardapio.setDescricao(rsIC.getString("descricao"));
						
						itemPedido.setItemCardapio(itemCardapio);
						
						itensPedido.add(itemPedido);
					}
					pedido.setItensPedido(itensPedido);
					pedidos.add(pedido);
				}
				ret.setPedidos(pedidos);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void excluir(Conta conta) {
		String sql = "delete from Conta where contaID = ?";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, conta.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Conta conta) {
		String sql = "";
		try {
			// atualiza a conta
			sql = "update Conta set observacao = ? where contaID = ?";
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, conta.getObservacao());
			stmt.setInt(2, conta.getId());
			stmt.execute();
			
			// recupera os pedidos e atualiza cada item
			List<Pedido> pedidos = conta.getPedidos();
			List<ItemPedido> itensPedido = null;
			for (Pedido pedido : pedidos) {
				itensPedido = pedido.getItensPedido();
				for (ItemPedido itemPedido : itensPedido) {
					sql = "update ItemPedido set quantidade = ?," +
							"itemCardapioID = ? where itemPedidoID = ?";
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, itemPedido.getQuantidade());
					stmt.setInt(2, itemPedido.getItemCardapio().getId());
					stmt.setInt(3, itemPedido.getId());
					stmt.execute();
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}