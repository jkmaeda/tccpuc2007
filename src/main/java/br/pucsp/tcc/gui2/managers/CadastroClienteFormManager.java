package br.pucsp.tcc.gui2.managers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.ImageProducer;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.pucsp.tcc.controle.GerenciadorCliente;
import br.pucsp.tcc.controle.impl.GerenciadorClienteImpl;
import br.pucsp.tcc.exception.IdentificacaoInvalidaException;
import br.pucsp.tcc.gui.gerarIdentificacao.impl.JpegPixelGrabber;
import br.pucsp.tcc.gui2.forms.CadastroClienteForm;
import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometrico;
import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometricoListener;
import br.pucsp.tcc.infra.leitorbiometrico.impl.LeitorMicrosoft;
import br.pucsp.tcc.infra.leitorbiometrico.impl.LeitorSimulador;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

import com.griaule.grFinger.Context;
import com.griaule.grFinger.FingerprintImage;
import com.griaule.grFinger.FingerprintTemplate;
import com.griaule.grFinger.GrErrorException;
import com.griaule.grFinger.GrFinger;

public class CadastroClienteFormManager extends Manager implements
        LeitorBiometricoListener, KeyEventDispatcher
{
    private CadastroClienteForm form;
    private PainelImpressaoDigital painelID;
    private GerenciadorCliente gerenciadorCliente;
    
    private LeitorBiometrico leitor;
    public static List<FingerprintTemplate> templates;
    public static List<ClienteIndividual> clientes;
    public static GrFinger grFinger;
    
    private ImpressaoDigital identificacao;
    private FingerprintImage identificacaoFp;
    private FingerprintTemplate identificacaoFpt;
    
    public CadastroClienteFormManager()
    {
    }
    
    // ///////////////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public JPanel create()
    {
        gerenciadorCliente = new GerenciadorClienteImpl();
        form = new CadastroClienteForm();
        painelID = new PainelImpressaoDigital();
        
        // define the preferred size
        Dimension d = form.digital.getPreferredSize();
        form.digital.setLayout(new BorderLayout());
        form.digital.add(painelID, BorderLayout.CENTER);
        form.digital.setPreferredSize(d);
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
        
        // create the reader control variables
        leitor = new LeitorSimulador();
        templates = new LinkedList<FingerprintTemplate>();
        clientes = new LinkedList<ClienteIndividual>();
        
        return form;
    }
    
    @Override
    public String getTitle()
    {
        return "Cadastro de Cliente";
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == form.but_cancel)
        {
            super.cancel();
        }
        else if(e.getSource() == form.but_ok)
        {
            ImpressaoDigital digital = this.identificacao;
            String nome = form.txt_nome.getText();
            try
            {
                ClienteIndividual cliente = gerenciadorCliente
                        .cadastrarClienteIndividual(digital, nome);
                
                clientes.add(cliente);
                templates.add(this.identificacaoFpt);
            }
            catch(IdentificacaoInvalidaException ex1)
            {
                super.showError(ex1);
            }
            catch(Exception ex2)
            {
                super.showError(ex2);
            }
        }
        else if(e.getSource() == form.but_ativar)
        {
            try
            {
                grFinger = new LeitorMicrosoft().createGrFingerInstance();
                leitor.iniciar(this);
                form.but_ativar.setEnabled(false);
            }
            catch(Exception e1)
            {
                super.showError(e1);
            }
        }
        else if(e.getSource() == form.but_descartar)
        {
            this.identificacao = null;
            this.identificacaoFp = null;
            this.identificacaoFpt = null;
            
            painelID.image = null;
            painelID.repaint();
            
            form.but_analisar.setEnabled(false);
            form.but_descartar.setEnabled(false);
        }
        else if(e.getSource() == form.but_analisar)
        {
            ImageProducer imageProducer;
            try
            {
                imageProducer = grFinger.getBiometricDisplay(identificacaoFpt,
                        identificacaoFp, Context.GR_NO_CONTEXT);
                painelID.image = new JPanel().createImage(imageProducer);
                painelID.repaint();
            }
            catch(GrErrorException e1)
            {
                e1.printStackTrace();
            }
            
        }
    }
    
    // ///////////////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public void leituraIdentificacaoIniciada()
    {
        painelID.setBackground(Color.GRAY);
    }
    
    @Override
    public void leituraIdentificacaoFinalizada(Identificacao identificacao)
    {
        this.identificacao = (ImpressaoDigital) identificacao;
        this.identificacaoFp = generateFingerprint(this.identificacao.getInfo());
        this.identificacaoFpt = generateTemplate(identificacaoFp);
        
        painelID.setBackground(Color.WHITE);
        painelID.image = this.identificacao.getInfo();
        painelID.repaint();
        
        form.but_analisar.setEnabled(true);
        form.but_descartar.setEnabled(true);
    }
    
    // ///////////////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////////////
    
    private class PainelImpressaoDigital extends JPanel
    {
        Image image;
        
        public PainelImpressaoDigital()
        {
            super.setBackground(Color.WHITE);
            super.setOpaque(true);
        }
        
        @Override
        public void paint(Graphics g)
        {
            super.paint(g);
            if(image != null)
            {
                int maxDim = Math.min(this.getWidth(), this.getHeight());
                double scale = 0;
                if(image.getWidth(null) > image.getHeight(null))
                {
                    scale = (double) maxDim / image.getWidth(null);
                }
                else
                {
                    scale = (double) maxDim / image.getHeight(null);
                }
                
                if(scale < 1)
                {
                    int scaledW = (int) (scale * image.getWidth(null));
                    int scaledH = (int) (scale * image.getHeight(null));
                    image = image.getScaledInstance(scaledW, scaledH, Image.SCALE_FAST);
                }
                
                g.drawImage(image, 1, 1, image.getWidth(null) - 1,
                        image.getHeight(null) - 1, painelID);
            }
        }
    }
    
    public static FingerprintImage generateFingerprint(Image image)
    {
        JpegPixelGrabber px = new JpegPixelGrabber(image);
        FingerprintImage fp = new FingerprintImage(grFinger, px.getPixels(), px
                .getWidth(), px.getHeight(), 1000);
        return fp;
    }
    
    public static FingerprintTemplate generateTemplate(FingerprintImage fp)
    {
        FingerprintTemplate template = null;
        try
        {
            template = grFinger.extract(fp, Context.DEFAULT_CONTEXT);
        }
        catch(GrErrorException e)
        {
            e.printStackTrace();
        }
        return template;
    }
    
    @Override
    public boolean dispatchKeyEvent(KeyEvent e)
    {
        if(e.getID() == KeyEvent.KEY_RELEASED && e.getKeyCode() >= 112
                && e.getKeyCode() <= 120)
        {
            try
            {
                int keyNum = e.getKeyCode() - 111;
                ((LeitorSimulador) leitor).simular(keyNum);
            }
            catch(NumberFormatException e1)
            {
            }
            
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void main(String[] args)
    {
        Manager m = new CadastroClienteFormManager();
        m.open();
    }
    
    static Log logger = LogFactory.getLog(CadastroClienteFormManager.class);
}
