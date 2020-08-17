#version 330 core

in vec2 TexCoord;

uniform sampler2D texture1;

out vec4 FragColor;

void main() {
    float f = texture(texture1, TexCoord).r;
    FragColor = vec4(f, f, f, 1.0);
}