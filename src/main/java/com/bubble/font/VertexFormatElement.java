package com.bubble.font;

import static com.bubble.font.VertexElementType.FLOAT;

public class VertexFormatElement {
	public static final VertexFormatElement POSITION_3D = new VertexFormatElement(3, FLOAT);
	public static final VertexFormatElement POSITION_2D = new VertexFormatElement(2, FLOAT);
	public static final VertexFormatElement COLOR = new VertexFormatElement(4, FLOAT);
	public static final VertexFormatElement UV = new VertexFormatElement(2, FLOAT);

	private final int size;
	private final VertexElementType type;

	public VertexFormatElement(int size, VertexElementType type) {
		this.size = size;
		this.type = type;
	}

	public int getSize() { 
		return this.size; 
	}
	
	public VertexElementType getType() { 
		return this.type; 
	}
}
