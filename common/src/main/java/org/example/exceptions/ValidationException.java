package org.example.exceptions;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Accessors(fluent = true)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends  RuntimeException {
      private final  ErrorBuilder errorBuilder;


      public ValidationException(ErrorBuilder errorBuilder) {
            this.errorBuilder = errorBuilder;
      }
}
