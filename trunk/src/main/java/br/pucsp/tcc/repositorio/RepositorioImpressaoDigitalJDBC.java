package br.pucsp.tcc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

public class RepositorioImpressaoDigitalJDBC 
	implements RepositorioIdentificacao 
{
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public void excluir(Identificacao id) {
		ImpressaoDigital identificacao = (ImpressaoDigital) id;
		String sql = "delete from identificacao where info = ?";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, identificacao.getInfo());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public boolean existeIdentificacao(Identificacao id) {
		boolean ret = false;
		ImpressaoDigital identificacao = (ImpressaoDigital) id;
		String sql = "select 1 from identificacao where info = ?";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, identificacao.getInfo());
			rs = stmt.executeQuery();
			ret = rs.next();			
		} catch (Exception e) {			
			e.printStackTrace();
		}				
		return ret;
	}

	public Identificacao obterIdentificacao(Object id) {
		String identificacao = (String) id;
		ImpressaoDigital ret = null;
		String sql = "select identificacaoID, info " +
	                 "from Identificacao " +
	                 "where tipoIdentificacaoID = 2 and info = ?";                     
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, identificacao);
			rs = stmt.executeQuery();
			rs.next();
			ret = new ImpressaoDigital(rs.getString("info"));
			ret.setId(rs.getInt("identificacaoID"));
		} catch (Exception e) {			
			e.printStackTrace();
		}				
		return ret;
	}

	public void salvar(Identificacao id) {
		ImpressaoDigital identificacao = (ImpressaoDigital) id;
		String sql = "insert into identificacao values (null,?,2)";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, identificacao.getInfo());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
}
