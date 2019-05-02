package com.e9ine.android.driver.module.base;

/**
 * Provides presenter viewInteractor related operations, all presenters should extend this class.
 *
 * @author Surendar D
 */
public abstract class BasePresenter<T extends ViewInteractor> implements Presenter<T> {

    private T viewInteractor;

    @Override
    public void attachViewInteractor(T viewInteractor) {
        this.viewInteractor = viewInteractor;
    }

    @Override
    public void detachViewInteractor() {
        viewInteractor = null;
    }

    public T getViewInteractor() {
        confirmViewInteractorAttached();

        return viewInteractor;
    }

    private void confirmViewInteractorAttached() {
        if (!isViewInteractorAttached()) {
            throw new ViewInteractorNotAttachedException();
        }
    }

    private boolean isViewInteractorAttached() {
        return viewInteractor != null;
    }

}
