package com.microservices.reclamation.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Reclamation implements Serializable {
    private static final long serialVersionUID=6;
    @Id
    @GeneratedValue
    private int idReclamation;
    private String description;
    public int getIdReclamation(){
        return idReclamation;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public Reclamation(){
        super();
    }
    public Reclamation(String description){
        super();
        this.description=description;
    }

}
