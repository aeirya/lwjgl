package com.bubble.font2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;

import com.bubble.opengl.FontTexture;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.stb.STBTTBakedChar;
import org.lwjgl.stb.STBTruetype;
import org.lwjgl.system.MemoryUtil;

public class Font
{
	private FontTexture texture;
	private int width;
	private int height;

	private int lineGap;
	private float size;

	private Map<Character, IGlyph> charGlyphs = new HashMap<>();

	public Font(String path, int width, int height, float size)
	{
		this.width = width;
		this.height = height;

		this.size = size;

		try
		{
			ByteBuffer data = ioResourceToByteBuffer(path, 4096);
			ByteBuffer textureData = MemoryUtil.memAlloc(width * height);

			float[] lineGapf = new float[1];
			STBTruetype.stbtt_GetScaledFontVMetrics(data, 0, 1024, new float[1],new float[1], lineGapf);
			this.lineGap = (int)lineGapf[0];

			STBTTBakedChar.Buffer chars = STBTTBakedChar.malloc(128);
			STBTruetype.stbtt_BakeFontBitmap(data, size, textureData, width, height, 0, chars);
			this.texture = new FontTexture(width, height);
			this.texture.upload(textureData, GL_RED, GL_UNSIGNED_BYTE);

			for (int i = 0; i < 128; ++i)
			{
				IGlyph glyph;
				char c = (char)i;
				if (c == ' ')
					glyph = new EmptyGlyph(this, chars);
				else
					glyph = new CharGlyph(this, chars, i);

				charGlyphs.put(c, glyph);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public IGlyph getGlyph(char c) {
		return this.charGlyphs.get(c);
	}

	private static ByteBuffer ioResourceToByteBuffer(String resource, int bufferSize)
			throws IOException
	{
		ByteBuffer buffer;

		File file = new File(resource);
		if (file.isFile())
		{
			try (FileInputStream fis = new FileInputStream(file))
			{
				FileChannel fc = fis.getChannel();
				buffer = MemoryUtil.memAlloc((int) fc.size() + 1);
				
				//noinspection StatementWithEmptyBody
				while (fc.read(buffer) != -1);
				
				fc.close();
			}
		}
		else
		{
			int size = 0;
			buffer = MemoryUtil.memAlloc(bufferSize);
			try (InputStream source = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource))
			{
				if (source == null)
					throw new FileNotFoundException(resource);
				try (ReadableByteChannel rbc = Channels.newChannel(source))
				{
					while (true)
					{
						int bytes = rbc.read(buffer);
						if (bytes == -1)
							break;
						size += bytes;
						if (!buffer.hasRemaining())
							buffer = MemoryUtil.memRealloc(buffer, size * 2);
					}
				}
			}
			buffer = MemoryUtil.memRealloc(buffer, size + 1);
		}
		buffer.put((byte) 0);
		buffer.flip();
		return buffer;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public FontTexture getTexture() {
		return this.texture;
	}

	public int getLineGap() {
		return lineGap;
	}

	public float getSize() {
		return size;
	}

	public static final Font GRAND_HOTEL_REGULAR = new Font("assets/fonts/GrandHotel-Regular.otf", 1024, 1024, 64);
}
