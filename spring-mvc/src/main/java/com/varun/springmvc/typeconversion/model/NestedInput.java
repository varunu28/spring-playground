package com.varun.springmvc.typeconversion.model;

public class NestedInput {
    private String token;

    private MoreNestedInput moreNestedInput;

    public NestedInput(String token, MoreNestedInput moreNestedInput) {
        this.token = token;
        this.moreNestedInput = moreNestedInput;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MoreNestedInput getMoreNestedInput() {
        return moreNestedInput;
    }

    public void setMoreNestedInput(MoreNestedInput moreNestedInput) {
        this.moreNestedInput = moreNestedInput;
    }
}
