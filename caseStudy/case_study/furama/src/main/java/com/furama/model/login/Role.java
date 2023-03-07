package com.furama.model.login;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 225)
    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "username"))
    private Set<User> userSet;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userRoleSet) {
        this.userSet = userRoleSet;
    }
}
