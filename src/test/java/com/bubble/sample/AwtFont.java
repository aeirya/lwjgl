package com.bubble.sample;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import org.lwjgl.system.jawt.JAWT;

import java.awt.RenderingHints;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;

public class AwtFont {
    public static void main(String[] args) {
    //     String fname = "OpenSans-Regular.ttf";
    //     InputStream is = AwtFont.class.getResourceAsStream(fname);
        try {
            String yourText = "java2s.com";
            
            
            ImageIO.write(new AwtFont().write("hello i'm aeirya", 20), "png", new File(
                "image.png"));
        

            System.out.println("Image Created");
        } catch (IOException e) {
        }
        
    }

    public BufferedImage write(String text, int fontSize) {
        return write(text, text.length() * fontSize, fontSize);
    }

    public BufferedImage write(String text, int width, int height) {
            BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = (Graphics2D)bufferedImage.getGraphics();
            // tweaks(graphics);
            // graphics.setColor(Color.LIGHT_GRAY);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
            graphics.drawString(text, 1, height - 1);
            return bufferedImage;
    }

    public void tweaks(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
        RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
            RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING,
            RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
            RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
            RenderingHints.VALUE_STROKE_PURE);
    }
}