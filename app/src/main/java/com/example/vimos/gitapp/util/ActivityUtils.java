package com.example.vimos.gitapp.util;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Vimos on 21/06/2018.
 */

public class ActivityUtils {

    public static <T extends Fragment> T createAndAddFragment(@IdRes int containerId, Class<T> fragmentClazz, AppCompatActivity activity) {
        @SuppressWarnings("unchecked")
        T fragment = (T) activity.getSupportFragmentManager().findFragmentById(containerId);

        if (fragment == null) {
            try {
                fragment = fragmentClazz.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            activity.getSupportFragmentManager().beginTransaction()
                    .add(containerId, fragment)
                    .commit();
        }

        return fragment;
    }

}
