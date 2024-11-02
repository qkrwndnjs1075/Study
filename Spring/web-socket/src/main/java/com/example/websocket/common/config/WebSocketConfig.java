package com.example.websocket.common.config;

import com.example.websocket.chat.handler.WebSocketChatHandler;
import com.example.websocket.common.interceptor.WebSocketAuthInterceptor;
import com.example.websocket.common.websocket.WebSocketMessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    private final WebSocketChatHandler webSocketChatHandler;
    private final WebSocketAuthInterceptor webSocketAuthInterceptor;

    /**
     * 웹소켓 연결을 위한 설정
     * 웹소켓 연결 EndPoint: ws://localhost:8080/chats
     * 에 연결시 동작할 핸들러는 webSocketChatHandler
     * @param registry
     */

    @Override
    public void registerWebSocketHandler(WebSocketHandlerRegistry registry){
        registry.addHandler(webSocketChatHandler, "/chats")
                .addInterceptors(webSocketAuthInterceptor)
                .setAllowedOrigins("*");
    }
}
