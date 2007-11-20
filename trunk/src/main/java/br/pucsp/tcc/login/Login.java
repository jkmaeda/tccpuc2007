package br.pucsp.tcc.login;

import java.util.HashMap;

import br.pucsp.tcc.aplicacao.IAplicacao;

public class Login {

	HashMap<String, String> map = null;
	
	public Login() {
		map = new HashMap<String, String>();
		map.put("mark", "mark1234");
		map.put("ivan", "ivan1234");
		map.put("jacques", "jacques1234");
		map.put("gustavo", "gustavo1234");
	}
	
	public String get(String key) {
		return map.get(key);
	}
	
	public static void main(String[] args) {
		Login login = new Login();
		String senhaEsperada = login.get("mark");
		String senha = "mark1234";
		System.out.println(senha.equals(senhaEsperada));
	}
	
}
