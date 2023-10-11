package org.example.validator;

import org.example.ICommandValidator;
import org.example.IRequest;
import org.example.exceptions.ErrorBuilder;

import java.util.Optional;

public interface IValidator {


    void validate(IRequest command);


    Optional<ICommandValidator> findValidator(IRequest command);


    void runValidation(IRequest command , Optional<ICommandValidator> validator, ErrorBuilder errorBuilder);

    void handleExceptions(ErrorBuilder errorBuilder);

}
