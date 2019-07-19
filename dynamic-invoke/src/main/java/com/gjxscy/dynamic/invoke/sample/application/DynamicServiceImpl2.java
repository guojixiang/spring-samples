package com.gjxscy.dynamic.invoke.sample.application;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DynamicServiceImpl2 implements DynamicService {

  public void test(int a) {
    System.out.println("mongo invoke:a="+a);
  }

  public String getCode() {
    return "mongo";
  }
}
