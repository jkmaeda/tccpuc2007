package br.pucsp.tcc.repositorio;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.pucsp.tcc.infra.imagem.LeitorImagem;
import br.pucsp.tcc.infra.imagem.LeitorImagemFactory;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

public class RepositorioClienteJDBC implements RepositorioCliente 
{	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private LeitorImagem leitorImagem = LeitorImagemFactory.get();
	
	public void editar(ClienteIndividual c) {

		try {
			String sql = "update cliente set contaId = ?, nome = ?, nascimento = ?, telefoneFixo = ?, celular = ?, email = ? where clienteID = ?";
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);// verifica se existe conta para salvar a conta
			if (c.getConta() != null) {
				RepositorioConta repositorioConta = new FabricaRepositorio().getRepConta();
				int contaID = repositorioConta.salvar(c.getConta());
				stmt.setInt(1, contaID);
			} else {				
				stmt.setString(1, null);
			}
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getNascimento());
			stmt.setString(4, c.getTelefoneFixo());
			stmt.setString(5, c.getCelular());
			stmt.setString(6, c.getEmail());
			stmt.setInt(7, c.getId());
//			stmt.setInt(3, rs.getInt("clienteID"));
			stmt.execute();						
		} catch (Exception e) {
			e.printStackTrace();
		}
		///////////////////////////////////////
//		String sql = "update cliente set (?,?,?)";
//		RepositorioConta repositorioConta = new RepositorioContaJDBC();
//		ClienteIndividual cliente = (ClienteIndividual)c;
//		int clienteID = -1;
//		try {						 			 		
//			conn = DBConnection.getConnection();			
//			stmt = conn.prepareStatement(sql);
//			
//			// verifica se existe conta para salvar a conta
//			if (cliente.getConta() != null) {
//				int contaID = repositorioConta.salvar(cliente.getConta());
//				stmt.setInt(1, contaID);
//			} else {				
//				stmt.setString(1, null);
//			}
//			
//			// salva a identificação do cliente
////			ImpressaoDigital identificacao = (ImpressaoDigital)cliente.getIdentificacao();
////			byte [] imageBytes = leitorImagem.converter(identificacao.getInfo()); 
////			stmt.setBytes(2, imageBytes);
//			
//			// salva a foto do cliente
////			if (cliente.getFoto() != null) {
////				stmt.setBytes(3, leitorImagem.converter(cliente.getFoto()));
////			} else {
////				stmt.setBytes(3, null);
////			}
//						
//			stmt.setString(2, cliente.getNome());
//			stmt.setString(3, cliente.getCpf());
//			stmt.execute();
//			
//			// recupera o cliente criado
////			sql = "select max(clienteID) as clienteID from Cliente";
////			stmt = conn.prepareStatement(sql);
////			rs = stmt.executeQuery();
////			rs.next();
////			clienteID = rs.getInt("clienteID");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		return clienteID;
	}
		
	public int salvar(Cliente c) {
		String sql = "insert into cliente values (?,?,?,?,?,?,?,?,1,?)";
		RepositorioConta repositorioConta = new RepositorioContaJDBC();
		ClienteIndividual cliente = (ClienteIndividual)c;
		int clienteID = -1;
		try {						 			 		
			conn = DBConnection.getConnection();			
			stmt = conn.prepareStatement(sql);
			
			// verifica se existe conta para salvar a conta
			if (cliente.getConta() != null) {
				int contaID = repositorioConta.salvar(cliente.getConta());
				stmt.setInt(1, contaID);
			} else {				
				stmt.setString(1, null);
			}
			
			// salva a identificação do cliente
			ImpressaoDigital identificacao = (ImpressaoDigital)cliente.getIdentificacao();
			byte [] imageBytes = leitorImagem.converter(identificacao.getInfo()); 
			stmt.setBytes(2, imageBytes);
			
			// salva a foto do cliente
			if (cliente.getFoto() != null) {
				stmt.setBytes(3, leitorImagem.converter(cliente.getFoto()));
			} else {
				stmt.setBytes(3, null);
			}
						
			stmt.setString(4, cliente.getNome());
			stmt.setString(5, cliente.getNascimento());
			stmt.setString(6, cliente.getTelefoneFixo());
			stmt.setString(7, cliente.getCelular());
			stmt.setString(8, cliente.getEmail());
			
			stmt.setInt(9, identificacao.getTemplateId());
			stmt.execute();
			
			// recupera o cliente criado
			sql = "select max(clienteID) as clienteID from Cliente";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			clienteID = rs.getInt("clienteID");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clienteID;
	}

	public List<Cliente> obterClientes() {
		
		List<Cliente> ret = new ArrayList<Cliente>();  
		ClienteIndividual cliente = null;		
		RepositorioConta repConta = new RepositorioContaJDBC();		
		String sql = "select * from Cliente";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				cliente = new ClienteIndividual();
				cliente.setId(rs.getInt("clienteID"));
				cliente.setConta(repConta.obterConta(rs.getInt("contaID")));
				// recupera a identificação
				Image image = leitorImagem.converter(rs.getBytes("identificacao"));
				int templateId = rs.getInt("tempateId");
				ImpressaoDigital impressaoDigitalObtida = new ImpressaoDigital(image, templateId);
				cliente.setIdentificacao(impressaoDigitalObtida);
				// recupera a foto
				if (rs.getBytes("foto") != null) {
					cliente.setFoto(leitorImagem.converter(rs.getBytes("foto")));
				}
				cliente.setNome(rs.getString("nome"));
				cliente.setNascimento(rs.getString("nascimento"));
				cliente.setTelefoneFixo(rs.getString("telefoneFixo"));
				cliente.setCelular(rs.getString("celular"));
				cliente.setEmail(rs.getString("email"));
				ret.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public Cliente obterPorId(int id) {
		String sql = "select * from Cliente where clienteID = ?";
		ClienteIndividual ret = null;			
		RepositorioConta repConta = new RepositorioContaJDBC();		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = new ClienteIndividual();
				ret.setId(rs.getInt("clienteID"));				
				ret.setConta(repConta.obterConta(rs.getInt("contaID")));							
				// recupera a identificação
				ret.setIdentificacao(new ImpressaoDigital(leitorImagem.converter(rs.getBytes("identificacao")), rs.getInt("templateId")));
				// recupera a foto
				if (rs.getBytes("foto") != null) {
					ret.setFoto(leitorImagem.converter(rs.getBytes("foto")));
				}
				ret.setNome(rs.getString("nome"));
				ret.setNascimento(rs.getString("nascimento"));
				ret.setTelefoneFixo(rs.getString("telefoneFixo"));
				ret.setCelular(rs.getString("celular"));
				ret.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public ClienteIndividual obterCliente(Identificacao identificacao) {
		String sql = "select top 1 * from cliente where cast(identificacao as varbinary(max)) = cast(? as varbinary(max))";
		ClienteIndividual ret = null;			
		RepositorioConta repConta = new RepositorioContaJDBC();
		ImpressaoDigital digital = (ImpressaoDigital)identificacao;
		byte [] imageBytes = leitorImagem.converter(digital.getInfo());		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setBytes(1, imageBytes);
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = new ClienteIndividual();
				ret.setId(rs.getInt("clienteID"));				
				ret.setConta(repConta.obterConta(rs.getInt("contaID")));							
				// recupera a identificação
				ret.setIdentificacao(new ImpressaoDigital(leitorImagem.converter(rs.getBytes("identificacao")), rs.getInt("templateId")));
				// recupera a foto
				if (rs.getBytes("foto") != null) {
					ret.setFoto(leitorImagem.converter(rs.getBytes("foto")));
				}
				ret.setNome(rs.getString("nome"));
				ret.setNascimento(rs.getString("nascimento"));
				ret.setTelefoneFixo(rs.getString("telefoneFixo"));
				ret.setCelular(rs.getString("celular"));
				ret.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public Cliente obterPorNome(String nome) {
		String sql = "select * from Cliente where nome like ?";
		ClienteIndividual ret = null;			
		RepositorioConta repConta = new RepositorioContaJDBC();		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = new ClienteIndividual();
				ret.setId(rs.getInt("clienteID"));
				ret.setConta(repConta.obterConta(rs.getInt("contaID")));
				// recupera a identificação						
				ret.setIdentificacao(new ImpressaoDigital(leitorImagem.converter(rs.getBytes("identificacao")), rs.getInt("templateId")));
				// recupera a foto
				if (rs.getBytes("foto") != null) {
					ret.setFoto(leitorImagem.converter(rs.getBytes("foto")));
				}
				ret.setNome(rs.getString("nome"));	
				ret.setNascimento(rs.getString("nascimento"));
				ret.setTelefoneFixo(rs.getString("telefoneFixo"));
				ret.setCelular(rs.getString("celular"));
				ret.setEmail(rs.getString("email"));			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void excluir(Cliente cliente) {
		String sql = "delete from cliente where clienteID = ?";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ((ClienteIndividual)cliente).getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean existeCliente(Identificacao identificacao) {
		boolean ret = false;
		String sql = "select top 1 * from cliente where cast(identificacao as varbinary(max)) = cast(? as varbinary(max))";
		ImpressaoDigital digital = (ImpressaoDigital)identificacao;
		Image imageObtida = digital.getInfo();
		byte [] imageBytes = leitorImagem.converter(imageObtida); 
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setBytes(1, imageBytes);
			rs = stmt.executeQuery();
			ret = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ret;
	}

	public boolean existeCliente(int templateId) {
		String sql = "select * from Cliente where templateId = ?";
		boolean ret = false;			
		RepositorioConta repConta = new RepositorioContaJDBC();		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, templateId);
			rs = stmt.executeQuery();
			ret = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public ClienteIndividual obterCliente(int templateId) {
		String sql = "select * from Cliente where templateId = ?";
		ClienteIndividual ret = null;			
		RepositorioConta repConta = new RepositorioContaJDBC();		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, templateId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = new ClienteIndividual();
				ret.setId(rs.getInt("clienteID"));				
				ret.setConta(repConta.obterConta(rs.getInt("contaID")));							
				// recupera a identificação
				ret.setIdentificacao(new ImpressaoDigital(leitorImagem.converter(rs.getBytes("identificacao")), rs.getInt("templateId")));
				// recupera a foto
				if (rs.getBytes("foto") != null) {
					ret.setFoto(leitorImagem.converter(rs.getBytes("foto")));
				}
				ret.setNome(rs.getString("nome"));
				ret.setNascimento(rs.getString("nascimento"));
				ret.setTelefoneFixo(rs.getString("telefoneFixo"));
				ret.setCelular(rs.getString("celular"));
				ret.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
