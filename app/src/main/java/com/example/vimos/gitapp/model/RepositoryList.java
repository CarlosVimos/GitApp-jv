package com.example.vimos.gitapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Vimos on 23/06/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepositoryList {

    private List<Repository> repositoryList;



    public RepositoryList(final List<Repository> repositoryList) {
        this.repositoryList = repositoryList;
    }

    public List<Repository> getRepositoryList() {
        return repositoryList;
    }
}
