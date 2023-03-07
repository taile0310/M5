package com.furama.model.facility;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class FacilityType {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;

    @OneToMany(mappedBy = "facilityType")
        private Set<Facility> facilitySet;

    public FacilityType() {
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

    public Set<Facility> getFacilitySet() {
        return facilitySet;
    }

    public void setFacilitySet(Set<Facility> facilitySet) {
        this.facilitySet = facilitySet;
    }
}
