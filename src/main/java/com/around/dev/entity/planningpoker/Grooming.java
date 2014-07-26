package com.around.dev.entity.planningpoker;

import com.around.dev.entity.UserAroundev;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.List;

/**
 * Created by laurent on 26/07/2014.
 */
@Entity
@Table(name = "PlanningPokerGrooming", schema = "", catalog = "aroundev")
public class Grooming {
    private int id;
    private String name;
    private String description;
    private Timestamp creationdate;
    private Timestamp enddate;
    private UserAroundev moderator;
    private boolean IsActive;
    private List<Story> stories;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moderator", referencedColumnName = "id", nullable = false)
    public UserAroundev getModerator() {
        return moderator;
    }

    public void setModerator(UserAroundev moderator) {
        this.moderator = moderator;
    }

    @Basic
    @Column(name = "isactive", nullable = false, insertable = true, updatable = true)
    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean isActive) {
        IsActive = isActive;
    }

    @OneToMany(mappedBy="grooming")
    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grooming)) return false;

        Grooming grooming = (Grooming) o;

        if (IsActive != grooming.IsActive) return false;
        if (id != grooming.id) return false;
        if (creationdate != null ? !creationdate.equals(grooming.creationdate) : grooming.creationdate != null)
            return false;
        if (description != null ? !description.equals(grooming.description) : grooming.description != null)
            return false;
        if (enddate != null ? !enddate.equals(grooming.enddate) : grooming.enddate != null) return false;
        if (moderator != null ? !moderator.equals(grooming.moderator) : grooming.moderator != null) return false;
        if (name != null ? !name.equals(grooming.name) : grooming.name != null) return false;
        if (stories != null ? !stories.equals(grooming.stories) : grooming.stories != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creationdate != null ? creationdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (moderator != null ? moderator.hashCode() : 0);
        result = 31 * result + (IsActive ? 1 : 0);
        result = 31 * result + (stories != null ? stories.hashCode() : 0);
        return result;
    }
}
