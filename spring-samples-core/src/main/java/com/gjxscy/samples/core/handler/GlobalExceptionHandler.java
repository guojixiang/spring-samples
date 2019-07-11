package com.gjxscy.samples.core.handler;

import static com.gjxscy.samples.common.enums.ResponseEnum.SYSTEM_ERROR;

import com.gjxscy.samples.core.ResultDTO;
import com.gjxscy.samples.core.exception.WebsocketSysException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


  @ResponseBody
  @ExceptionHandler(Exception.class)
  public ResultDTO handler(HttpServletRequest httpServletRequest, Exception e) {
    ResultDTO resultDTO = new ResultDTO();
    if (e instanceof WebsocketSysException) {
      WebsocketSysException websocketEx = (WebsocketSysException) e;
      resultDTO.setCode(websocketEx.getResponseEnum().getCode());
      resultDTO.setMessage(websocketEx.getResponseEnum().getMessage());
    } else {
      resultDTO.setCode(SYSTEM_ERROR.getCode());
      resultDTO.setMessage(SYSTEM_ERROR.getMessage() + " " + e.getMessage());
    }
    return resultDTO;
  }

}
