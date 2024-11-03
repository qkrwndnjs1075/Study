package com.example.websocket.common.websocket;

import com.example.websocket.chat.dto.ChatDto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class WebSocketMessage {

    private final WebSocketMessageType type;
    private final ChatDto payload;

    @JsonCreator
    public WebSocketMessage(
            @JsonProperty("type") WebSocketMessageType type,
            @JsonProperty("payload") ChatDto payload){
        this.type = type;
        this.payload = payload;
    }
}
