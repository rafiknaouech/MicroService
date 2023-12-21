package com.esprit.microservices.gestionstock.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class StockItem {
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue
    private Long id;

    private String nomProduit;
    private double quantiteEnStock;
    private double quantiteMinimale;
    private double prixUnitaire;

    public Long getId() {
        return id;
    }


    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(double quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public double getQuantiteMinimale() {
        return quantiteMinimale;
    }

    public void setQuantiteMinimale(double quantiteMinimale) {
        this.quantiteMinimale = quantiteMinimale;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    public StockItem(){
        super();
    }
    public StockItem(String nomProduit, double quantiteEnStock, double quantiteMinimale, double prixUnitaire) {
        this.nomProduit = nomProduit;
        this.quantiteEnStock = quantiteEnStock;
        this.quantiteMinimale = quantiteMinimale;
        this.prixUnitaire = prixUnitaire;
    }

   /* @Override
    public String toString() {
        return "StockItem{" +
                "id=" + id +
                ", nomProduit='" + nomProduit + '\'' +
                ", quantiteEnStock=" + quantiteEnStock +
                ", quantiteMinimale=" + quantiteMinimale +
                ", prixUnitaire=" + prixUnitaire +
                '}';
    }*/

}

