package com.aerolinea.aerolinea.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Base {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_base;

    private String city;

    public Integer getId_base() {
        return id_base;
    }

    public void setId_base(Integer id_base) {
        this.id_base = id_base;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id_base +
                ", city='" + city + '\'' +
                '}';
    }
}
