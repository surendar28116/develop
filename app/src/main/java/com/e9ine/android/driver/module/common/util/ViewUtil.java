package com.e9ine.android.driver.module.common.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * @author Surendar D
 */
public class ViewUtil {

    public static void hideKeyboard(View view) {
        InputMethodManager inputMgr = (InputMethodManager)view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
