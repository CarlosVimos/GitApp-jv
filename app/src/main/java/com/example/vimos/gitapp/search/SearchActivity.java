package com.example.vimos.gitapp.search;


import android.os.Bundle;

import com.example.vimos.gitapp.BaseActivity;
import com.example.vimos.gitapp.R;
import com.example.vimos.gitapp.model.dao.UserDaoImpl;
import com.example.vimos.gitapp.util.ActivityUtils;

import butterknife.ButterKnife;


public class SearchActivity extends BaseActivity {

    private SearchPresenter presenter;
    private UserDaoImpl userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        userDao = new UserDaoImpl();

        ButterKnife.bind(this);
        SearchFragment searchFragment = new SearchFragment();
        searchFragment = ActivityUtils.createAndAddFragment(R.id.fragment_container, SearchFragment.class, this);
        presenter = new SearchPresenter(
                searchFragment,
                userDao
        );

    }

}
