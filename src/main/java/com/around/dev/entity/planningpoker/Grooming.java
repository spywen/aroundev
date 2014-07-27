package com.around.dev.entity.planningpoker;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by laurent on 26/07/2014.
 */
@Entity
@Table(name = "PlanningPokerGrooming", schema = "", catalog = "aroundev")
public class Grooming implements Serializable{
    private int id;
    private String name;
    private String description;
    private Timestamp creationdate;
    private Timestamp enddate;
    private int moderator;
    private Boolean IsActive;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "groomingId")
    @SequenceGenerator(name = "groomingId", sequenceName = "GROOMINGID")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "creationdate", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Timestamp startdate) {
        this.creationdate = startdate;
    }

    @Basic
    @Column(name = "enddate", nullable = true, insertable = true, updatable = true)
    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "moderator")
    public int getModerator() {
        return moderator;
    }

    public void setModerator(int moderator) {
        this.moderator = moderator;
    }

    @Basic
    @Column(name = "isactive", nullable = false, insertable = true, updatable = true)
    public Boolean getIsActive() {
        return IsActive;
    }

    public void setIsActive(Boolean isActive) {
        IsActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grooming)) return false;

        Grooming grooming = (Grooming) o;

        if (id != grooming.id) return false;
        if (IsActive != null ? !IsActive.equals(grooming.IsActive) : grooming.IsActive != null) return false;
        if (creationdate != null ? !creationdate.equals(grooming.creationdate) : grooming.creationdate != null)
            return false;
        if (description != null ? !description.equals(grooming.description) : grooming.description != null)
            return false;
        if (enddate != null ? !enddate.equals(grooming.enddate) : grooming.enddate != null) return false;
        if (name != null ? !name.equals(grooming.name) : grooming.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creationdate != null ? creationdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (IsActive != null ? IsActive.hashCode() : 0);
        return result;
    }
}
