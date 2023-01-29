package com.example.cleanarchitecture;

import com.example.cleanarchitecture.exceptions.BusinessValidationException;
import com.example.cleanarchitecture.exceptions.RequestValidationException;
import com.example.monads.Try;

public abstract class UseCaseTemplate<I extends UseCaseRequest<?>, O extends UseCaseResponse<?>>
        implements UseCase<I, O> {

    @Override
    public final Try<O> handle(I request) {
        return Try
                .ofFailable(() -> validateRequest(request))
                .map(x -> validateBusiness(request))
                .map(x -> work(request));
    }

    protected abstract Void validateRequest(I request) throws RequestValidationException;

    protected abstract Void validateBusiness(I request) throws BusinessValidationException;

    protected abstract O work(I request);
}
