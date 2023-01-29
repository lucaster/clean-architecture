package com.example.cleanarchitecture;

import com.example.monads.Try;

public interface UseCase<
    I extends UseCaseRequest<A>,
    O extends UseCaseResponse<B>,
    A,
    B
> {
    public abstract Try<O> handle(I request);
}
