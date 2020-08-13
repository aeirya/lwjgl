package com.ahraman.unbounded.client.renderer.font;

import com.ahraman.unbounded.client.renderer.vertex.VertexBuilder;

public class CharGlyph
{
	private Font font;
	private CharGlyphInfo info;
	private float textureStartU;
	private float textureStartV;
	private float textureEndU;
	private float textureEndV;

	public CharGlyph(Font font, CharGlyphInfo info, float u0, float v0, float u1, float v1)
	{
		this.font = font;
		this.info = info;
		this.textureStartU = u0;
		this.textureStartV = v0;
		this.textureEndU = u1;
		this.textureEndV = v1;
	}

	public void draw(VertexBuilder builder, float x, float y, float scale, Font font)
	{
		float minX = x + this.info.getMinX() * scale;
		float minY = y + this.info.getMinY() * scale;
		float maxX = x + this.info.getMaxX() * scale;
		float maxY = y + this.info.getMaxY() * scale;
		builder.begin();
		builder.vertex(minX, minY, 0.0F, this.textureStartU, this.textureEndU);
		builder.vertex(minX, maxY, 0.0F, this.textureStartU, this.textureStartV);
		builder.vertex(maxX, minY, 0.0F, this.textureEndU, this.textureEndV);
		builder.vertex(maxX, maxY, 0.0F, this.textureEndU, this.textureStartU);
		builder.triangle(1, 0, 2);
		builder.triangle(1, 2, 3);
		builder.end();
	}

	public CharGlyphInfo getInfo()
	{
		return info;
	}

	public Font getFont()
	{
		return font;
	}
}
