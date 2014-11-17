package com.around.dev.entity.eventmanager;

import com.around.dev.entity.UserAroundev;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by laurent on 10/11/14.
 */
@Entity
@Table(name = "event", schema = "", catalog = "aroundev")
public class Event {
    private int id;
    private String title;
    private String description;
    private Timestamp startdate;
    private Timestamp creationdate;
    private UserAroundev owner;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public Event setId(int id) {
        this.id = id; return this;
    }

    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 100)
    public String getTitle() {
        return title;
    }

    public Event setTitle(String title) {
        this.title = title; return this;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public Event setDescription(String description) {
        this.description = description; return this;
    }

    @Basic
    @Column(name = "startdate", nullable = false, insertable = true, updatable = true)
    public Timestamp getStartdate() {
        return startdate;
    }

    public Event setStartdate(Timestamp startdate) {
        this.startdate = startdate; return this;
    }

    @Basic
    @Column(name = "creationdate", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreationdate() {
        return creationdate;
    }

    public Event setCreationdate(Timestamp creationdate) {
        this.creationdate = creationdate; return this;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner", referencedColumnName = "id", nullable = false)
    public UserAroundev getOwner() {
        return owner;
    }

    public Event setOwner(UserAroundev owner) {
        this.owner = owner; return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event that = (Event) o;

        if (id != that.id) return false;
        if (owner != that.owner) return false;
        if (creationdate != null ? !creationdate.equals(that.creationdate) : that.creationdate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (creationdate != null ? creationdate.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
