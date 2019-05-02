package com.e9ine.android.driver.injection.module;

import com.e9ine.android.driver.module.common.util.Bakery;
import com.e9ine.android.driver.module.common.util.ConnectivityUtil;
import com.e9ine.android.driver.module.common.util.PreferenceUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provides all util class dependencies.
 *
 * @author Surendar D
 */
@Module
public class UtilModule {

    @Provides
    @Singleton
    public PreferenceUtil providePreferenceUtil() {
        return new PreferenceUtil();
    }

    @Provides
    @Singleton
    public ConnectivityUtil provideConnectivityUtil() {
        return new ConnectivityUtil();
    }

    @Provides
    @Singleton
    public Bakery provideBakery() {
        return new Bakery();
    }

}
