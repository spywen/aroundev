package com.around.dev.utils;

import java.util.List;

/**
 * Created by laurent on 03/11/14.
 */
public class UserConnectedProfile {
    private String username;
    private List<String> roles;

    public UserConnectedProfile(String username, List<String> roles){
        this.username = username;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
