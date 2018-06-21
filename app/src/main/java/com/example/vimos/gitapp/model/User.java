package com.example.vimos.gitapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Vimos on 20/06/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("login")
    private String login;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("repos_url")
    private String reposUrl;


    public User() {
    }

    public User(final String userLogin, final String userReposUrl, final Integer userId) {
        this.login = userLogin;
        this.reposUrl = userReposUrl;
        this.id = userId;
    }


    public String getLogin() {
        return login;
    }

    public Integer getId() {
        return id;
    }

    public String getReposUrl() {
        return reposUrl;
    }


}
