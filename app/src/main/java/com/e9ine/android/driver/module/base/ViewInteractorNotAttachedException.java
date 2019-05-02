package com.e9ine.android.driver.module.base;

public class ViewInteractorNotAttachedException extends RuntimeException {

    public ViewInteractorNotAttachedException() {
        super("Please call Presenter.attachViewViewInteractor(viewInteractor) before" +
                " requesting data to the Presenter");
    }

}