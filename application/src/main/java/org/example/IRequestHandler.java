package org.example;

public interface IRequestHandler<T> {


    boolean supportsOperation(Object operation);

    void execute(T command);
}
