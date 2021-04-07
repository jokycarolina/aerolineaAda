package com.aerolinea.aerolinea.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Crew {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name= "base_code",referencedColumnName = "id_base")
    private Base base_code;

    private String position;

    @JsonBackReference
    @ManyToMany(mappedBy = "flightCrew")
    private Set<Flight> flights;

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

    public Base getBase_code() {
        return base_code;
    }

    public void setBase_code(Base base_code) {
        this.base_code = base_code;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }
}
