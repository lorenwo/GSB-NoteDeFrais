package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
public class Etat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_etat;

    private String libelle;
    

    // Getters et Setters
    public Long getId_etat() {
        return id_etat;
    }

    public void setId_etat(Long id_etat) {
        this.id_etat = id_etat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}