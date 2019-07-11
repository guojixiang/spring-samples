package com.gjxscy.websocket.sample.interfaces;

import com.gjxscy.websocket.sample.cache.CustomCache;
import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@RestController
public class WebsocketSampleController {

  private final CustomCache customCache;

  public WebsocketSampleController(CustomCache customCache) {
    this.customCache = customCache;
  }

  @PostMapping("/message")
  public Object sendMessage(@RequestParam String message, @RequestParam String userId) throws IOException {
    TextMessage textMessage = new TextMessage(message.getBytes());
    WebSocketSession webSocketSession = ((WebSocketSession)customCache.getV(userId));
    if(webSocketSession.isOpen()) {
      webSocketSession.sendMessage(textMessage);
    }
    return true;
  }
}
