package com.example.vimos.gitapp.model.dao;

import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.model.UsersList;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Vimos on 20/06/2018.
 */

public interface UserDAO {

    Observable<UsersList> searchUsers(String searchTerm);

}
