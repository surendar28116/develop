package com.e9ine.android.driver.injection;

import com.e9ine.android.driver.injection.component.ApplicationComponent;
import com.e9ine.android.driver.injection.component.DaggerApplicationComponent;
import com.e9ine.android.driver.injection.module.ApiModule;
import com.e9ine.android.driver.injection.module.ApplicationModule;
import com.e9ine.android.driver.injection.module.PresenterModule;
import com.e9ine.android.driver.injection.module.UtilModule;

/**
 * A singleton class, which is responsible for holding dagger ObjectGraph, adding modules to it
 * & injecting dependencies.
 *
 * @author Surendar D
 */
public class Injector {

    // Singleton instance
    private static Injector instance;

    // components
    private ApplicationComponent applicationComponent;

    // Private constructor to make it singleton
    private Injector() {
    }

    /**
     * Get the singleton Injector instance
     *
     * @return Injector
     */
    private static Injector instance() {
        if (instance == null) {
            instance = new Injector();
        }
        
        return  instance;
    }

    /**
     * Creates application component which used of injection later.
     *
     * @param applicationModule
     */
    public static void createApplicationComponent(ApplicationModule applicationModule) {
        if (instance().applicationComponent == null) {
            instance().applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(applicationModule)
                    .apiModule(new ApiModule())
                    .presenterModule(new PresenterModule())
                    .utilModule(new UtilModule())
                    .build();
        }
    }

    /**
     * Returns the component for injection.
     *
     * @return
     */
    public static ApplicationComponent component() {
        return instance().applicationComponent;
    }

}
