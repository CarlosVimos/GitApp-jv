package com.example.vimos.gitapp.model.dao;

import com.example.vimos.gitapp.model.Repository;
import com.example.vimos.gitapp.model.RepositoryList;
import com.example.vimos.gitapp.model.UsersList;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Vimos on 20/06/2018.
 */

public interface UserDao {

    Observable<UsersList> searchUsers(String searchTerm, String nextPage);

    Observable<List<Repository>> getRepos(String username);

}
