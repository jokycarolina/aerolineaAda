package com.aerolinea.aerolinea.model;

import javax.persistence.*;

@Entity
public class Pilot {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_pilot;

    private String name;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name= "base_code",referencedColumnName = "id_base")
    private Base base_code;

    private Integer hours;

    public Integer getId_pilot() {
        return id_pilot;
    }

    public void setId_pilot(Integer id_pilot) {
        this.id_pilot = id_pilot;
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

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
