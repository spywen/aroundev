package com.around.dev.entity.planningpoker;

import javax.persistence.*;
import java.security.Timestamp;

/**
 * Created by laurent on 26/07/2014.
 */
@Entity
@Table(name = "PlanningPokerStory", schema = "", catalog = "aroundev")
public class Story {
    private int id;
    private Grooming grooming;
    private String name;
    private String description;
    private Timestamp creationdate;
    private StoryStatus storyStatus;
    private int estimation;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "storyId")
    @SequenceGenerator(name = "storyId", sequenceName = "STORYID")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grooming", referencedColumnName = "id", nullable = false)
    public Grooming getGrooming() {
        return grooming;
    }

    public void setGrooming(Grooming grooming) {
        this.grooming = grooming;
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
    @Column(name = "creationdate", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Timestamp creationdate) {
        this.creationdate = creationdate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status", referencedColumnName = "id", nullable = false)
    public StoryStatus getStoryStatus() {
        return storyStatus;
    }

    public void setStoryStatus(StoryStatus storyStatus) {
        this.storyStatus = storyStatus;
    }

    @Basic
    @Column(name = "estimation", nullable = true, insertable = true, updatable = true)
    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Story)) return false;

        Story story = (Story) o;

        if (estimation != story.estimation) return false;
        if (id != story.id) return false;
        if (creationdate != null ? !creationdate.equals(story.creationdate) : story.creationdate != null) return false;
        if (description != null ? !description.equals(story.description) : story.description != null) return false;
        if (grooming != null ? !grooming.equals(story.grooming) : story.grooming != null) return false;
        if (name != null ? !name.equals(story.name) : story.name != null) return false;
        if (storyStatus != null ? !storyStatus.equals(story.storyStatus) : story.storyStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (grooming != null ? grooming.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creationdate != null ? creationdate.hashCode() : 0);
        result = 31 * result + (storyStatus != null ? storyStatus.hashCode() : 0);
        result = 31 * result + estimation;
        return result;
    }
}
