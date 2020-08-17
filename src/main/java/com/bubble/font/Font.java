package com.bubble.font;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTruetype;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class Font
{
	//private final static CharGlyphInfo SPACE_GLYPH =

	private ByteBuffer dataBuffer;
	private STBTTFontinfo fontInfo;
	private float scale;
	private float ascent;
	private float descent;
	private float lineGap;

	private Map<Character, CharGlyph> charGlyphs = new HashMap<>();
	private Map<Character, CharGlyphInfo> characters = new HashMap<>();
	private FontTexture fontTexture;

	public Font(String path, int width, int height, float size)
	{
		try
		{
			this.fontTexture = new FontTexture(this, width, height);
			this.fontTexture.bind();
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
			GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL30.GL_R8, width, height, 0, GL11.GL_RED, GL11.GL_UNSIGNED_BYTE, MemoryUtil.NULL);
			this.dataBuffer = ioResourceToByteBuffer(path, 4096);
			this.fontInfo = STBTTFontinfo.malloc();
			if (!STBTruetype.stbtt_InitFont(this.fontInfo, this.dataBuffer))
				throw new IOException("stbtt_InitFont failed!");

			this.scale = STBTruetype.stbtt_ScaleForPixelHeight(fontInfo, size);

			try (MemoryStack stack = MemoryStack.stackPush())
			{
				IntBuffer ascent = stack.mallocInt(1);
				IntBuffer descent = stack.mallocInt(1);
				IntBuffer lineGap = stack.mallocInt(1);

				STBTruetype.stbtt_GetFontVMetrics(fontInfo, ascent, descent, lineGap);
				this.ascent = ascent.get(0) * this.scale;
				this.descent = descent.get(0) * this.scale;
				this.lineGap  = lineGap.get(0) * this.lineGap;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	float getScale() {
		return scale;
	}

	public CharGlyph getCharGlyph(char c)
	{
		if (this.charGlyphs.containsKey(c))
			return this.charGlyphs.get(c);

		CharGlyphInfo info = this.getGlyphInfo(c);
		CharGlyph glyph = this.fontTexture.createGlyph(info);

		if (glyph == null) return null;

		this.charGlyphs.put(c, glyph);
		return glyph;
	}

	public CharGlyphInfo getGlyphInfo(char c)
	{
		if (this.characters.containsKey(c))
			return this.characters.get(c);

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			IntBuffer x0 = stack.mallocInt(1);
			IntBuffer y0 = stack.mallocInt(1);
			IntBuffer x1 = stack.mallocInt(1);
			IntBuffer y1 = stack.mallocInt(1);

			int index = STBTruetype.stbtt_FindGlyphIndex(this.fontInfo, c);
			STBTruetype.stbtt_GetGlyphBitmapBox(this.fontInfo, index, this.scale, this.scale, x0, y0, x1, y1);

			IntBuffer advanceWidth = stack.mallocInt(1);
			IntBuffer leftSideBearing = stack.mallocInt(1);
			STBTruetype.stbtt_GetGlyphHMetrics(this.fontInfo, index, advanceWidth, leftSideBearing);

			CharGlyphInfo glyphInfo = new CharGlyphInfo(this, index, x0.get(0), -y0.get(0), x1.get(0), -y1.get(0), advanceWidth.get(0) * this.scale, leftSideBearing.get(0) * this.scale);
			this.characters.put(c, glyphInfo);
			return glyphInfo;
		}
	}

	private static ByteBuffer ioResourceToByteBuffer(String resource, int bufferSize)
			throws IOException
	{
		ByteBuffer buffer;

		File file = new File(resource);
		if (file.isFile())
		{
			try(FileInputStream fis = new FileInputStream(file); FileChannel fc = fis.getChannel();) {
				buffer = MemoryUtil.memAlloc((int) fc.size() + 1);
				//noinspection StatementWithEmptyBody
				while (fc.read(buffer) != -1)
				{}
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
						{
							buffer = MemoryUtil.memRealloc(buffer, size * 2);
						}
					}
				}
			}
			buffer = MemoryUtil.memRealloc(buffer, size + 1);
		}
		buffer.put((byte) 0);
		buffer.flip();
		return buffer;
	}

	public float getAscent()
	{
		return ascent;
	}

	public STBTTFontinfo getFontInfo()
	{
		return fontInfo;
	}

	public FontTexture getTexture()
	{
		return fontTexture;
	}
}
