package com.e9ine.android.driver.data.api;

import rx.Observer;

/**
 * Wrapper for rx.Observer with default implementation for onCompleted & onError.
 *
 * @author Surendar D
 */
public abstract class ApiObserver<T> implements Observer<T> {

    /**
     * Publish result to observer.
     *
     * @param response
     */
    public abstract void onResponse(T response);

    @Override
    public void onCompleted() {
        // Default implementation, can be override accordingly.
    }

    @Override
    public void onNext(T result) {
        onResponse(result);
    }

}
