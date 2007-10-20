package br.pucsp.tcc.infra.imagem;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class LeitorImagem {

	public static byte[] getBytes(Image image) throws IOException
	{
		logger.trace("Building image byte array");
		
		// save the image to a temp file
		File outputFile = LeitorImagem.createTemporaryFile();
		BufferedImage buff = new BufferedImageBuilder().bufferImage(image);
		ImageIO.write(buff, "PNG", outputFile);
		
		logger.trace("Image successfully written to the hard-disk");
		
		// read from the temp file
		List<Byte> bytes = new LinkedList<Byte>();
		FileInputStream fis = new FileInputStream(outputFile);
		byte[] imgBuff = new byte[1];
		while(fis.read(imgBuff) != -1) {
			bytes.add(imgBuff[0]);
		}
		fis.close();
		
		logger.trace("Image successfully read from the hard-disk");
		
		// remove the temp file
		outputFile.delete();
		
		// convert to byte array
		byte[] retBytes = new byte[bytes.size()];
		for(int i = 0; i < bytes.size(); i++) {
			retBytes[i] = bytes.get(i);
		}
		return retBytes;
	}

	private static File createTemporaryFile() throws IOException {
		String tempDir = System.getProperty("java.io.tmpdir");
		tempDir = "C:\\";
		logger.trace("System temp-dir is: " + tempDir);
		File file = null;
		do {
			int random = (int) (Math.random() * 100000);
			String tempFileName = tempDir + "tmp" + random + ".png";
			logger.trace("Trying to create the temp-file: " + tempFileName);
			file = new File(tempFileName);
		} while(file.exists());
		file.createNewFile();
		return file;
	}
	
	public static void main(String[] args) throws Exception {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		Rectangle screenRect = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRect);
		getBytes(image);
	}
	
	static Log logger = LogFactory.getLog(LeitorImagem.class);
}
