package com.bubble.font;

import com.ahraman.unbounded.client.renderer.texture.Texture2D;

import org.lwjgl.opengl.GL11;

import java.nio.ByteBuffer;

public class FontTexture extends Texture2D
{
	private Font font;
	private Entry topEntry;

	public FontTexture(Font font, int width, int height)
	{
		super(width, height);
		this.font = font;
		this.topEntry = new Entry(0, 0, width, height);
	}

	public void uploadSub(ByteBuffer data, int level, int offsetX, int offsetY, int width, int height, int format, int type)
	{
		GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, level, offsetX, offsetY, width, height, format, type, data);
	}

	public CharGlyph createGlyph(CharGlyphInfo info)
	{
		Entry entry = this.topEntry.populate(info);
		if (entry != null)
		{
			this.bind();
			final float w = this.width;
			final float h = this.height;
			final float epsilon = 0.01F;

			return new CharGlyph(this.font, info, (entry.offsetX + epsilon) / w, (entry.offsetY + epsilon) / h, (entry.offsetX + entry.width - epsilon) / w, (entry.offsetY + entry.height - epsilon) / h);
		}

		return null;
	}

	private static class Entry
	{
		private final int offsetX;
		private final int offsetY;
		private final int width;
		private final int height;
		private Entry left;
		private Entry right;
		private boolean isLeaf;

		private Entry(int offsetX, int offsetY, int width, int height)
		{
			this.offsetX = offsetX;
			this.offsetY = offsetY;
			this.width = width;
			this.height = height;
		}

		Entry populate(CharGlyphInfo glyph)
		{
			if (this.left != null && this.right != null)
			{
				Entry entry = this.left.populate(glyph);
				if (entry == null)
					entry = this.right.populate(glyph);

				return entry;
			}
			else if (this.isLeaf)
				return null;
			else
			{
				int i = glyph.getWidth();
				int j = glyph.getHeight();
				if (i <= this.width && j <= this.height)
				{
					if (i == this.width && j == this.height)
					{
						this.isLeaf = true;
						return this;
					}
					else
					{
						int k = this.width - i;
						int l = this.height - j;
						if (k > l)
						{
							this.left = new Entry(this.offsetX, this.offsetY, i, this.height);
							this.right = new Entry(this.offsetX + i + 1, this.offsetY, this.width - i - 1, this.height);
						}
						else
						{
							this.left = new Entry(this.offsetX, this.offsetY, this.width, j);
							this.right = new Entry(this.offsetX, this.offsetY + j + 1, this.width, this.height - j - 1);
						}

						return this.left.populate(glyph);
					}
				}
				else return null;
			}
		}
	}
}