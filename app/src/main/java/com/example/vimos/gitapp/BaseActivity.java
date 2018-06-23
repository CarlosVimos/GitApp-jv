package com.example.vimos.gitapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.vimos.gitapp.model.dao.UserDao;
import com.example.vimos.gitapp.model.dao.UserDaoImpl;

/**
 * Created by Vimos on 21/06/2018.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


    }
}
