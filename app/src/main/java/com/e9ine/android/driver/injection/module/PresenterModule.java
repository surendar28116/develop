package com.e9ine.android.driver.injection.module;

import com.e9ine.android.driver.module.AuthenticationModule.presenter.TaskListPresenter;
import com.e9ine.android.driver.module.AuthenticationModule.presenter.TaskListPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Provides all presenter class dependencies.
 *
 * @author Surendar D
 */
@Module
public class PresenterModule {

    @Provides
    public TaskListPresenter provideSamplePresenter() {
        return new TaskListPresenterImpl();
    }

}
