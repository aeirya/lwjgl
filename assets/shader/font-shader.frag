#version 330 core

in vec4 color;
in vec2 uv;

out vec4 fragColor;

uniform sampler2D font;

void main()
{
	float t = texture(font, uv).r;
	vec3 c = color.rgb * t;
	fragColor = vec4(c, color.a * t);
}