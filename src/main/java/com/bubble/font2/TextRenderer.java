package com.bubble.font2;

import java.util.List;

import com.bubble.font.VertexBuilder;
import com.bubble.font.VertexFormat;
import com.bubble.font.VertexFormatElement;
import com.bubble.opengl.VertexBuffer;
import com.bubble.render.Shader;

import org.lwjgl.opengl.GL13;

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
			IGlyph glyph = this.font.getGlyph(c);
			float advance = glyph.draw(this.vertexBuilder, x, y, scale);
			x += advance;
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
		buffer.destroy();
	}

	public VertexBuilder getVertexBuilder() { return this.vertexBuilder; }
	public void setTextVertexFormat(VertexBuilder builder) { this.vertexBuilder = builder; }
	public Font getFont() { return this.font; }
	public Font setFont(Font font) { Font f = this.font; this.font = font; return f; }
	public Shader getShader() { return this.shader; }
	public void setShader(Shader shader) { this.shader = shader; }
}
