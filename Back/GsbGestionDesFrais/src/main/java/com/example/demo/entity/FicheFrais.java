package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FicheFrais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFicheFrais;

    private int nbJustificatifs;
    private double montantValide;
    private LocalDate dateModif;

    private String type; // ✅ Ajout du champ type
    private String description; // ✅ Ajout du champ description

    @ManyToOne
    @JoinColumn(name = "visiteur_id", nullable = false)
    private Visiteur visiteur;

    // Getters et Setters
    public Long getIdFicheFrais() {
        return idFicheFrais;
    }

    public void setIdFicheFrais(Long idFicheFrais) {
        this.idFicheFrais = idFicheFrais;
    }

    public int getNbJustificatifs() {
        return nbJustificatifs;
    }

    public void setNbJustificatifs(int nbJustificatifs) {
        this.nbJustificatifs = nbJustificatifs;
    }

    public double getMontantValide() {
        return montantValide;
    }

    public void setMontantValide(double montantValide) {
        this.montantValide = montantValide;
    }

    public LocalDate getDateModif() {
        return dateModif;
    }

    public void setDateModif(LocalDate dateModif) {
        this.dateModif = dateModif;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }
}
