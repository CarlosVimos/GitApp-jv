package com.example.vimos.gitapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Vimos on 24/06/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleError {

    @JsonProperty("message")
    private String message;

    public SimpleError() {
    }

    public SimpleError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SimpleError{ message=" + message + "}";
    }
}
