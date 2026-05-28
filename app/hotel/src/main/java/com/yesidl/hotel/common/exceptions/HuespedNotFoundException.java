package com.yesidl.hotel.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HuespedNotFoundException extends RuntimeException {
  public HuespedNotFoundException(String message) {
    super(message);
  }
}
