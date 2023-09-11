package org.example.mediator;


import org.example.IRequest;
import org.example.IRequestHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


import java.util.Map;
import java.util.Optional;

@Component
public class Mediator implements  IMediator {

    private final ApplicationContext applicationContext;


    public Mediator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    public void processRequest(IRequest request) {
        var beans = this.applicationContext.getBeansOfType(IRequestHandler.class).values();
        Optional<IRequestHandler> requestHandler = beans.stream()
                .filter(handler -> handler.supportsOperation(request.getClass()))
                .findFirst();

        if(requestHandler.isEmpty()) {
            throw new RuntimeException("Operation not supported");
        }

        requestHandler.get().execute(request);

    }




}
