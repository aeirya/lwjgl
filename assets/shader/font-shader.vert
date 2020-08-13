#version 330 core

layout (location = 0) in vec2 i_pos;
layout (location = 1) in vec2 i_uv;
layout (location = 2) in vec4 i_color;

out vec2 uv;
out vec4 color;

void main()
{
	gl_Position = vec4(i_pos, 0.0, 1.0);
	uv = i_uv;
	color = i_color;
}