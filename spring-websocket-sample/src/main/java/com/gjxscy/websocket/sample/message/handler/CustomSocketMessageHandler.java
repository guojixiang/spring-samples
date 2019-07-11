package com.gjxscy.websocket.sample.message.handler;

import com.gjxscy.websocket.sample.cache.CustomCache;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
public class CustomSocketMessageHandler extends AbstractWebSocketHandler {


  private final CustomCache customCache;

  public CustomSocketMessageHandler(CustomCache customCache) {
    this.customCache = customCache;
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    customCache.setKV("", session);
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    session.close();
    super.afterConnectionClosed(session, status);
  }
}
