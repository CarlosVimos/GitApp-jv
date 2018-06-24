package com.example.vimos.gitapp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Vimos on 20/06/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

    @JsonProperty("name")
    private String name;

    @JsonProperty("full_name")
    private String fullName;


    public Repository() {
    }

    public Repository(final String repoName, final String repoFullName) {
        this.name = repoName;
        this.fullName = repoFullName;
    }


    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }
}
