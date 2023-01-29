package com.example.cleanarchitecture;

import com.example.cleanarchitecture.exceptions.BusinessValidationException;
import com.example.cleanarchitecture.exceptions.RequestValidationException;
import com.example.monads.Try;

public abstract class UseCaseTemplate<I extends UseCaseRequest<A>, O extends UseCaseResponse<B>, A, B>
        implements UseCase<I, O, A, B> {

    @Override
    public Try<O> handle(I request) {
        return Try
                .ofFailable(() -> {
                    validateRequest(request);
                    return null;
                })
                .map(x -> {
                    validateBusiness(request);
                    return null;
                })
                .map(x -> extracted(request));
    }

    private O extracted(I request) {
        return work(request);
    }

    protected abstract void validateRequest(I request) throws RequestValidationException;

    protected abstract void validateBusiness(I request) throws BusinessValidationException;

    protected abstract O work(I request);
}
