package br.pucsp.tcc.gui.mdi;

import javax.swing.JPanel;

import br.pucsp.tcc.aplicacao.ComandaDigital;

public interface Mdi {

	public abstract void dispose();

	public abstract void setVisible(boolean visivel);

	public abstract void setContentPane(JPanel contentPane);

	public abstract void setTitle(String title);

	public abstract void setComandaDigital(ComandaDigital comandaDigital);

}
