package com.bubble.font2;

import java.nio.FloatBuffer;

import com.bubble.font.VertexBuilder;

import org.lwjgl.stb.STBTTAlignedQuad;
import org.lwjgl.stb.STBTTBakedChar;
import org.lwjgl.stb.STBTruetype;
import org.lwjgl.system.MemoryUtil;

public class EmptyGlyph implements IGlyph
{
	private Font font;
	private STBTTBakedChar.Buffer bakedChars;

	public EmptyGlyph(Font font, STBTTBakedChar.Buffer chars)
	{
		this.font = font;
		this.bakedChars = chars;
	}

	@Override
	public float draw(VertexBuilder builder, float x, float y, float scale)
	{
		FloatBuffer xPos = MemoryUtil.memAllocFloat(1).put(x).flip();
		FloatBuffer yPos = MemoryUtil.memAllocFloat(1).put(y).flip();

		STBTTAlignedQuad q = STBTTAlignedQuad.create();
		STBTruetype.stbtt_GetBakedQuad(this.bakedChars, font.getWidth(), font.getHeight(), (int)' ', xPos, yPos, q, true);
		return (xPos.get() - x) * scale;
	}

	@Override
	public float getWidth(float x, float scale) {
		return 0;
	}
}
