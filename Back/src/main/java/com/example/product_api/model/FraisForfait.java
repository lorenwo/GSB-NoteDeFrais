package com.example.product_api.model;


import jakarta.persistence.*;

@Entity
public class FraisForfait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fraisForfait;

    private String libelle;
    private Double montant;

    // Getters et Setters
    public Long getId_fraisForfait() {
        return id_fraisForfait;
    }

    public void setId_fraisForfait(Long id_fraisForfait) {
        this.id_fraisForfait = id_fraisForfait;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
}
