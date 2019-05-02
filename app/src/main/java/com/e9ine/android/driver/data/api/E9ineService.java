package com.e9ine.android.driver.data.api;

import com.e9ine.android.driver.data.model.Example;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * @author Surendar D
 */
public interface E9ineService {

    @GET("volley/person_object.json")
    Observable<Response<Example>> getSamleApiCall();

}
