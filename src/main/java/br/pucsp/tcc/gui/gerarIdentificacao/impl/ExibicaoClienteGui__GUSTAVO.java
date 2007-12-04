package br.pucsp.tcc.gui.gerarIdentificacao.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageProducer;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometrico;
import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometricoListener;
import br.pucsp.tcc.infra.leitorbiometrico.impl.LeitorMicrosoft;
import br.pucsp.tcc.infra.leitorbiometrico.impl.LeitorSimulador;
import br.pucsp.tcc.mock.biometria.ImpressaoDigitalMock;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

import com.griaule.grFinger.Context;
import com.griaule.grFinger.FingerprintImage;
import com.griaule.grFinger.FingerprintTemplate;
import com.griaule.grFinger.GrErrorException;
import com.griaule.grFinger.GrFinger;
import com.griaule.grFinger.MatchingResult;

@SuppressWarnings("serial")
public class ExibicaoClienteGui__GUSTAVO extends JFrame implements
        LeitorBiometricoListener
{
    public static void main(String[] args)
    {
        new ExibicaoClienteGui__GUSTAVO();
    }
    
    private LeitorBiometrico leitor;
    private JPanel painelTela, painelIdentificacao;
    
    private List<FingerprintTemplate> templates;
    private GrFinger grFinger;
    
    private Identificacao identificacao;
    private FingerprintImage identificacaoFp;
    private FingerprintTemplate identificacaoFpt;
    
    public ExibicaoClienteGui__GUSTAVO()
    {
        inicializarServicos();
        inicializarPainelTela();
        inicializarLeitor();
        inicializarFrame();
        cadastrarDigitais();
    }
    
    private void inicializarServicos()
    {
        templates = new LinkedList<FingerprintTemplate>();
        LeitorMicrosoft leitorMicrosoft = new LeitorMicrosoft();
        try
        {
            grFinger = leitorMicrosoft.createGrFingerInstance();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    private void inicializarPainelTela()
    {
        painelIdentificacao = new JPanel(new BorderLayout()) {
            @Override
            public void paint(Graphics g)
            {
                super.paint(g);
                if(identificacao != null && identificacao instanceof ImpressaoDigital)
                {
                    ImageProducer imageProducer;
                    try
                    {
                        imageProducer = grFinger.getBiometricDisplay(identificacaoFpt,
                                identificacaoFp, Context.GR_NO_CONTEXT);
                        Image image = new JPanel().createImage(imageProducer);
                        g.drawImage(image, 1, 1, image.getWidth(null) - 1, image
                                .getHeight(null) - 1, null);
                    }
                    catch(GrErrorException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        painelIdentificacao.setBackground(Color.WHITE);
        painelIdentificacao.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        painelIdentificacao.setPreferredSize(new Dimension(400, 450));
        
        painelTela = new JPanel(new BorderLayout());
        painelTela.add(painelIdentificacao, BorderLayout.CENTER);
        painelTela.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
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
                    logger.trace(String.format("Simulador acionado, id '%s'", e
                            .getKeyChar()));
                    leitor.simular(keyNum);
                }
                catch(NumberFormatException e1)
                {
                }
            }
        });
    }
    
    private void inicializarLeitor()
    {
        // leitor = new LeitorMicrosoft();
        leitor = new LeitorSimulador();
        try
        {
            leitor.iniciar(this);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void leituraIdentificacaoFinalizada(Identificacao identificacao)
    {
        logger.debug("Terminada captura de impressão digital");
        
        this.identificacao = identificacao;
        this.identificacaoFp = this
                .generateFingerprint(((ImpressaoDigital) identificacao).getInfo());
        this.identificacaoFpt = this.generateTemplate(identificacaoFp);
        
        painelIdentificacao.setBackground(Color.WHITE);
        painelIdentificacao.repaint();
        
        if(identificacao != null)
        {
            try
            {
                identificar();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void leituraIdentificacaoIniciada()
    {
        logger.debug("Iniciando captura de impressão digital");
        painelIdentificacao.setBackground(Color.LIGHT_GRAY);
    }
    
    private void identificar() throws Exception
    {
        for(FingerprintTemplate t : templates)
        {
            MatchingResult result = grFinger.verify(identificacaoFpt, t,
                    Context.DEFAULT_CONTEXT);
            if(result.doesMatched())
            {
                logger.debug("Impressão digital encontrada, pontuacao: "
                        + result.getScore());
            }
            else
            {
                logger.debug("Impressão digital *não* encontrada, pontuacao: "
                        + result.getScore());
            }
        }
    }
    
    private void cadastrarDigitais()
    {
        ImpressaoDigital[] digitais = new ImpressaoDigital[] {
                ImpressaoDigitalMock.digital1, ImpressaoDigitalMock.digital2,
                ImpressaoDigitalMock.digital3 };
        
        for(ImpressaoDigital id : digitais)
        {
            FingerprintImage fp = this.generateFingerprint(id.getInfo());
            FingerprintTemplate fpt = this.generateTemplate(fp);
            templates.add(fpt);
        }
    }
    
    private FingerprintImage generateFingerprint(Image image)
    {
        JpegPixelGrabber px = new JpegPixelGrabber(image);
        FingerprintImage fp = new FingerprintImage(grFinger, px.getPixels(), px
                .getWidth(), px.getHeight(), 1000);
        return fp;
    }
    
    private FingerprintTemplate generateTemplate(FingerprintImage fp)
    {
        FingerprintTemplate t = null;
        try
        {
            t = grFinger.extract(fp, Context.DEFAULT_CONTEXT);
        }
        catch(GrErrorException e)
        {
            e.printStackTrace();
        }
        return t;
    }
    
    static Log logger = LogFactory.getLog(ExibicaoClienteGui__GUSTAVO.class);
}
