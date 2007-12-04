package br.pucsp.tcc.gui.gerarIdentificacao.impl;

import java.awt.Image;
import java.awt.image.PixelGrabber;

public class JpegPixelGrabber
{
    private Image m_image = null; // pointer to original image
    private int[] m_pixels = null; // will contains either array of
    private int m_iWidth, m_iHeight;
    
    JpegPixelGrabber(Image img)
    {
        m_image = img;
        
        // Requesting the images sizes
        // The method is syncronous, then ImageObserver is not necessary
        m_iWidth = m_image.getWidth(null);
        m_iHeight = m_image.getHeight(null);
        
        try
        {
            this.grabPixels();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void grabPixels() throws Exception
    {
        // CONSTRUCT
        m_pixels = new int[m_iWidth * m_iHeight];
        PixelGrabber pixelGrabber = new PixelGrabber(m_image, 0, 0, m_iWidth, m_iHeight,
                m_pixels, 0, m_iWidth);
        
        // GRAB
        try
        {
            pixelGrabber.grabPixels();
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
    // Getting grayScale Pixels
    public byte[] getPixels()
    {
        byte[] b = new byte[m_pixels.length];
        for(int i = 0; i < m_pixels.length; i++)
        {
            int pixel = m_pixels[i];
            int red = (pixel >> 16) & 0xff;
            int green = (pixel >> 8) & 0xff;
            int blue = (pixel) & 0xff;
            b[i] = (byte) ((red + green + blue) / 3);
        }
        return b;
    }
    
    public int getWidth()
    {
        return m_iWidth;
    }
    
    public int getHeight()
    {
        return m_iHeight;
    }
    
    public void destroy()
    {
        m_image = null;
        m_pixels = null;
    }
}
