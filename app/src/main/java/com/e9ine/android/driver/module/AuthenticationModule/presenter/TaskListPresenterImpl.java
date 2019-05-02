package com.e9ine.android.driver.module.AuthenticationModule.presenter;

import android.accounts.NetworkErrorException;

import com.e9ine.android.driver.data.api.ApiObserver;
import com.e9ine.android.driver.data.api.E9ineService;
import com.e9ine.android.driver.data.model.Example;
import com.e9ine.android.driver.injection.Injector;
import com.e9ine.android.driver.module.base.BaseNetworkPresenter;
import com.e9ine.android.driver.module.common.util.PreferenceUtil;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Observable;

/**
 * @author Surendar D
 */
public class TaskListPresenterImpl extends BaseNetworkPresenter<TaskListViewInteractor>
        implements TaskListPresenter {

    @Inject
    PreferenceUtil preference;
    @Inject
    E9ineService api;

    public TaskListPresenterImpl() {
        Injector.component().inject(this);
    }

    @Override
    public void callSampleApi() {
        Observable<Response<Example>> observable = api.getSamleApiCall();

        subscribeForNetwork(observable, new ApiObserver<Response<Example>>() {
            @Override
            public void onResponse(Response<Example> response) {
                if (response.code() != 200) {
                    getViewInteractor().onNetworkCallError(new NetworkErrorException("Error on network: " + response.code()));
                    return;
                }

                getViewInteractor().onSampleApiSuccess(response.body());
            }

            @Override
            public void onError(Throwable e) {
                getViewInteractor().onNetworkCallError(e);
            }
        });
    }

}
