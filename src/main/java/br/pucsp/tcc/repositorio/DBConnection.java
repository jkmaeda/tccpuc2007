package br.pucsp.tcc.repositorio;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/** 
  * @Class   DBconnection 
  * @Version 1.0 
  * @Author  Ivan 
  * 
  * Implementação do pattern Singleton para conexão a banco de dados 
  *  
  **/  
public class DBConnection {
	
	private static Connection instance; 
	private String driver;  
    private String url;  
    private String login;  
    private String password;
	
	private DBConnection()throws Exception {  
		try{  			    
			this.getProperties();  			
			Class.forName(driver);  
			instance = DriverManager.getConnection(url,login,password);  	           
		}catch(ClassNotFoundException e){  
		    e.printStackTrace();
			throw new Exception("Error : Driver não encontrado.");  	                         
		}catch(SQLException e){  
		    e.printStackTrace();
			throw new Exception("Error : Não foi possível conectar ao banco de dados.");		
		}catch(Exception e){  
		    e.printStackTrace();
			throw new Exception(e.getMessage());  
		}  
	               
	}  
	   	
    public static Connection getConnection() throws Exception {           
       if(instance == null){             
          new DBConnection();  
       }   
       return instance;
    }  
	      	     
    public static void shutdown() throws ClassNotFoundException, SQLException {     
       if (instance != null){              
          instance.close();  
          instance = null;              
       }  
    }  
	   
    private void getProperties() throws Exception {                   
       InputStream file = getClass().getClassLoader().getResourceAsStream("database.properties");  
       Properties properties = new Properties();          
       try{                        
          properties.load(file);  
          file.close();                        
          driver = properties.getProperty("sqlserverdb.driver");  
          url = properties.getProperty("sqlserverdb.url");  
          login = properties.getProperty("sqlserverdb.login");  
          password = properties.getProperty("sqlserverdb.password");             
       }catch(IOException e){  
          throw new Exception(e.getMessage());  
       }                  
    }	
}
