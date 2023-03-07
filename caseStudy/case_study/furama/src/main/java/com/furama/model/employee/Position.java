package com.furama.model.employee;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Position {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(length = 45, unique = true)
    private String name;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employeeSet;

    public Position() {
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

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
