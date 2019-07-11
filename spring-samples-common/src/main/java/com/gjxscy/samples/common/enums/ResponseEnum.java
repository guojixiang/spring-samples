package com.gjxscy.samples.common.enums;

public enum ResponseEnum {


  SYSTEM_ERROR(500, "System Error.");


  private int code;
  private String message;

  ResponseEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
