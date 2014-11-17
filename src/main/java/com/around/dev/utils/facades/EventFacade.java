package com.around.dev.utils.facades;

import java.sql.Timestamp;

/**
 * Created by laurent on 16/11/14.
 */
public class EventFacade {
    private int id;
    private String title;
    private String description;
    private Timestamp startdate;
    private Timestamp creationdate;
    private boolean amiowner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public Timestamp getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Timestamp creationdate) {
        this.creationdate = creationdate;
    }

    public boolean isAmiowner() {
        return amiowner;
    }

    public void setAmiowner(boolean amiowner) {
        this.amiowner = amiowner;
    }
}
