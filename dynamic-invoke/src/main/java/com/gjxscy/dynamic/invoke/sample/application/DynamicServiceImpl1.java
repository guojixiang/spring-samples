package com.gjxscy.dynamic.invoke.sample.application;

import org.springframework.stereotype.Service;

@Service
public class DynamicServiceImpl1 implements DynamicService {

  public void test(int a) {
    System.out.println("mysql invoke:a="+a);
  }

  public String getCode() {
    return "mysql";
  }
}
