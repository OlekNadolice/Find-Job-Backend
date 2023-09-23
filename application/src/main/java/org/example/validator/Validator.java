package org.example.validator;


import org.example.ICommandValidator;
import org.example.IRequest;
import org.example.exceptions.ErrorBuilder;
import org.example.exceptions.ValidationException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Validator implements  IValidator{

    private final ErrorBuilder errorBuilder;

    private  final ApplicationContext applicationContext;

    public Validator(ErrorBuilder errorBuilder, ApplicationContext applicationContext) {
        this.errorBuilder = errorBuilder;
        this.applicationContext = applicationContext;
    }

    public void validate(IRequest command) {
       var validator = findValidator(command);
       if(validator.isPresent()) {
           runValidation(command, validator, errorBuilder);
           handleExceptions();
       }


    }

    public Optional<ICommandValidator> findValidator(IRequest command) {
        var validatorBeans = this.applicationContext.getBeansOfType(ICommandValidator.class).values();
       return validatorBeans.stream()
                .filter(v -> v.supportsCommand(command.getClass())).findFirst();

    };

    public void runValidation(IRequest command , Optional<ICommandValidator> validator, ErrorBuilder errorBuilder) {
            validator.get().validate(command, errorBuilder);
    }


    public void handleExceptions() {
        if(errorBuilder.containsErrors()) {
           throw new ValidationException(errorBuilder);

        }
    }





}
