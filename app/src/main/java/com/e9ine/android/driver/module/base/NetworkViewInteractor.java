package com.e9ine.android.driver.module.base;

/**
 * @author Surendar D
 */
public interface NetworkViewInteractor extends ViewInteractor {

    void onNetworkCallProgress();

    void onNetworkCallCompleted();

    void onNetworkCallError(Throwable e);

}
