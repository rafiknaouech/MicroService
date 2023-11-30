package com.esprit.microservice.gestioncmmande.gestioncommande;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;


@Entity
public class Commande implements Serializable {
    private static final long serialVersionUID = 6;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//ID de la commande
    private int idClient;
    private String dateCommande; // Date et Heure de la Commande

    private String etat; // État de la Commande

    public Commande() {
    }

    // Getters et Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


    public Commande(int id, int idClient, String etat, String dateCommande) {

        this.id = id;
        this.idClient = idClient;
        this.etat = etat;
        this.dateCommande = dateCommande;
    }
}


