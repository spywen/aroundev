package com.around.dev.security;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by laurent on 06/11/14.
 */
public class UserSubscriptionInformations {
    @NotEmpty @Size(min=1, max=50)
    private String lastname;
    @NotEmpty @Size(min=1, max=50)
    private String firstname;
    @NotNull
    private Boolean isfemale;
    @NotEmpty @Size(min=4, max=20)
    private String login;
    @NotEmpty @Email @Size(min=1, max=100)
    private String email;
    @NotEmpty @Size(min=5, max=30)
    private String password;

    public String getPassword() {
        return password;
    }

    public UserSubscriptionInformations setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UserSubscriptionInformations setLastname(String lastname) {
        this.lastname = lastname; return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public UserSubscriptionInformations setFirstname(String firstname) {
        this.firstname = firstname; return this;
    }

    public Boolean getIsfemale() {
        return isfemale;
    }

    public UserSubscriptionInformations setIsfemale(Boolean isfemale) {
        this.isfemale = isfemale; return this;
    }

    public String getLogin() {
        return login;
    }

    public UserSubscriptionInformations setLogin(String login) {
        this.login = login; return this;
    }

    public String getEmail() {
        return email;
    }

    public UserSubscriptionInformations setEmail(String email) {
        this.email = email; return this;
    }
}
