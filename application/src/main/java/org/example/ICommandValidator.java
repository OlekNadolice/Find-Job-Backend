package org.example;

import org.example.exceptions.ErrorBuilder;

public interface ICommandValidator<T extends  IRequest> {



    void validate(T command, ErrorBuilder errorBuilder);


    boolean supportsCommand(Object command);
}
