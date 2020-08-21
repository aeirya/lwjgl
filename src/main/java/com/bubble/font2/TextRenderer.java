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
	public static final VertexFormat TEXT_VERTEX_FORMAT = new VertexFormat(List.of(VertexFormatElement.POSITION_2D, VertexFormatElement.UV, VertexFormatElement.COLOR));

	private Font font;
	private Shader shader;
	private VertexBuilder vertexBuilder = new VertexBuilder(TEXT_VERTEX_FORMAT);

	public TextRenderer(Shader shader)
	{
		this.shader = shader;
	}

	public void drawText(String text, float x, float y, float scale, float r, float g, float b, float a, boolean immediate)
	{
		drawText(text, x, y, scale, r, g, b, a, 2 - x + 0.5f, immediate);
	}

	public void drawText(String text, float x, float y, float scale, float r, float g, float b, float a, float maxWidth, boolean immediate)
	{
		float startX = x;
		float length = 0f;

		this.vertexBuilder.color(r, g, b, a);
		for (int i = 0; i < text.length(); ++i)
		{
			char c = text.charAt(i);
			IGlyph glyph = this.font.getGlyph(c);
			float advance = glyph.draw(this.vertexBuilder, x, y, scale);
			x += advance;

			if (i+1 < text.length()) {
				char nextChar = text.charAt(i+1);
				if (length >= maxWidth) {
					glyph = this.font.getGlyph(nextChar);
					length += glyph.getWidth(x, scale);
				}
			}
		}

		if (immediate)
			this.flushAndRelease();
	}

	public void drawMultilineText(String text, float x, float y, float scale, float r, float g, float b, float a,
		float maxWidth, boolean immediate, boolean seperateWords)
	{
		float startX = x;
		float length = 0f;

		this.vertexBuilder.color(r, g, b, a);
		for (int i = 0; i < text.length(); ++i)
		{
			char c = text.charAt(i);
			IGlyph glyph = this.font.getGlyph(c);

			if (c == '\n') {
				length = 0f;
				x = startX;
				y -= 0.09f;
			} else {
				float advance = glyph.draw(this.vertexBuilder, x, y, scale);
				x += advance;
			}

			if (i+1 < text.length()) {
				char nextChar = text.charAt(i+1);
				glyph = this.font.getGlyph(nextChar);
				length += glyph.getWidth(x, scale);

				if (length > maxWidth) {
					length = 0f;
					x = startX;
					y -= 0.09f;
				}
			}

			if (!seperateWords && (c == '\t' || c == ' ')) {
				float wordLength = 0f;
				for (int j = i; j < text.length(); ++j) {
					char nextChar = text.charAt(j);
					glyph = this.font.getGlyph(nextChar);

					if (nextChar == '\t' || nextChar == ' ') {
						if (length + wordLength > maxWidth) {
							length = 0f;
							x = startX;
							y -= 0.09f;
						}
						break;
					}

					wordLength += glyph.getWidth(x, scale);
				}
			}
		}

		if (immediate)
			this.flushAndRelease();
	}

	// public void drawFullText(String text, float x, float y, float scale, float r, float g, float b, float a,
	// 	float maxWidth, boolean immediate, boolean seperateWords) {
		
	// 	int i = 0;
	// 	while (i < text.length()) {
	// 		int len = 0;
	// 		while (len < maxWidth) {
	// 			char nextChar = text.charAt(i);
	// 			IGlyph glyph = this.font.getGlyph(nextChar);
	// 			len += glyph.getWidth(x, scale);
	// 		}
	// 		text.substring(beginIndex, endIndex)
	// 		text.substring(i)
			
	// 	}
	// }

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
		buffer.bind();
		buffer.draw();

		this.font.getTexture().unbind();
		buffer.destroy();
	}

	public void clear() {
		vertexBuilder.clear();
	}

	public VertexBuilder getVertexBuilder() { return this.vertexBuilder; }
	public void setTextVertexFormat(VertexBuilder builder) { this.vertexBuilder = builder; }
	public Font getFont() { return this.font; }
	public Font setFont(Font font) { Font f = this.font; this.font = font; return f; }
	public Shader getShader() { return this.shader; }
	public void setShader(Shader shader) { this.shader = shader; }
}
