package com.gjxscy.samples.core.exception;

import com.gjxscy.samples.common.enums.ResponseEnum;

public class WebsocketSysException extends RuntimeException {

  private ResponseEnum responseEnum;

  public WebsocketSysException(ResponseEnum responseEnum) {
    super();
    this.responseEnum = responseEnum;
  }

  public ResponseEnum getResponseEnum() {
    return responseEnum;
  }

  public void setResponseEnum(ResponseEnum responseEnum) {
    this.responseEnum = responseEnum;
  }
}
