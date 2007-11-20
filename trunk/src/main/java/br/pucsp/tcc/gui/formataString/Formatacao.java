package br.pucsp.tcc.gui.formataString;

public class Formatacao {

	public static String arredondar(String valor) {
		int index = valor.indexOf(".");
		@SuppressWarnings("unused")
		int quantDecimais = valor.length() - index - 1;
		switch (quantDecimais) {
		case 0:
			valor += "00";
			break;
		case 1:
			valor += "0";
			break;

		default:
			if(quantDecimais > 2) {
				valor = valor.substring(0, index+3);
			}
			break;
		}
		return valor;
	}
	
}
