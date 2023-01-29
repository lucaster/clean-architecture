package com.example.cleanarchitecture;

import java.util.Objects;

/**
 * @param P can be {@link java.lang.Void}
 */
public abstract class UseCaseRequest<P> {

    private final P payload;

    protected UseCaseRequest(P payload) {
        Objects.requireNonNull(payload);
        this.payload = payload;
    }

    public final P get() {
        return payload;
    }
}
