package com.bubble.font;

@SuppressWarnings("all")
public class CharGlyph
{
	public Font font;
	public CharGlyphInfo info;
	public float textureStartU;
	public float textureStartV;
	public float textureEndU;
	public float textureEndV;

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
		builder.vertex(minX, minY, this.textureStartU, this.textureEndU);
		builder.vertex(minX, maxY, this.textureStartU, this.textureStartV);
		builder.vertex(maxX, minY, this.textureEndU, this.textureEndV);
		builder.vertex(maxX, maxY, this.textureEndU, this.textureStartU);
		// builder.addVertex(new Vertex(minX, minY, 0.0f));
		// builder.addVertex(new Vec2D(this.textureStartU, this.textureEndU));
        // builder.addVertex(new Vertex(color.r, color.g, color.b));
		// builder.addVertex(new Vertex(maxX, maxY, 0.0f));
		// builder.addVertex(new Vec2D(this.textureStartU, this.textureStartV));
        // builder.addVertex(new Vertex(color.r, color.g, color.b));
		// builder.addVertex(new Vertex(minX, minY, 0.0f));
		// builder.addVertex(new Vec2D(this.textureEndU, this.textureEndV));
        // builder.addVertex(new Vertex(color.r, color.g, color.b));
		// builder.addVertex(new Vertex(maxX, maxY, 0.0f));
		// builder.addVertex(new Vec2D(this.textureEndU, this.textureStartU));
        // builder.addVertex(new Vertex(color.r, color.g, color.b));
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
