package com.e9ine.android.driver.module.base;

/**
 * @author Surendar D
 */
public interface Presenter<T extends ViewInteractor> {

    void attachViewInteractor(T viewInteractor);

    void detachViewInteractor();

}
