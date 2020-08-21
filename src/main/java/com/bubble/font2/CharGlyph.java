package com.bubble.font2;

import java.nio.FloatBuffer;

import com.bubble.font.VertexBuilder;

import org.lwjgl.stb.STBTTAlignedQuad;
import org.lwjgl.stb.STBTTBakedChar;
import org.lwjgl.stb.STBTruetype;
import org.lwjgl.system.MemoryUtil;

public class CharGlyph implements IGlyph
{
	private Font font;
	private STBTTBakedChar.Buffer bakedChars;
	private int charIndex;

	public CharGlyph(Font font, STBTTBakedChar.Buffer chars, int index)
	{
		this.font = font;
		this.bakedChars = chars;
		this.charIndex = index;
	}

	@Override
	public float draw(VertexBuilder builder, float x, float y, float scale)
	{
		FloatBuffer xPos = MemoryUtil.memAllocFloat(1).put(x).flip();
		FloatBuffer yPos = MemoryUtil.memAllocFloat(1).put(y).flip();

		STBTTAlignedQuad q = STBTTAlignedQuad.create();
		STBTruetype.stbtt_GetBakedQuad(this.bakedChars, font.getWidth(), font.getHeight(), this.charIndex, xPos, yPos, q, true);
		float x0 = (q.x0() - x) * scale + x;
		float y0 = -(q.y0() - y) * scale + y;
		float x1 = (q.x1() - x) * scale + x;
		float y1 = -(q.y1() - y) * scale + y;
		
		builder.begin();
		builder.vertex(x0, y1, q.s0(), q.t1());
		builder.vertex(x0, y0, q.s0(), q.t0());
		builder.vertex(x1, y1, q.s1(), q.t1());
		builder.vertex(x1, y0, q.s1(), q.t0());
		builder.triangle(0, 1, 2);
		builder.triangle(2, 1, 3);
		builder.end();

		return (xPos.get() - x) * scale;
	}

	@Override
	public float getWidth(float x, float scale)
	{
		float y = 0;
		
		FloatBuffer xPos = MemoryUtil.memAllocFloat(1).put(x).flip();
		FloatBuffer yPos = MemoryUtil.memAllocFloat(1).put(y).flip();

		STBTTAlignedQuad q = STBTTAlignedQuad.create();
		STBTruetype.stbtt_GetBakedQuad(this.bakedChars, font.getWidth(), font.getHeight(), this.charIndex, xPos, yPos, q, true);

		return (xPos.get() - x) * scale;
	}
}
