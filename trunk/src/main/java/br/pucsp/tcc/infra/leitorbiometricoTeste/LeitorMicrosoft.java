package br.pucsp.tcc.infra.leitorbiometricoTeste;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.griaule.grfingerjava.FingerprintImage;

import br.pucsp.tcc.infra.leitorbiometrico.ImplementacaoVaziaLeitorBiometricoListener;
import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometricoListener;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

public class LeitorMicrosoft implements LeitorBiometricoListener, UtilUi{
	   //object used to perform all the Fingerprint SDK-related operations
	   private Util fingerprintSDKSample;
	   private LeitorBiometricoListener leitorBiometricoListener = null;

	public static void main(String[] args) {

//		LeitorMicrosoft leitorMicrosoft = new LeitorMicrosoft();

	       //Sets the directory from which native libraries / license file 
	       //will be loaded
	       new LeitorMicrosoft();
	}
	
	public LeitorMicrosoft() {
		String grFingerNativeDirectory = new File(".").getAbsolutePath();
		
		grFingerNativeDirectory = "C:\\Arquivos de programas\\Griaule\\Fingerprint SDK Java 2007\\bin";
		Util.setFingerprintSDKNativeDirectory(grFingerNativeDirectory);
    
		this.fingerprintSDKSample = new Util(this, this);
		leitorBiometricoListener = new ImplementacaoVaziaLeitorBiometricoListener();
		fingerprintSDKSample.setAutoExtract(true);
		fingerprintSDKSample.setAutoIdentify(true);
//		getJFrame().setVisible(true);
	}

	public void leituraIdentificacaoFinalizada(Identificacao identificacao) {
		ImpressaoDigital digital = (ImpressaoDigital)identificacao;
		System.out.println("HAHAHA "+digital.getTemplateId());
		leitorBiometricoListener.leituraIdentificacaoFinalizada(identificacao);
		this.leitorBiometricoListener = new ImplementacaoVaziaLeitorBiometricoListener();
	}

	public void leituraIdentificacaoIniciada() {
		
	}

	public void enableImage() {
		// TODO Auto-generated method stub
//	       saveMenuItem.setEnabled (true);
//
//	       extractButton.setEnabled(true);
//	       enrollButton.setEnabled  (false);
//	       verifyButton.setEnabled  (false);
//	       identifyButton.setEnabled(false);
		
	}

	public void enableTemplate() {
		// TODO Auto-generated method stub
//	       enrollButton.setEnabled(true);
//	       verifyButton.setEnabled(true);
//	       identifyButton.setEnabled(true);
		
	}

	public void showImage(BufferedImage biometricImage) {
		// TODO Auto-generated method stub
	       //uses the imageProducer to create the fingerprint image
//	       fingerprintImage = image;
	       //Repaint, so that the new image is shown.
//	       repaint();    
		
	}

	public void writeLog(String string) {
		System.out.println(string);
	}
	
	public void destroy() {
		fingerprintSDKSample.destroy();
	}

	public void iniciar(LeitorBiometricoListener listener) {
		leitorBiometricoListener = listener;
	}

	/////////////////////////////////////////////////////
	//                                                 //
	// TELA - TELA - TELA - TELA - TELA - TELA - TELA  //
	//                                                 //
	/////////////////////////////////////////////////////

	private JFrame jFrame = null;
	private JPanel contentPane = null;
	private JButton buttonEnroll = null;
	private JButton buttonIdentify = null;

	private JButton getButtonIdentify() {
		if(buttonIdentify == null) {
			buttonIdentify = new JButton();
			buttonIdentify.setText("Identify");
			buttonIdentify.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					fingerprintSDKSample.identify();
				}
				
			});
		}
		return buttonIdentify;
	}

	private JButton getButtonEnroll() {
		if(buttonEnroll == null) {
			buttonEnroll = new JButton();
			buttonEnroll.setText("Enroll");
			buttonEnroll.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					fingerprintSDKSample.enroll();
				}
				
			});
		}
		return buttonEnroll;
	}

	private JPanel getContentPane() {
		if(contentPane == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(1);
			contentPane = new JPanel(gridLayout);
			contentPane.add(getButtonEnroll());
			contentPane.add(getButtonIdentify());
		}
		return contentPane;
	}

	private JFrame getJFrame() {
		if(jFrame == null) {
			jFrame = new JFrame();
			jFrame.setBounds(100, 100, 200, 300);
			jFrame.setContentPane(getContentPane());
			jFrame.addWindowListener(new java.awt.event.WindowAdapter() {
		           public void windowClosing(java.awt.event.WindowEvent e) {
		               destroy();
		               System.exit(0);
		           }
			});
		}
		return jFrame;
	}
	
	/////////////////////////////////////////////////////
	//                                                 //
	// TELA - TELA - TELA - TELA - TELA - TELA - TELA  //
	//                                                 //
	/////////////////////////////////////////////////////
	
	
}
