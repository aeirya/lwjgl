package com.bubble.font;

public class VertexFormatElement
{
	public static final VertexFormatElement POSITION_3D = new VertexFormatElement(3, EnumVertexElementType.FLOAT);
	public static final VertexFormatElement POSITION_2D = new VertexFormatElement(2, EnumVertexElementType.FLOAT);
	public static final VertexFormatElement COLOR = new VertexFormatElement(4, EnumVertexElementType.FLOAT);
	public static final VertexFormatElement UV = new VertexFormatElement(2, EnumVertexElementType.FLOAT);

	private final int size;
	private final EnumVertexElementType type;

	public VertexFormatElement(int size, EnumVertexElementType type)
	{
		this.size = size;
		this.type = type;
	}

	public int getSize() { return this.size; }
	public EnumVertexElementType getType() { return this.type; }
}
