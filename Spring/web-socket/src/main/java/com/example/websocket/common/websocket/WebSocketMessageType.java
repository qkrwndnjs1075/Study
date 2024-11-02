package com.example.websocket.common.websocket;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WebSocketMessageType {

    ENTER("ENTER"),
    JOIN("JOIN"),
    TALK("TALK"),
    EXIT("EXIT"),
    SUB("SUBSCRIBE"),
    PUB("PUBLISH");

    private final String type;


    public String getValue(){
        return this.type;
    }
}
