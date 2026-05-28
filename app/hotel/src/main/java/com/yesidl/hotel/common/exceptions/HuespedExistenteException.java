package com.yesidl.hotel.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class HuespedExistenteException extends RuntimeException {
  public HuespedExistenteException(String message) {
    super(message);
  }
}
