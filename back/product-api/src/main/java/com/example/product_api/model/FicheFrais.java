package com.example.product_api.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class FicheFrais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_visiteur;
    private Date mois;

    private Double nbJustificatif;
    private Double montantValide;
    private Date dateModif;

    @ManyToOne
    @JoinColumn(name = "id_visiteur", nullable = false)
    private Visiteur visiteur;

    // Getters et Setters
    public Long getId_visiteur() {
        return id_visiteur;
    }

    public void setId_visiteur(Long id_visiteur) {
        this.id_visiteur = id_visiteur;
    }

    public Date getMois() {
        return mois;
    }

    public void setMois(Date mois) {
        this.mois = mois;
    }

    public Double getNbJustificatif() {
        return nbJustificatif;
    }

    public void setNbJustificatif(Double nbJustificatif) {
        this.nbJustificatif = nbJustificatif;
    }

    public Double getMontantValide() {
        return montantValide;
    }

    public void setMontantValide(Double montantValide) {
        this.montantValide = montantValide;
    }
    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }
}
