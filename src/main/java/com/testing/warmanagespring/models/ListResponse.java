package com.testing.warmanagespring.models;

import java.util.Collection;

public class ListResponse<T> {

    protected int statusCode;
    protected String message;
    protected Collection<T> results;

    public ListResponse(int statusCode, String message, Collection<T> results) {
        this.statusCode = statusCode;
        this.message = message;
        this.results = results;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Collection<T> getResults() {
        return results;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResults(Collection<T> results) {
        this.results = results;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
