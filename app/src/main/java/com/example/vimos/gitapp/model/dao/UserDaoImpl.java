package com.example.vimos.gitapp.model.dao;

import com.example.vimos.gitapp.model.Repository;
import com.example.vimos.gitapp.model.UsersList;
import com.example.vimos.gitapp.network.UserService;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vimos on 20/06/2018.
 */

public class UserDaoImpl implements UserDao {


    private static final class Handler {
        static final UserDaoImpl INSTANCE = new UserDaoImpl();
    }

    public static UserDaoImpl getInstance() {
        return Handler.INSTANCE;
    }

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @Override
    public Observable<UsersList> searchUsers(final String searchTerm, final String nextPage) {

        final UserService us = retrofit.create(UserService.class);
        return us.searchUsers(searchTerm, nextPage);
    }

    @Override
    public Observable<List<Repository>> getRepos(String username) {

        final UserService us = retrofit.create(UserService.class);
        return us.getUserRepos(username);
    }
}
