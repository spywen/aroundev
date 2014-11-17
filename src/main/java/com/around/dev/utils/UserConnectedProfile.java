package com.around.dev.utils;

import java.util.List;

/**
 * Created by laurent on 03/11/14.
 */
public class UserConnectedProfile {
    private String login;
    private List<String> roles;

    public UserConnectedProfile(String login, List<String> roles){
        this.login = login;
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
