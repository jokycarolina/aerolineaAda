package com.aerolinea.aerolinea.model;

import javax.persistence.*;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_airplane;

    private String type;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name= "base_code",referencedColumnName = "id_base")
    private Base base_code;


    public Integer getId_airplane() {
        return id_airplane;
    }

    public void setId_airplane(Integer id_airplane) {
        this.id_airplane = id_airplane;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Base getBase_code() {
        return base_code;
    }

    public void setBase_code(Base base_code) {
        this.base_code = base_code;
    }
}
