package com.bubble.font;

import com.bubble.opengl.Vec2D;
import com.bubble.opengl.Vertex;
import com.bubble.opengl.VertexBufferBuilder;
import com.bubble.std.Color;

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

	public void draw(VertexBufferBuilder builder, float x, float y, float scale, Font font, Color color)
	{
		float minX = x + this.info.getMinX() * scale;
		float minY = y + this.info.getMinY() * scale;
		float maxX = x + this.info.getMaxX() * scale;
		float maxY = y + this.info.getMaxY() * scale;
		builder.begin();
		// builder.vertex(minX, minY, 0.0F, this.textureStartU, this.textureEndU);
		// builder.vertex(minX, maxY, 0.0F, this.textureStartU, this.textureStartV);
		// builder.vertex(maxX, minY, 0.0F, this.textureEndU, this.textureEndV);
		// builder.vertex(maxX, maxY, 0.0F, this.textureEndU, this.textureStartU);
		builder.addVertex(new Vertex(minX, minY, 0.0f));
		builder.addVertex(new Vec2D(this.textureStartU, this.textureEndU));
        builder.addVertex(new Vertex(color.r, color.g, color.b));
		builder.addVertex(new Vertex(maxX, maxY, 0.0f));
		builder.addVertex(new Vec2D(this.textureStartU, this.textureStartV));
        builder.addVertex(new Vertex(color.r, color.g, color.b));
		builder.addVertex(new Vertex(minX, minY, 0.0f));
		builder.addVertex(new Vec2D(this.textureEndU, this.textureEndV));
        builder.addVertex(new Vertex(color.r, color.g, color.b));
		builder.addVertex(new Vertex(maxX, maxY, 0.0f));
		builder.addVertex(new Vec2D(this.textureEndU, this.textureStartU));
        builder.addVertex(new Vertex(color.r, color.g, color.b));
		builder.addTriangle(1, 0, 2);
		builder.addTriangle(1, 2, 3);
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
