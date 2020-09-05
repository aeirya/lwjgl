package com.bubble.font;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.bubble.opengl.VertexAttribute;

public class VertexFormat {
	private List<VertexFormatElement> elements;

	VertexFormat(List<VertexFormatElement> list) {
		this.elements = list;
	}
	
	List<VertexAttribute> toVertAtrib() {
		final int stride = getOffset(elements.size());
		return IntStream.range(0, elements.size())
			.mapToObj(
				i -> new VertexAttribute(i, elements.get(i).getSize(), stride, getOffset(i)))
			.collect(Collectors.toList());
	}

	private int getOffset(int i) {
		return IntStream.rangeClosed(0, i).sum();
	}
}
