package com.esprit.microservices.gestionreservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;


@Entity
public class Reservation implements Serializable {
    private static final long serialVersionUID= 6;
    @Id
    @GeneratedValue
    private Long id;

    private String prix;
    private String dateDebut,dateFin, dure;

    public Reservation() {

    }

    public Long getId() {
        return id;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getDure() {
        return dure;
    }

    public void setDure(String dure) {
        this.dure = dure;
    }



    public Reservation(String prix, String dateDebut, String dateFin, String dure) {
        this.prix = prix;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dure = dure;
    }

    public Reservation(String prix) {
        this.prix = prix;
    }
}
