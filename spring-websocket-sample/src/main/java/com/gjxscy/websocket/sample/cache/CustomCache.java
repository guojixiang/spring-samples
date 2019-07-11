package com.gjxscy.websocket.sample.cache;

import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class CustomCache {

  private ConcurrentHashMap websocketSessionCache = new ConcurrentHashMap();

  public void setKV(String key, Object value) {
    websocketSessionCache.put(key, value);
  }

  public Object getV(String key) {
    return websocketSessionCache.get(key);
  }

}
