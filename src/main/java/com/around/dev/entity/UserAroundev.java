package com.around.dev.entity;

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
@Table(name = "user", schema = "", catalog = "aroundev")
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "userId")
    @SequenceGenerator(name = "userId", sequenceName = "USERID")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lastname", nullable = false, insertable = true, updatable = true, length = 50)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "firstname", nullable = false, insertable = true, updatable = true, length = 50)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "isfemale", nullable = true, insertable = true, updatable = true)
    public Boolean getIsfemale() {
        return isfemale;
    }

    public void setIsfemale(Boolean isfemale) {
        this.isfemale = isfemale;
    }

    @Basic
    @Column(name = "login", nullable = false, insertable = true, updatable = true, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "User_Role", catalog = "aroundev",
            joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)})
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    @Basic
    @Column(name = "registerdate", nullable = false, insertable = true, updatable = true)
    public Timestamp getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Timestamp registerdate) {
        this.registerdate = registerdate;
    }

    @Basic
    @Column(name = "isactive", nullable = false, insertable = true, updatable = true)
    public boolean getIsactive() { return isactive; }

    public void setIsactive(boolean isactive) { this.isactive = isactive; }

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
