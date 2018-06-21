package com.example.vimos.gitapp.service;

import android.content.Context;

import com.example.vimos.gitapp.R;

/**
 * Created by Vimos on 21/06/2018.
 */

public class ApiUrlProvider {

    private static class Handler {
        static ApiUrlProvider INSTANCE = new ApiUrlProvider();
    }

    public static ApiUrlProvider getInstance() {
        return Handler.INSTANCE;
    }

    private String apiUrl;

    private ApiUrlProvider() {

    }

    public void init(Context context) {
        this.apiUrl = context.getString(R.string.api_address);
    }


    public String getApiUrl() {
        return apiUrl;
    }
}
