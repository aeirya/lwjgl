package com.bubble.font;

import com.bubble.opengl.VertexBuffer;
import com.bubble.render.Shader;

import org.lwjgl.opengl.GL13;

import java.util.List;

public class TextRenderer
{
	public static final VertexFormat TEXT_VERTEX_FORMAT = new VertexFormat(List.of(VertexFormatElement.POSITION_2D, VertexFormatElement.COLOR, VertexFormatElement.UV));

	private Font font;
	private Shader shader;
	private VertexBuilder vertexBuilder = new VertexBuilder(TEXT_VERTEX_FORMAT);

	public TextRenderer(Shader shader)
	{
		this.shader = shader;
	}

	public void drawText(String text, float x, float y, float scale, float r, float g, float b, float a, boolean immediate)
	{
		this.vertexBuilder.color(r, g, b, a);
		for (int i = 0; i < text.length(); ++i)
		{
			char c = text.charAt(i);
			CharGlyph glyph = this.font.getCharGlyph(c);
			glyph.draw(this.vertexBuilder, x, y, scale, font);
			x += glyph.getInfo().getAdvanceWidth() * scale;
		}

		if (immediate)
			this.flushAndRelease();
	}

	public VertexBuffer flush()
	{
		return this.vertexBuilder.flush();
	}

	public void flushAndRelease()
	{
		VertexBuffer buffer = this.flush();

		this.shader.bind();
		this.shader.setInt("font", 0);
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		this.font.getTexture().bind();
		buffer.draw();
		this.font.getTexture().unbind();
		buffer.unbind();
	}

	public float calculateTextLength(String text, float scale)
	{
		float len = 0.0F;
		for (int i = 0; i < text.length(); ++i)
			len += this.font.getGlyphInfo(text.charAt(i)).getAdvanceWidth();

		return len * scale;
	}

	public int fitMaxString(String text, float scale, float width)
	{
		float adjustedWidth = width / scale;
		float len = 0.0F;
		int i = 0;
		for (; i < text.length() && len <= adjustedWidth; ++i)
			len += this.font.getGlyphInfo(text.charAt(i)).getAdvanceWidth();

		return i;
	}

	public VertexBuilder getVertexBuilder() { return this.vertexBuilder; }
	public void setTextVertexFormat(VertexBuilder builder) { this.vertexBuilder = builder; }
	public Font getFont() { return this.font; }
	public Font setFont(Font font) { Font f = this.font; this.font = font; return f; }
	public Shader getShader() { return this.shader; }
	public void setShader(Shader shader) { this.shader = shader; }
}
