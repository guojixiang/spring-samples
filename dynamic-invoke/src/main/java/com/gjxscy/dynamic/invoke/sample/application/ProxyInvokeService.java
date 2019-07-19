package com.gjxscy.dynamic.invoke.sample.application;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class ProxyInvokeService implements ApplicationContextAware {

  @Value("${app.invoke.code:mysql}")
  private String invokeCode;

  private static Map<String, DynamicService> map = new HashMap<>();

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    Map<String, DynamicService> stampMap = applicationContext.getBeansOfType(DynamicService.class);
    stampMap.forEach((key, value) -> {
      map.put(value.getCode(), value);
    });
  }

  public void invoke() {
    DynamicService dynamicService = map.get(invokeCode);
    dynamicService.test(2);
  }


}
