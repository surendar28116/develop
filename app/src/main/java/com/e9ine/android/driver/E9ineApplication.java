package com.e9ine.android.driver;

import android.app.Application;

import com.e9ine.android.driver.injection.Injector;
import com.e9ine.android.driver.injection.module.ApplicationModule;

import timber.log.Timber;

/**
 * @author Surendar D
 */
public class E9ineApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Create module to make it ready for the injection
        Injector.createApplicationComponent(new ApplicationModule(this));

        // Plant Timber tree for Logging
        Timber.plant(new Timber.DebugTree());
    }

}
