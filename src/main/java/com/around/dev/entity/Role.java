package com.around.dev.entity;

import javax.persistence.*;

/**
 * Created by laurent on 23/07/2014.
 */
@Entity
@Table(name = "Role", schema = "", catalog = "aroundev")
public class Role {
    private int id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "roleId")
    @SequenceGenerator(name = "roleId", sequenceName = "ROLEID")
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 15, precision = 0)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
