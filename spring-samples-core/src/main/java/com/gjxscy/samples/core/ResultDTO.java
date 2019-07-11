package com.gjxscy.samples.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResultDTO {

  private int code = 200;

  private String message = "success";

  private Object data;

  public ResultDTO(){}

  public ResultDTO(Object data) {
    this.data = data;
  }

  public ResultDTO(int code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }


  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
