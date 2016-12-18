package com.julianraj.mvpstartkit.util;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by julian on 12/17/16.
 */

public class PreferenceHelper {
    // TODO: 12/17/16 change the pref name
    public static final String PREF_NAME = "my_app_preferences";

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Inject
    public PreferenceHelper(Context pContext) {
        pref = pContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }
}
