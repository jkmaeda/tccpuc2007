package br.pucsp.tcc.aplicacao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ArquivoDeConfiguracao {

	public static String path = "src//main//resources//factory.properties";
	
	private static Properties properties;
	
	public static Properties getProperties() {
		if(properties == null) {
			properties = new Properties();
			try {
				properties.load(new FileInputStream(path));
			} catch (FileNotFoundException e) {
				System.out.println("Arquivo de configuração não encontrado");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Erro ao ler arquivo de configuração");
				e.printStackTrace();
			}
		}
		return properties;
	}
	
	public static void save() {
		try {
			properties.store(new FileOutputStream(path), "Arquivo utilizados pelas factorys da aplicação");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
