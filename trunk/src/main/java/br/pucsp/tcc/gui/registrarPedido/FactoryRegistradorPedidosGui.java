package br.pucsp.tcc.gui.registrarPedido;

import java.util.Properties;

import br.pucsp.tcc.aplicacao.ArquivoDeConfiguracao;
import br.pucsp.tcc.gui.registrarPedido.impl.RegistrarPedidosGui;

public class FactoryRegistradorPedidosGui {
	
	public RegistrarPedidosGui fabricarRegistrador(RegistrarPedidos registradorPedidos) {
		Properties properties = ArquivoDeConfiguracao.getProperties();
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
