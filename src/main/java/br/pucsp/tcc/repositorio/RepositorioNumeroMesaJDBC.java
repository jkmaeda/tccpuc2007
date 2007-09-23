package br.pucsp.tcc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.NumeroMesa;

public class RepositorioNumeroMesaJDBC implements RepositorioIdentificacao {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public boolean existeIdentificacao(Identificacao id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Identificacao obterIdentificacao(Object id) {
		int identificacao = (Integer) id;
		Identificacao ret = null;
		String sql = "select identificacaoID, numeroMesa " +
	                 "from Identificacao " +
	                 "where tipoIdentificacaoID = 1 and numeroMesa = ?";                     
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, identificacao);
			rs = stmt.executeQuery();
			rs.next();
			ret = new NumeroMesa(rs.getInt("numeroMesa"));
		} catch (Exception e) {			
			e.printStackTrace();
		}				
		return ret;
	}
}
