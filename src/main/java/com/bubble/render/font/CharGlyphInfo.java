package com.ahraman.unbounded.client.renderer.font;

import com.ahraman.unbounded.client.renderer.vertex.VertexBuilder;
import org.lwjgl.BufferUtils;
import org.lwjgl.stb.STBTTAlignedQuad;
import org.lwjgl.stb.STBTTBakedChar;
import org.lwjgl.stb.STBTruetype;

import java.nio.FloatBuffer;

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

	/*public float draw(VertexBuilder builder, float x, float y, float scale, Font font)
	{
		/*x += this.bearingX * scale;
		y -= (this.bearingY - this.height) * scale;
		builder.begin();
		builder.vertex(x, y, 0.0F, this.textureStartU, this.textureEndU);
		builder.vertex(x, y + this.height * scale, 0.0F, this.textureStartU, this.textureStartV);
		builder.vertex(x + this.width * scale, y, 0.0F, this.textureEndU, this.textureEndV);
		builder.vertex(x + this.width * scale, y + this.height * scale, 0.0F, this.textureEndU, this.textureStartU);
		builder.triangle(1, 0, 2);
		builder.triangle(1, 2, 3);
		builder.end();         ***

		FloatBuffer px = BufferUtils.createFloatBuffer(1).put(x).flip();
		FloatBuffer py = BufferUtils.createFloatBuffer(1).put(y).flip();

		STBTTAlignedQuad quad = STBTTAlignedQuad.create();
		STBTruetype.stbtt_GetBakedQuad(font.getBakedChars(), font.getWidth(), font.getHeight(), (int)this.character, px, py, quad, 1);
		builder.begin();
		builder.vertex(quad.x0(), quad.y0(), 0.0F, this.textureStartU, this.textureEndU);
		builder.vertex(quad.x0(), quad.y0() + (quad.y1() - quad.y0()) * scale, 0.0F, this.textureStartU, this.textureStartV);
		builder.vertex(x + this.width * scale, y, 0.0F, this.textureEndU, this.textureEndV);
		builder.vertex(quad.x0() + (quad.x1() - quad.x0()) * scale, quad.y0() + (quad.y1() - quad.y0()) * scale, 0.0F, this.textureEndU, this.textureStartU);
		builder.triangle(1, 0, 2);
		builder.triangle(1, 2, 3);
		builder.end();

		return (px.flip().get() - x) * scale;
	}*/
}
