package br.pucsp.tcc.infra.imagem;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LeitorImagemMemoria implements LeitorImagem
{
    public Image converter(byte[] imgBytes)
    {
        Image image = null;
        try
        {
            ImageIcon icon = new ImageIcon(imgBytes);
            image = icon.getImage();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return image;
    }
    
    public byte[] converter(Image image)
    {
        ImageIcon imageIcon = new ImageIcon(image);
        BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(),
                imageIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try
        {
            ImageIO.write(bufferedImage, "png", bos);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        byte[] buffer = bos.toByteArray();
        return buffer;
    }
    
    public static void main(String[] args) throws Exception
    {
        Dimension screenSize = new Dimension(200, 200);
        Rectangle screenRect = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage ss = robot.createScreenCapture(screenRect);
        
        LeitorImagem leitor = new LeitorImagemMemoria();
        byte[] arrByte = leitor.converter(ss);
        Image image = leitor.converter(arrByte);
        
        
        JFrame frame = new JFrame();
        frame.setContentPane(new JLabel(new ImageIcon(image)));
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Teste - Conversor Mark");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
