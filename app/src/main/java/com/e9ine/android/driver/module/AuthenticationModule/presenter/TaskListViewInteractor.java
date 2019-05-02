package com.e9ine.android.driver.module.AuthenticationModule.presenter;

import com.e9ine.android.driver.data.model.Example;
import com.e9ine.android.driver.module.base.NetworkViewInteractor;

/**
 * @author Surendar D
 */
public interface TaskListViewInteractor extends NetworkViewInteractor {

    void onSampleApiSuccess(Example tasks);

}
