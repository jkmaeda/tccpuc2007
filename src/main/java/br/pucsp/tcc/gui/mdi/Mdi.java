package br.pucsp.tcc.gui.mdi;

import java.util.Stack;

import javax.swing.JPanel;

import br.pucsp.tcc.aplicacao.ComandaDigital;

public interface Mdi {
	
	public static final String COLOR = "COLOR";
	
	public static final String WINDOWS = "WINDOWS";

	public abstract void dispose();

	public abstract void setVisible(boolean visivel);

	public abstract void setContentPane(JPanel contentPane);

	public abstract void setTitle(String title);

	public abstract void setComandaDigital(ComandaDigital comandaDigital);
	
	public abstract void trocar(Mdi mdi);

	public abstract void setPilha(Stack<JPanel> pilha);

	public abstract String getEstilo();

}
