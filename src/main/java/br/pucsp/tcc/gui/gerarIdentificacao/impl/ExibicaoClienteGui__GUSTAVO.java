package br.pucsp.tcc.gui.gerarIdentificacao.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometrico;
import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometricoListener;
import br.pucsp.tcc.infra.leitorbiometrico.impl.LeitorSimulador;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

@SuppressWarnings("serial")
public class ExibicaoClienteGui__GUSTAVO extends JFrame implements LeitorBiometricoListener
{
	public static void main(String[] args) {
		new ExibicaoClienteGui__GUSTAVO();
	}
	
	private LeitorBiometrico leitor;
	private Identificacao identificacao;
	private JPanel painelTela, painelIdentificacao;
	
	public ExibicaoClienteGui__GUSTAVO() {
		inicializarPainelTela();
		inicializarLeitor();
		inicializarFrame();
	}
	
	private void inicializarPainelTela()
	{
		painelIdentificacao = new JPanel(new BorderLayout()) {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				if (identificacao != null && identificacao instanceof ImpressaoDigital) {
					Image image = ((ImpressaoDigital) identificacao).getInfo();
					g.drawImage(image, 1, 1, image.getWidth(null)-1, image.getHeight(null)-1, null);
				}
			}
		};
		painelIdentificacao.setBackground(Color.WHITE);
		painelIdentificacao.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		painelIdentificacao.setPreferredSize(new Dimension(400, 450));
		
		painelTela = new JPanel(new BorderLayout());
		painelTela.add(painelIdentificacao, BorderLayout.CENTER);
		painelTela.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	}
	
	private void inicializarFrame()
	{
		this.setTitle("Aquisição de Identificação");
		this.setContentPane(painelTela);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        this.addKeyListener(new KeyAdapter() {
            final LeitorSimulador leitor = (LeitorSimulador) ExibicaoClienteGui__GUSTAVO.this.leitor;
            @Override
            public void keyReleased(KeyEvent e)
            {
                String key = String.valueOf(e.getKeyChar());
                try
                {
                    Integer keyNum = Integer.parseInt(key);
                    logger.trace(String.format("Simulador acionado, id '%s'", e.getKeyChar()));
                    leitor.simular(keyNum);
                }
                catch(NumberFormatException e1)
                {
                }
            }
        });
	}
	
	private void inicializarLeitor() {
		//leitor = new LeitorMicrosoft();
		leitor = new LeitorSimulador();
		try {
			leitor.iniciar(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void leituraIdentificacaoFinalizada(Identificacao identificacao)
	{
	    logger.debug("Terminada captura de impressão digital");
		this.identificacao = identificacao;
		painelIdentificacao.setBackground(Color.WHITE);
		painelIdentificacao.repaint();
	}

	public void leituraIdentificacaoIniciada() {
	    logger.debug("Iniciando captura de impressão digital");
		painelIdentificacao.setBackground(Color.LIGHT_GRAY);
	}
	
	 static Log logger = LogFactory.getLog(ExibicaoClienteGui__GUSTAVO.class);
}