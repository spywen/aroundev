package com.around.dev.entity;

import javax.persistence.*;
import java.security.Timestamp;

/**
 * Created by laurent on 26/07/2014.
 */
@Entity
@Table(name = "PERSISTENT_LOGINS")
public class persistent_logins {
    private String username;
    private String series;
    private String token;
    private Timestamp last_used;

    @Basic
    @Column(name = "USERNAME", nullable = false, insertable = true, updatable = true, length = 64, precision = 0)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @Column(name = "SERIES", nullable = false, insertable = true, updatable = true, length = 64, precision = 0)
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Basic
    @Column(name = "TOKEN", nullable = false, insertable = true, updatable = true, length = 64, precision = 0)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "LAST_USED", nullable = false, insertable = true, updatable = true)
    public Timestamp getLast_used() {
        return last_used;
    }

    public void setLast_used(Timestamp last_used) {
        this.last_used = last_used;
    }
}
