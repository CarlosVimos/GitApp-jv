package com.example.vimos.gitapp;

import android.app.Application;

import com.example.vimos.gitapp.service.ApiUrlProvider;

import timber.log.Timber;

/**
 * Created by Vimos on 21/06/2018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ApiUrlProvider.getInstance().init(this);
    }
}
