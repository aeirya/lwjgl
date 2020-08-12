package com.bubble.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import com.bubble.opengl.Texture2D;

import org.lwjgl.BufferUtils;

public class ImageLoader {
    private static final int BYTES_PER_PIXEL = 4;

    public Texture2D loadTexure2D(String path) {
        final BufferedImage image = loadImage(path);
        if (image != null) {
            return new Texture2D(image.getWidth(), image.getHeight(), convertImage(image));
        } else return null;
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch(IOException e) {
            return null;
        }
    }

    private ByteBuffer convertImage(BufferedImage image)
    {     
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
        
        ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * BYTES_PER_PIXEL);
                
        for(int y = image.getHeight() - 1; y >= 0 ; y--)
        {
            for(int x = 0; x < image.getWidth(); x++)
            {
                int pixel = pixels[y * image.getWidth() + x];
                buffer.put((byte) ((pixel >> 16) & 0xFF));     // Red component
                buffer.put((byte) ((pixel >> 8) & 0xFF));      // Green component
                buffer.put((byte) (pixel & 0xFF));               // Blue component
                buffer.put((byte) ((pixel >> 24) & 0xFF));    // Alpha component. Only for RGBA
            }
        }
        buffer.flip();
        
        return buffer;
    }
}