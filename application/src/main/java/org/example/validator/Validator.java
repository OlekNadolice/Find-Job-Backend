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



    private  final ApplicationContext applicationContext;

    public Validator(ApplicationContext applicationContext) {

        this.applicationContext = applicationContext;
    }

    public void validate(IRequest command) {
        ErrorBuilder errorBuilder = new ErrorBuilder();
       var validator = findValidator(command);
       if(validator.isPresent()) {
           runValidation(command, validator, errorBuilder);
           handleExceptions(errorBuilder);
       }


    }

    public Optional<ICommandValidator> findValidator(IRequest command) {
        var validatorBeans = this.applicationContext.getBeansOfType(ICommandValidator.class).values();
       return validatorBeans.stream()
                .filter(v -> v.supportsCommand(command.getClass().getSimpleName())).findFirst();

    };

    public void runValidation(IRequest command , Optional<ICommandValidator> validator, ErrorBuilder errorBuilder) {
            validator.get().validate(command, errorBuilder);
    }


    public void handleExceptions(ErrorBuilder errorBuilder) {
        if(errorBuilder.containsErrors()) {
           throw new ValidationException(errorBuilder);

        }
    }





}
