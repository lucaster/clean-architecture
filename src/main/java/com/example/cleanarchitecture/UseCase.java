package com.example.cleanarchitecture;

import com.example.monads.Try;

public interface UseCase<
    I extends UseCaseRequest<?>,
    O extends UseCaseResponse<?>
> {
    public abstract Try<O> handle(I request);
}
