package com.bubble.font2;

import com.bubble.font.VertexBuilder;

public interface IGlyph
{
	float draw(VertexBuilder builder, float x, float y, float scale);
}
