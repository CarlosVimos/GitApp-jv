package com.example.vimos.gitapp.model.dao;

import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.model.UsersList;
import com.example.vimos.gitapp.network.UserService;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by Vimos on 20/06/2018.
 */

public class UserDAOImpl implements UserDAO {


    private UserService userService;

    @Override
    public Observable<UsersList> searchUsers(final String searchTerm) {
        return userService.searchUsers(searchTerm);
    }
}
