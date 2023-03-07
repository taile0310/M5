package com.furama.model.login;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.furama.model.employee.Employee;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class User {
    @Id
    @Column(length = 225)
    private String username;
    @Column(length = 225)
    @NotNull
    @JsonIgnore
    private String password;


    @ManyToMany(mappedBy = "userSet")
    private Set<Role> roleSet;

    @OneToMany(mappedBy = "username")
    private Set<Employee> employeeSet;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> userRoleSet) {
        this.roleSet = userRoleSet;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
