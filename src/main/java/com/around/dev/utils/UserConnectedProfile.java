package com.around.dev.utils;

import java.util.List;

/**
 * Created by laurent on 03/11/14.
 */
public class UserConnectedProfile {
    private String publicname;
    private List<String> roles;

    public UserConnectedProfile(String publicname, List<String> roles){
        this.publicname = publicname;
        this.roles = roles;
    }

    public String getPublicname() {
        return publicname;
    }

    public void setPublicname(String publicname) {
        this.publicname = publicname;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
