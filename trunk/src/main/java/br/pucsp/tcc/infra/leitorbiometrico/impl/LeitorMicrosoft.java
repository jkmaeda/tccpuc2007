package br.pucsp.tcc.infra.leitorbiometrico.impl;

import java.awt.Image;
import java.awt.image.ImageProducer;

import javax.swing.JPanel;

import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometrico;
import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometricoListener;
import br.pucsp.tcc.modelo.ImpressaoDigital;

import com.griaule.grFinger.FingerCallBack;
import com.griaule.grFinger.FingerprintImage;
import com.griaule.grFinger.GrErrorException;
import com.griaule.grFinger.GrFinger;
import com.griaule.grFinger.GrFingerAppletInstaller;
import com.griaule.grFinger.ImageCallBack;
import com.griaule.grFinger.StatusCallBack;

public class LeitorMicrosoft implements LeitorBiometrico, StatusCallBack, FingerCallBack, ImageCallBack
{
	private GrFinger grFinger;
	private GrFingerAppletInstaller installer;
	
	private LeitorBiometricoListener listener;
	
	private static boolean iniciado = false;
	
	public LeitorMicrosoft() {
	}

	@Override
	public void finalizar() throws Exception {

	}

	@Override
	public void iniciar(LeitorBiometricoListener listener) throws Exception {
		if(!iniciado) {
			installer = new GrFingerAppletInstaller("", "GrFingerDLLs.zip");
			installer.copyLicense("GrFingerAppletLicenseAgreement.txt");
			grFinger = installer.getGrFinger();
			grFinger.initializeCapture(this);
			iniciado = true;
		}
		this.listener = listener;
	}

	@Override
	public void onPlug(String idSensor) {
		try {
			grFinger.startCapture(idSensor, this, this);
		} catch (GrErrorException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUnplug(String idSensor) {
		try {
			grFinger.stopCapture(idSensor);
		} catch (GrErrorException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFingerDown(String arg0) {
		this.listener.leituraIdentificacaoIniciada();
	}

	@Override
	public void onFingerUp(String arg0) {
	}

	@Override
	public void onImage(String arg0, FingerprintImage fp)
	{
		ImageProducer producer = null;
		try {
			producer = fp.newImageProducer();
		} catch (GrErrorException e) {
			e.printStackTrace();
		}
		Image image = new JPanel().createImage(producer);
		
		ImpressaoDigital digital = new ImpressaoDigital(image);
		this.listener.leituraIdentificacaoFinalizada(digital);
	}
}
