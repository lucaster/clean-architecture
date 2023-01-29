package com.example.cleanarchitecture;

import com.example.monads.Try;

public interface UseCase<
    I extends Request<A>,
    O extends Response<B>,
    A,
    B
> {
    public abstract Try<O> handle(I request);
}
