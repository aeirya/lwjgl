#version 330 core

in vec4 color;
in vec2 uv;

out vec4 fragColor;

uniform sampler2D fontTexture;

void main()
{
	float t = texture(fontTexture, uv).r;
	vec3 c = color.rgb * t;
	fragColor = vec4(c, color.a);
}