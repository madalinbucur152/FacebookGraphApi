package com.endava.facebookGraph.models;

import java.util.Objects;

public class TestUser {

    private String uid;
    private Boolean installed;
    private String permissions;
    private String name;
    private String owner_access_token;
    private String login_url;
    private String email;
    private String password;

    public TestUser() {
        this.installed = true;
    }

    public TestUser(String permissions, String name, String owner_access_token) {
        this.permissions = permissions;
        this.name = name;
        this.owner_access_token = owner_access_token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Boolean getInstalled() {
        return installed;
    }

    public void setInstalled(Boolean installed) {
        this.installed = installed;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner_access_token() {
        return owner_access_token;
    }

    public void setOwner_access_token(String owner_access_token) {
        this.owner_access_token = owner_access_token;
    }

    public String getLogin_url() {
        return login_url;
    }

    public void setLogin_url(String login_url) {
        this.login_url = login_url;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestUser testUser = (TestUser) o;
        return Objects.equals(uid, testUser.uid) &&
                Objects.equals(installed, testUser.installed) &&
                Objects.equals(permissions, testUser.permissions) &&
                Objects.equals(name, testUser.name) &&
                Objects.equals(owner_access_token, testUser.owner_access_token) &&
                Objects.equals(login_url, testUser.login_url) &&
                Objects.equals(email, testUser.email) &&
                Objects.equals(password, testUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, installed, permissions, name, owner_access_token, login_url, email, password);
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "uid='" + uid + '\'' +
                ", installed=" + installed +
                ", permissions='" + permissions + '\'' +
                ", name='" + name + '\'' +
                ", owner_access_token='" + owner_access_token + '\'' +
                ", login_url='" + login_url + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
