package com.example.vimos.gitapp.model.dao;

import com.example.vimos.gitapp.model.RepositoryList;
import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.model.UsersList;
import com.example.vimos.gitapp.network.UserService;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Vimos on 20/06/2018.
 */

public interface UserDao {

   // void init(UserService userService);

    Observable<UsersList> searchUsers(String searchTerm);

    Observable<RepositoryList> getRepos(String username);

}
