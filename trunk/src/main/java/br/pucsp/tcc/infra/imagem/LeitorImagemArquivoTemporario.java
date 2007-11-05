package br.pucsp.tcc.infra.imagem;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LeitorImagemArquivoTemporario implements ILeitorImagem {
	
	public byte[] converter(Image image)
	{
		logger.trace("Building image byte array");
		
		// read from the temp file
        List<Byte> bytes = null;
        try
        {
            // save the image to a temp file
            File outputFile = LeitorImagemArquivoTemporario.createTemporaryFile();
            logger.trace("Temporary file created");
            
            BufferedImage buff = BufferedImageBuilder.toBufferedImage(image);
            logger.trace("BufferedImage created");
            
            ImageIO.write(buff, "PNG", outputFile);
            logger.trace("Image successfully written to the hard-disk");
            
            bytes = new LinkedList<Byte>();
            FileInputStream fis = new FileInputStream(outputFile);
            byte[] imgBuff = new byte[1];
            while(fis.read(imgBuff) != -1) {
            	bytes.add(imgBuff[0]);
            }
            fis.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
		
		logger.trace("Image successfully read from the hard-disk");
		logger.trace("Total bytes: " + bytes.size());
		
		// remove the temp file
		//outputFile.delete();
		
		// convert to byte array
		byte[] retBytes = new byte[bytes.size()];
		for(int i = 0; i < bytes.size(); i++) {
			retBytes[i] = bytes.get(i);
		}
		return retBytes;
	}
	
	public Image converter(byte[] bytes) {
		ImageIcon icon = new ImageIcon(bytes);
		return icon.getImage();
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
	
	public static void main(String[] args) throws Exception
	{
		Dimension screenSize = new Dimension(200, 200);
		Rectangle screenRect = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage ss = robot.createScreenCapture(screenRect);
		
		ILeitorImagem leitor = new LeitorImagemArquivoTemporario();
		byte[] arrByte = leitor.converter(ss);
		Image image = leitor.converter(arrByte);
		
		JFrame frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon(image)));
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Teste");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	static Log logger = LogFactory.getLog(LeitorImagemArquivoTemporario.class);
}
