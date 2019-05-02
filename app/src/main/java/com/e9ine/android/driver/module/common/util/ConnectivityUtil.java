package com.e9ine.android.driver.module.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.e9ine.android.driver.injection.Injector;

import javax.inject.Inject;

/**
 * @author Surendar D
 */
public class ConnectivityUtil {

    @Inject Context context;

    private ConnectivityManager connectivityManager;

    public ConnectivityUtil() {
        Injector.component().inject(this);
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public boolean isConnected() {
        NetworkInfo activeNetwork = getActiveNetwork();

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public boolean isWifiConnected() {
        NetworkInfo activeNetwork = getActiveNetwork();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting()
                && activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
    }

    public boolean isDataConnected() {
        NetworkInfo activeNetwork = getActiveNetwork();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting()
                && activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
    }

    private NetworkInfo getActiveNetwork() {
        return connectivityManager.getActiveNetworkInfo();
    }

}
