package com.example.product_api.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class LigneFraisHorsForfait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ligneFraisHorsForfait;

    private Date date;
    private Double montant;
    private String libelle;


    // Getters et Setters
    public Long getId_ligneFraisHorsForfait() {
        return id_ligneFraisHorsForfait;
    }

    public void setId_ligneFraisHorsForfait(Long id_ligneFraisHorsForfait) {
        this.id_ligneFraisHorsForfait = id_ligneFraisHorsForfait;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
