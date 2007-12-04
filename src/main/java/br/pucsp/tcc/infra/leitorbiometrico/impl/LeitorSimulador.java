package br.pucsp.tcc.infra.leitorbiometrico.impl;

import java.net.URL;

import javax.swing.ImageIcon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometrico;
import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometricoListener;
import br.pucsp.tcc.mock.biometria.ImpressaoDigitalMock;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

public class LeitorSimulador implements LeitorBiometrico
{
    private LeitorBiometricoListener listener;
    
    @Override
    public void finalizar() throws Exception
    {
        logger.info("Finalizando leitor biométrico de simulação");
        this.listener = null;
    }
    
    @Override
    public void iniciar(LeitorBiometricoListener listener) throws Exception
    {
        logger.info("Iniciando leitor biométrico de simulação");
        this.listener = listener;
    }
    
    // metodos de simulacao
    
    public void simular(int numero)
    {
        this.listener.leituraIdentificacaoIniciada();
        Identificacao identificacao = this.gerarIdentificacao(numero);
        this.listener.leituraIdentificacaoFinalizada(identificacao);
    }
    
    private ImpressaoDigital gerarIdentificacao(int numero)
    {
        ClassLoader cl = ImpressaoDigitalMock.class.getClassLoader();
        URL res = cl.getResource(String.format("ProcessedSample%d.png", numero));
        if(res != null)
        {
            ImageIcon icon = new ImageIcon(res);
            ImpressaoDigital digital = new ImpressaoDigital(icon.getImage());
            return digital;
        }
        else
        {
            return null;
        }
    }
    
    static Log logger = LogFactory.getLog(LeitorSimulador.class);
}
