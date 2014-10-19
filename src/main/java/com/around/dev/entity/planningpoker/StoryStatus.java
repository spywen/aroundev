package com.around.dev.entity.planningpoker;

import javax.persistence.*;

/**
 * Created by laurent on 26/07/2014.
 */
@Entity
@Table(name = "PlanningPokerStatus", schema = "", catalog = "aroundev")
public class StoryStatus {
    private int id;
    private String code;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "statusId")
    @SequenceGenerator(name = "statusId", sequenceName = "STATUSID")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = false, insertable = true, updatable = true, length = 50)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "description", nullable = false, insertable = true, updatable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoryStatus)) return false;

        StoryStatus that = (StoryStatus) o;

        if (id != that.id) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
