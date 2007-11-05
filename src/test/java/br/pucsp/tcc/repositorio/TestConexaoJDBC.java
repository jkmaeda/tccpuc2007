package br.pucsp.tcc.repositorio;

import junit.framework.TestCase;

public class TestConexaoJDBC extends TestCase 
{
    public void testarConexao() throws Exception
    {
        DBConnection.getConnection();
    }
}
