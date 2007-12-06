package br.pucsp.tcc.infra.leitorbiometricoTeste;

import java.awt.image.BufferedImage;

import com.griaule.grfingerjava.FingerprintImage;

public interface UtilUi {

	void writeLog(String string);

	void showImage(BufferedImage fingerprint);

	void enableImage();

	void enableTemplate();

}
