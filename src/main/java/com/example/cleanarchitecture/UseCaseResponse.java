package com.example.cleanarchitecture;

import java.util.Objects;

/**
 * @param P can be {@link java.lang.Void}
 */
public abstract class UseCaseResponse<P> {

    private final P payload;

    protected UseCaseResponse(P payload) {
        Objects.requireNonNull(payload);
        this.payload = payload;
    }

    public final P get() {
        return payload;
    }
}
