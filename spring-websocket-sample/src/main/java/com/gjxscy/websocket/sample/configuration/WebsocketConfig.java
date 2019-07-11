package com.gjxscy.websocket.sample.configuration;

import com.gjxscy.websocket.sample.interceptor.WebsocketCustomInterceptor;
import com.gjxscy.websocket.sample.message.handler.CustomSocketMessageHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer {

  private final CustomSocketMessageHandler customSocketMessageHandler;
  private final WebsocketCustomInterceptor websocketCustomInterceptor;

  public WebsocketConfig(
      CustomSocketMessageHandler customSocketMessageHandler,
      WebsocketCustomInterceptor websocketCustomInterceptor) {
    this.customSocketMessageHandler = customSocketMessageHandler;
    this.websocketCustomInterceptor = websocketCustomInterceptor;
  }

  public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
    webSocketHandlerRegistry.addHandler(customSocketMessageHandler,"/connect")
        .addInterceptors(websocketCustomInterceptor)
        .setAllowedOrigins("*")
        .withSockJS();
  }
}
