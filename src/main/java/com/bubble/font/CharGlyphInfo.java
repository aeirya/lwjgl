package com.bubble.font;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.stb.STBTruetype;

import java.nio.ByteBuffer;

public class CharGlyphInfo
{
	private Font font;
	private int width;
	private int height;
	private float bearingX;
	private float bearingY;
	private float advanceWidth;
	private int glyphIndex;

	public CharGlyphInfo(Font font, int index, int x0, int y0, int x1, int y1, float advanceWidth, float leftSideBearing)
	{
		this.font = font;
		this.glyphIndex = index;
		this.width = x1 - x0;
		this.height = y0 - y1;
		this.advanceWidth = advanceWidth;
		this.bearingX = leftSideBearing + x0;
		this.bearingY = font.getAscent() - y0;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public float getBearingX()
	{
		return bearingX;
	}

	public float getBearingY()
	{
		return bearingY;
	}

	public float getAdvanceWidth()
	{
		return advanceWidth;
	}

	public int getGlyphIndex()
	{
		return glyphIndex;
	}

	public float getMinX() { return this.bearingX; }
	public float getMinY() { return this.bearingY; }
	public float getMaxX() { return this.getMinX() + this.width; }
	public float getMaxY() { return this.getMinY() + this.height; }

	public void upload(int offsetX, int offsetY)
	{
		ByteBuffer buffer = BufferUtils.createByteBuffer(this.width * this.height);
		STBTruetype.stbtt_MakeGlyphBitmap(this.font.getFontInfo(), buffer, this.width, this.height, this.width, this.font.getScale(), this.font.getScale(), this.glyphIndex);
		this.font.getTexture().uploadSub(buffer, 0, offsetX, offsetY, this.width, this.height, GL11.GL_FLOAT, GL11.GL_UNSIGNED_BYTE);
	}
}
