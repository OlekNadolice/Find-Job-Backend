package org.example.exceptions;

import lombok.Getter;

@Getter
public class ValidationException extends  RuntimeException {
      private final  Object errorBuilder;


      public ValidationException(Object errorBuilder) {
            this.errorBuilder = errorBuilder;
      }
}
