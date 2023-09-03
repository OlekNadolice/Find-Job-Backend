package org.example;

public interface IRequestHandler<T> {


    boolean supportsOperation(Object operation);

    Object execute(T command);
}
