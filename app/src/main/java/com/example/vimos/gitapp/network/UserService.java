package com.example.vimos.gitapp.network;

import com.example.vimos.gitapp.Repository;
import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.model.UsersList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Vimos on 20/06/2018.
 */

public interface UserService {

    @GET("/search/users?per_page=2")
    Observable<UsersList> searchUsers(
            @Query("q") String searchTerm
    );

    @GET("users/{user}/repos")
    Observable<List<Repository>> listRepos(@Path("user") String user);

    @GET("/users/{username}")
    Observable<User> getUser(String username);


}
