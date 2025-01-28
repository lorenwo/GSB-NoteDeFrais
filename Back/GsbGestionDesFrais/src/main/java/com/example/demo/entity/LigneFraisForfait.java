package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class LigneFraisForfait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date mois;

    private Double quantite;

    @ManyToOne
    @JoinColumn(name = "visiteur_id", nullable = false)
    private Visiteur visiteur;

    @ManyToOne
    @JoinColumn(name = "id_fraisForfait")
    private FraisForfait fraisForfait;

    // Getters et Setters
    
    
    public Date getMois() {
        return mois;
    }

    public void setMois(Date mois) {
        this.mois = mois;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }
}
