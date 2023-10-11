package org.example.mediator;


import org.example.IRequest;
import org.example.IRequestHandler;
import org.example.validator.Validator;
import org.springframework.context.ApplicationContext;

import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class Mediator implements  IMediator {

    private final ApplicationContext applicationContext;

    private  final Validator validator;


    public Mediator(ApplicationContext applicationContext, Validator validator) {
        this.applicationContext = applicationContext;
        this.validator = validator;
    }

    public void processRequest(IRequest request) {
        this.validator.validate(request);
        var beans = this.applicationContext.getBeansOfType(IRequestHandler.class).values();
        Optional<IRequestHandler> requestHandler = beans.stream()
                .filter(handler -> handler.supportsOperation(request.getClass().getSimpleName()))
                .findFirst();

        if(requestHandler.isEmpty()) {
            throw new RuntimeException("Operation not supported");
        }

        requestHandler.get().execute(request);

    }




}
