package com.innova.beans;

/**
 * Created by Innova on 03-09-2017.
 */
public class User {

    private String name;

    public User(){}
    public User(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
