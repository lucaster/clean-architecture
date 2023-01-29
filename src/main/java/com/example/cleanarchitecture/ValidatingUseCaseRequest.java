package com.example.cleanarchitecture;

import com.example.cleanarchitecture.exceptions.RequestValidationException;

public abstract class ValidatingUseCaseRequest<P> extends UseCaseRequest<P> {

    protected ValidatingUseCaseRequest(P payload) {
        super(payload);
    }

    public abstract void validate() throws RequestValidationException;
}
