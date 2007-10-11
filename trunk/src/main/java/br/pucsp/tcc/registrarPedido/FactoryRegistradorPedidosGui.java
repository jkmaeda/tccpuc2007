package br.pucsp.tcc.registrarPedido;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import br.pucsp.tcc.registrarPedidoGui.RegistrarPedidosGui;

public class FactoryRegistradorPedidosGui {
	
	public RegistrarPedidosGui fabricarRegistrador(RegistrarPedidos registradorPedidos) {
		Properties properties = new Properties();
	    try {
			properties.load(new FileInputStream("src//main//resources//factoryRegistradorPedidos.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de configuração não encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo de configuração");
			e.printStackTrace();
		}
	    String fullyQualifiedName = properties.getProperty("registradorPedidosGui");
	    RegistrarPedidosGui registradorPedidosGui = null;
	    try {
	    	registradorPedidosGui = (RegistrarPedidosGui)Class.forName(fullyQualifiedName).newInstance();
	    	registradorPedidosGui.setRegistradorPedidos(registradorPedidos);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    return registradorPedidosGui;
	}
	
}
