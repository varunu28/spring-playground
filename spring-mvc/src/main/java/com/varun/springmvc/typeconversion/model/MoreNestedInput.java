package com.varun.springmvc.typeconversion.model;

public class MoreNestedInput {

    private String idOne;
    private String idTwo;
    private String idThree;

    public MoreNestedInput(String idOne, String idTwo, String idThree) {
        this.idOne = idOne;
        this.idTwo = idTwo;
        this.idThree = idThree;
    }

    public String getIdOne() {
        return idOne;
    }

    public void setIdOne(String idOne) {
        this.idOne = idOne;
    }

    public String getIdTwo() {
        return idTwo;
    }

    public void setIdTwo(String idTwo) {
        this.idTwo = idTwo;
    }

    public String getIdThree() {
        return idThree;
    }

    public void setIdThree(String idThree) {
        this.idThree = idThree;
    }
}
