package com.e9ine.android.driver.injection.component;

import com.e9ine.android.driver.injection.module.ApiModule;
import com.e9ine.android.driver.injection.module.ApplicationModule;
import com.e9ine.android.driver.injection.module.PresenterModule;
import com.e9ine.android.driver.injection.module.UtilModule;
import com.e9ine.android.driver.module.AuthenticationModule.view.activity.TaskListActivity;
import com.e9ine.android.driver.module.common.util.Bakery;
import com.e9ine.android.driver.module.common.util.ConnectivityUtil;
import com.e9ine.android.driver.module.common.util.PreferenceUtil;
import com.e9ine.android.driver.module.AuthenticationModule.presenter.TaskListPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Surendar D
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        ApiModule.class,
        PresenterModule.class,
        UtilModule.class,
})
public interface ApplicationComponent {

    // inject methods for view classes
    void inject(TaskListActivity taskListActivity);

    // inject methods for presenter classes
    void inject(TaskListPresenterImpl taskListPresenter);

    // inject methods for util classes
    void inject(PreferenceUtil preferenceUtil);
    void inject(Bakery bakery);
    void inject(ConnectivityUtil connectivityUtil);

}
