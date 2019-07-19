package com.gjxscy.dynamic.invoke.sample.interfaces;

import com.gjxscy.dynamic.invoke.sample.application.DynamicService;
import com.gjxscy.dynamic.invoke.sample.application.ProxyInvokeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicController {

  private final ProxyInvokeService proxyInvokeService;

  public DynamicController(ProxyInvokeService proxyInvokeService) {
    this.proxyInvokeService = proxyInvokeService;
  }

  @GetMapping("/invoke")
  public void test() {
    proxyInvokeService.invoke();
  }
}
