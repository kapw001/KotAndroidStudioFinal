package com.hm.kot.model;

import org.xmlpull.v1.XmlPullParser;

public class User {
    private int allow;
    private String password;
    private String username;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAllow() {
        return this.allow;
    }

    public void setAllow(int allow) {
        this.allow = allow;
    }

    public String toString() {
        return "User [" + (this.username != null ? "username=" + this.username + ", " : XmlPullParser.NO_NAMESPACE) + (this.password != null ? "password=" + this.password + ", " : XmlPullParser.NO_NAMESPACE) + "allow=" + this.allow + "]";
    }
}
