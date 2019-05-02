package com.e9ine.android.driver.module.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Provides some basic operations, all fragments should extend this class.
 *
 * @author Surendar D
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
    }

    /**
     * Binds the viewInteractor objects within the fragment.
     *
     * @param view
     */
    protected void bindViews(View view) {
        ButterKnife.bind(this, view);
    }

    /**
     * Starts an activity with a bundle set to the intent.
     *
     * @param activityClass Class<? extends Activity>
     * @param bundle Bundle
     */
    protected void startActivity(Class<? extends Activity> activityClass, Bundle bundle) {
        Intent intent = new Intent(getActivity(), activityClass);

        if (bundle != null) intent.putExtras(bundle);

        startActivity(intent);
    }

    /**
     * Get the content view of fragment.
     *
     * @return
     */
    protected View getContentView() {
        return getView();
    }

}
