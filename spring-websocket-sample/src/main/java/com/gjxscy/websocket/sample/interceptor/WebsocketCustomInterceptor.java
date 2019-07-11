package com.gjxscy.websocket.sample.interceptor;

import java.util.Map;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Component
public class WebsocketCustomInterceptor extends HttpSessionHandshakeInterceptor {

  @Override
  public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
      Map<String, Object> attributes) throws Exception {
    if (request instanceof ServletServerHttpRequest) {
      String userId = ((ServletServerHttpRequest) request).getServletRequest().getParameter("userId");
      attributes.put("userId", userId);
    }
    return super.beforeHandshake(request, response, wsHandler, attributes);
  }
}
