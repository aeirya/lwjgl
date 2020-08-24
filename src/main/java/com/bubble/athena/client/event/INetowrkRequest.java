package com.bubble.athena.client.event;

import com.bubble.athena.client.controller.ServerApi;

@FunctionalInterface
public interface INetowrkRequest {
    void apply(ServerApi api);
}