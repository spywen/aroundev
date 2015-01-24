package com.around.dev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by laurent on 19/07/2014.
 */
@Entity
@Table(name = "USER")
public class UserAroundev {
    private int id;
    private String lastname;
    private String firstname;
    private Boolean isfemale;
    private String login;
    private String email;
    private String password;
    private Timestamp registerdate;
    private Boolean isactive;
    private Set<Role> roles;
    //Supinfo
    private int supinfoid;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "userId")
    @SequenceGenerator(name = "userId", sequenceName = "USERID")
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public UserAroundev setId(int id) {
        this.id = id;return this;
    }

    @JsonIgnore
    @Basic
    @Column(name = "SUPINFOID", nullable = true, insertable = true, updatable = true)
    public int getSupinfoid() {
        return supinfoid;
    }

    public UserAroundev setSupinfoid(int supinfoid) {
        this.supinfoid = supinfoid;return this;
    }

    @JsonIgnore
    @Basic
    @Column(name = "LASTNAME", nullable = false, insertable = true, updatable = true, length = 50)
    public String getLastname() {
        return lastname;
    }

    public UserAroundev setLastname(String lastname) {
        this.lastname = lastname;return this;
    }

    @JsonIgnore
    @Basic
    @Column(name = "FIRSTNAME", nullable = false, insertable = true, updatable = true, length = 50)
    public String getFirstname() {
        return firstname;
    }

    public UserAroundev setFirstname(String firstname) {
        this.firstname = firstname;return this;
    }

    @JsonIgnore
    @Basic
    @Column(name = "ISFEMALE", nullable = true, insertable = true, updatable = true)
    public Boolean getIsfemale() {
        return isfemale;
    }

    public UserAroundev setIsfemale(Boolean isfemale) {
        this.isfemale = isfemale;return this;
    }

    @Basic
    @Column(name = "LOGIN", nullable = false, insertable = true, updatable = true, length = 50)
    public String getLogin() {
        return login;
    }

    public UserAroundev setLogin(String login) {
        this.login = login;return this;
    }

    @JsonIgnore
    @Basic
    @Column(name = "EMAIL", nullable = false, insertable = true, updatable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public UserAroundev setEmail(String email) {
        this.email = email;return this;
    }

    @JsonIgnore
    @Basic
    @Column(name = "PASSWORD", nullable = false, insertable = true, updatable = true, length = 100)
    public String getPassword() {
        return password;
    }

    public UserAroundev setPassword(String password) {
        this.password = password; return this;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)})
    public Set<Role> getRoles() {
        return roles;
    }

    public UserAroundev setRoles(Set<Role> roles) {
        this.roles = roles; return this;
    }

    @Transient
    @JsonIgnoreProperties(ignoreUnknown = true)
    public List<GrantedAuthority> getRolesAutorithies() {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        if (this.roles != null && !this.roles.isEmpty())
            for (Role role : this.roles) {
                authList.add(new SimpleGrantedAuthority(role.getName()));
            }
        return authList;
    }

    @JsonIgnore
    @Basic
    @Column(name = "REGISTERDATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getRegisterdate() {
        return registerdate;
    }

    public UserAroundev setRegisterdate(Timestamp registerdate) {
        this.registerdate = registerdate; return this;
    }

    @JsonIgnore
    @Basic
    @Column(name = "ISACTIVE", nullable = false, insertable = true, updatable = true)
    public boolean getIsactive() { return isactive; }

    public UserAroundev setIsactive(boolean isactive) { this.isactive = isactive; return this; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAroundev)) return false;

        UserAroundev userAroundev = (UserAroundev) o;

        if (id != userAroundev.id) return false;
        if (email != null ? !email.equals(userAroundev.email) : userAroundev.email != null) return false;
        if (firstname != null ? !firstname.equals(userAroundev.firstname) : userAroundev.firstname != null) return false;
        if (isactive != null ? !isactive.equals(userAroundev.isactive) : userAroundev.isactive != null) return false;
        if (isfemale != null ? !isfemale.equals(userAroundev.isfemale) : userAroundev.isfemale != null) return false;
        if (lastname != null ? !lastname.equals(userAroundev.lastname) : userAroundev.lastname != null) return false;
        if (login != null ? !login.equals(userAroundev.login) : userAroundev.login != null) return false;
        if (password != null ? !password.equals(userAroundev.password) : userAroundev.password != null) return false;
        if (registerdate != null ? !registerdate.equals(userAroundev.registerdate) : userAroundev.registerdate != null) return false;
        if (roles != null ? !roles.equals(userAroundev.roles) : userAroundev.roles != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (isfemale != null ? isfemale.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (registerdate != null ? registerdate.hashCode() : 0);
        result = 31 * result + (isactive != null ? isactive.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }
}
