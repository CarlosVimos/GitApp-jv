package com.example.vimos.gitapp.network;

import com.example.vimos.gitapp.model.Repository;
import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.model.UsersList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Vimos on 20/06/2018.
 */

public interface UserService {

    @GET("/search/users?")
    Observable<UsersList> searchUsers(
            @Query("q") String searchTerm,
            @Query("page") String nextPage
    );

    @GET("/users/{user}/repos")
    Observable<List<Repository>> getUserRepos(
            @Path("user") String user
    );

    @GET("/users/{username}")
    Observable<User> getUser(String username);


}
