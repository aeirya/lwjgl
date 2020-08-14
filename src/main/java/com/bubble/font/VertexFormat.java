package com.bubble.font;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


import com.bubble.opengl.VertexAttribute;

public class VertexFormat
{
	private List<VertexFormatElement> elements;
	private int location;
	private int offset;
	private int stride;

	public VertexFormat(List<VertexFormatElement> list)
	{
		this.elements = list;
	}

	private Stream<Integer> getSizes() {
		return elements.stream().map(VertexFormatElement::getSize);
	}

	List<VertexAttribute> get() {
		final List<VertexAttribute> attributes = new ArrayList<>();
		location = 0;
		offset = 0;
		stride = getSizes().reduce(0, (a,b) -> a + b);
		getSizes().forEach(s -> addElement(s, attributes));
		return attributes;
	}

	private void addElement(int size, List<VertexAttribute> attributes) {
		addAttrib(location, size, stride, offset, attributes);
		location += 1;
		offset += size;
	}

	private void addAttrib(int location, int size, int stride, int offset, List<VertexAttribute> attributes) {
		attributes.add(new VertexAttribute(location, size, stride, offset));
	}
}
