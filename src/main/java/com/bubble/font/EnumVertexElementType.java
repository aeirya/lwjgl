package com.bubble.font;

import org.lwjgl.opengl.GL11;

public enum EnumVertexElementType
{
	FLOAT(4, GL11.GL_FLOAT);

	private final int size;
	private final int constant;

	EnumVertexElementType(int size, int constant)
	{
		this.size = size;
		this.constant = constant;
	}

	public int getSize() { return this.size; }
	public int getConstant() { return this.constant; }
}
