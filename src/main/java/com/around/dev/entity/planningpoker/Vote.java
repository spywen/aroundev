package com.around.dev.entity.planningpoker;

import com.around.dev.entity.UserAroundev;

import javax.persistence.*;
import java.security.Timestamp;

/**
 * Created by laurent on 26/07/2014.
 */
@Entity
@Table(name = "PlanningPokerVote", schema = "", catalog = "aroundev")
public class Vote {
    private int id;
    private Story story;
    private UserAroundev userAroundev;
    private Timestamp votedate;
    private int session;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "voteId")
    @SequenceGenerator(name = "voteId", sequenceName = "VOTEID")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "story", referencedColumnName = "id", nullable = false)
    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "useraroundev", referencedColumnName = "id", nullable = false)
    public UserAroundev getUserAroundev() {
        return userAroundev;
    }

    public void setUserAroundev(UserAroundev userAroundev) {
        this.userAroundev = userAroundev;
    }

    @Basic
    @Column(name = "votedate", nullable = false, insertable = true, updatable = true)
    public Timestamp getVotedate() {
        return votedate;
    }

    public void setVotedate(Timestamp votedate) {
        this.votedate = votedate;
    }

    @Basic
    @Column(name = "session", nullable = false, insertable = true, updatable = true)
    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;

        Vote vote = (Vote) o;

        if (id != vote.id) return false;
        if (session != vote.session) return false;
        if (story != null ? !story.equals(vote.story) : vote.story != null) return false;
        if (userAroundev != null ? !userAroundev.equals(vote.userAroundev) : vote.userAroundev != null) return false;
        if (votedate != null ? !votedate.equals(vote.votedate) : vote.votedate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (story != null ? story.hashCode() : 0);
        result = 31 * result + (userAroundev != null ? userAroundev.hashCode() : 0);
        result = 31 * result + (votedate != null ? votedate.hashCode() : 0);
        result = 31 * result + session;
        return result;
    }
}
