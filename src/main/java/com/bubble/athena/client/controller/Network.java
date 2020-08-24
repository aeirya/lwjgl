package com.bubble.athena.client.controller;

public enum Network {
    INSTACE;

    private ServerApi api;

    public static void provideApi(ServerApi api) {
        INSTACE.api = api;
    }

    public static ServerApi getApi() {
        return INSTACE.api;
    }
}