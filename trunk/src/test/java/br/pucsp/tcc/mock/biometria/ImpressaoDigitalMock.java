package br.pucsp.tcc.mock.biometria;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

import br.pucsp.tcc.modelo.ImpressaoDigital;

public class ImpressaoDigitalMock extends ImpressaoDigital
{
	public ImpressaoDigitalMock(int numero) {
		super(getImage(numero));
	}
	
	private static Image getImage(int numero)
	{
		ClassLoader cl = ImpressaoDigitalMock.class.getClassLoader();
		URL res = cl.getResource(String.format("ProcessedSample%d.png", numero));
		
		ImageIcon icon = new ImageIcon(res);		
		return icon.getImage();
	}
	
	public static final ImpressaoDigital digital1 = new ImpressaoDigitalMock(1);
	public static final ImpressaoDigital digital2 = new ImpressaoDigitalMock(2);
	public static final ImpressaoDigital digital3 = new ImpressaoDigitalMock(3);
	public static final ImpressaoDigital digital4 = new ImpressaoDigitalMock(4);
	public static final ImpressaoDigital digital5 = new ImpressaoDigitalMock(5);
	public static final ImpressaoDigital digital6 = new ImpressaoDigitalMock(6);
	public static final ImpressaoDigital digital7 = new ImpressaoDigitalMock(7);
	public static final ImpressaoDigital digital8 = new ImpressaoDigitalMock(8);
	public static final ImpressaoDigital digital9 = new ImpressaoDigitalMock(9);
}
