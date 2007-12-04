package br.pucsp.tcc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.pucsp.tcc.gui2.managers.CadastroClienteFormManager;
import br.pucsp.tcc.infra.imagem.LeitorImagem;
import br.pucsp.tcc.infra.imagem.LeitorImagemFactory;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

import com.griaule.grFinger.Context;
import com.griaule.grFinger.FingerprintImage;
import com.griaule.grFinger.FingerprintTemplate;
import com.griaule.grFinger.GrErrorException;
import com.griaule.grFinger.MatchingResult;

public class RepositorioClienteJDBC implements RepositorioCliente
{
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    private LeitorImagem leitorImagem = LeitorImagemFactory.get();
    
    public void editar(ClienteIndividual c)
    {
        
        try
        {
            String sql = "update cliente set contaId = ?, nome = ?, cpf = ? where clienteID = ?";
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);// verifica se existe conta para
                                                // salvar a conta
            if(c.getConta() != null)
            {
                RepositorioConta repositorioConta = new FabricaRepositorio()
                        .getRepConta();
                int contaID = repositorioConta.salvar(c.getConta());
                stmt.setInt(1, contaID);
            }
            else
            {
                stmt.setString(1, null);
            }
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getCpf());
            stmt.setInt(4, c.getId());
            // stmt.setInt(3, rs.getInt("clienteID"));
            stmt.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        // /////////////////////////////////////
        // String sql = "update cliente set (?,?,?)";
        // RepositorioConta repositorioConta = new RepositorioContaJDBC();
        // ClienteIndividual cliente = (ClienteIndividual)c;
        // int clienteID = -1;
        // try {
        // conn = DBConnection.getConnection();
        // stmt = conn.prepareStatement(sql);
        //			
        // // verifica se existe conta para salvar a conta
        // if (cliente.getConta() != null) {
        // int contaID = repositorioConta.salvar(cliente.getConta());
        // stmt.setInt(1, contaID);
        // } else {
        // stmt.setString(1, null);
        // }
        //			
        // // salva a identificação do cliente
        // // ImpressaoDigital identificacao =
        // (ImpressaoDigital)cliente.getIdentificacao();
        // // byte [] imageBytes = leitorImagem.converter(identificacao.getInfo());
        // // stmt.setBytes(2, imageBytes);
        //			
        // // salva a foto do cliente
        // // if (cliente.getFoto() != null) {
        // // stmt.setBytes(3, leitorImagem.converter(cliente.getFoto()));
        // // } else {
        // // stmt.setBytes(3, null);
        // // }
        //						
        // stmt.setString(2, cliente.getNome());
        // stmt.setString(3, cliente.getCpf());
        // stmt.execute();
        //			
        // // recupera o cliente criado
        // // sql = "select max(clienteID) as clienteID from Cliente";
        // // stmt = conn.prepareStatement(sql);
        // // rs = stmt.executeQuery();
        // // rs.next();
        // // clienteID = rs.getInt("clienteID");
        //			
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // // return clienteID;
    }
    
    public int salvar(Cliente c)
    {
        String sql = "insert into cliente values (?,?,?,?,?,1)";
        RepositorioConta repositorioConta = new RepositorioContaJDBC();
        ClienteIndividual cliente = (ClienteIndividual) c;
        int clienteID = -1;
        try
        {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            
            // verifica se existe conta para salvar a conta
            if(cliente.getConta() != null)
            {
                int contaID = repositorioConta.salvar(cliente.getConta());
                stmt.setInt(1, contaID);
            }
            else
            {
                stmt.setString(1, null);
            }
            
            // salva a identificação do cliente
            ImpressaoDigital identificacao = (ImpressaoDigital) cliente
                    .getIdentificacao();
            byte[] imageBytes = leitorImagem.converter(identificacao.getInfo());
            stmt.setBytes(2, imageBytes);
            
            // salva a foto do cliente
            if(cliente.getFoto() != null)
            {
                stmt.setBytes(3, leitorImagem.converter(cliente.getFoto()));
            }
            else
            {
                stmt.setBytes(3, null);
            }
            
            stmt.setString(4, cliente.getNome());
            stmt.setString(5, cliente.getCpf());
            stmt.execute();
            
            // recupera o cliente criado
            sql = "select max(clienteID) as clienteID from Cliente";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();
            clienteID = rs.getInt("clienteID");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return clienteID;
    }
    
    public List<Cliente> obterClientes()
    {
        
        List<Cliente> ret = new ArrayList<Cliente>();
        ClienteIndividual cliente = null;
        RepositorioConta repConta = new RepositorioContaJDBC();
        String sql = "select * from Cliente";
        try
        {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                cliente = new ClienteIndividual();
                cliente.setId(rs.getInt("clienteID"));
                cliente.setConta(repConta.obterConta(rs.getInt("contaID")));
                // recupera a identificação
                cliente.setIdentificacao(new ImpressaoDigital(leitorImagem.converter(rs
                        .getBytes("identificacao"))));
                // recupera a foto
                if(rs.getBytes("foto") != null)
                {
                    cliente.setFoto(leitorImagem.converter(rs.getBytes("foto")));
                }
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                ret.add(cliente);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }
    
    public Cliente obterPorId(int id)
    {
        String sql = "select * from Cliente where clienteID = ?";
        ClienteIndividual ret = null;
        RepositorioConta repConta = new RepositorioContaJDBC();
        try
        {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                ret = new ClienteIndividual();
                ret.setId(rs.getInt("clienteID"));
                ret.setConta(repConta.obterConta(rs.getInt("contaID")));
                // recupera a identificação
                ret.setIdentificacao(new ImpressaoDigital(leitorImagem.converter(rs
                        .getBytes("identificacao"))));
                // recupera a foto
                if(rs.getBytes("foto") != null)
                {
                    ret.setFoto(leitorImagem.converter(rs.getBytes("foto")));
                }
                ret.setCpf(rs.getString("cpf"));
                ret.setNome(rs.getString("nome"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }
    
    public ClienteIndividual obterCliente(Identificacao identificacao)
    {
        String sql = "select top 1 * from cliente where cast(identificacao as varbinary(max)) = cast(? as varbinary(max))";
        ClienteIndividual ret = null;
        RepositorioConta repConta = new RepositorioContaJDBC();
        ImpressaoDigital digital = (ImpressaoDigital) identificacao;
        byte[] imageBytes = leitorImagem.converter(digital.getInfo());
        try
        {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setBytes(1, imageBytes);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                ret = new ClienteIndividual();
                ret.setId(rs.getInt("clienteID"));
                ret.setConta(repConta.obterConta(rs.getInt("contaID")));
                // recupera a identificação
                ret.setIdentificacao(new ImpressaoDigital(leitorImagem.converter(rs
                        .getBytes("identificacao"))));
                // recupera a foto
                if(rs.getBytes("foto") != null)
                {
                    ret.setFoto(leitorImagem.converter(rs.getBytes("foto")));
                }
                ret.setCpf(rs.getString("cpf"));
                ret.setNome(rs.getString("nome"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }
    
    public Cliente obterPorNome(String nome)
    {
        String sql = "select * from Cliente where nome like ?";
        ClienteIndividual ret = null;
        RepositorioConta repConta = new RepositorioContaJDBC();
        try
        {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                ret = new ClienteIndividual();
                ret.setId(rs.getInt("clienteID"));
                ret.setConta(repConta.obterConta(rs.getInt("contaID")));
                // recupera a identificação
                ret.setIdentificacao(new ImpressaoDigital(leitorImagem.converter(rs
                        .getBytes("identificacao"))));
                // recupera a foto
                if(rs.getBytes("foto") != null)
                {
                    ret.setFoto(leitorImagem.converter(rs.getBytes("foto")));
                }
                ret.setCpf(rs.getString("cpf"));
                ret.setNome(rs.getString("nome"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }
    
    public void excluir(Cliente cliente)
    {
        String sql = "delete from cliente where clienteID = ?";
        try
        {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ((ClienteIndividual) cliente).getId());
            stmt.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public boolean existeCliente(Identificacao identificacao)
    {
        ImpressaoDigital digital = (ImpressaoDigital) identificacao;
        FingerprintImage fp = CadastroClienteFormManager.generateFingerprint(digital.getInfo());
        FingerprintTemplate fpt = CadastroClienteFormManager.generateTemplate(fp);
        
        for(FingerprintTemplate t : CadastroClienteFormManager.templates)
        {
            MatchingResult result;
            try
            {
                result = CadastroClienteFormManager.grFinger.verify(fpt, t,
                        Context.DEFAULT_CONTEXT);
                if(result.doesMatched())
                {
                    return true;
                }
            }
            catch(GrErrorException e)
            {
                e.printStackTrace();
            }

        }
        
        return false;
    }
}
