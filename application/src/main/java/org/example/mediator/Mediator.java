package org.example.mediator;


import org.example.IRequest;
import org.example.IRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
public class Mediator {

    private final ApplicationContext applicationContext;

    @Autowired
    public Mediator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    public void processRequest(IRequest request) {
        Map<String, IRequestHandler> beans = this.applicationContext.getBeansOfType(IRequestHandler.class);
        beans.values().stream()
                .filter(handler -> handler.supportsOperation(request.getClass()))
                .findFirst()
                .ifPresentOrElse(
                        handler -> handler.execute(request),
                        () -> {
                            throw new RuntimeException("Invalid operation.");
                        });
    }


}
