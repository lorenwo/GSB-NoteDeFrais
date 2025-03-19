package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "frais_forfait") // ✅ Laisse Hibernate gérer la création de la table
public class FraisForfait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ AUTO_INCREMENT généré automatiquement par Hibernate
    @Column(name = "id_frais_forfait", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visiteur_id", nullable = false) // ✅ Relation avec la table visiteur
    private Visiteur visiteur;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = true)
    private Integer kilometres;

    // ✅ Montant avec valeur par défaut
    @Column(nullable = false)
    private Double montant = 0.0;

    @Column(nullable = true)
    private String description;

    @Column(name = "type_frais", nullable = false)
    private String typeFrais;

    // ✅ Constructeur par défaut
    public FraisForfait() {}

    // ✅ Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getKilometres() {
        return kilometres;
    }

    public void setKilometres(Integer kilometres) {
        this.kilometres = kilometres;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeFrais() {
        return typeFrais;
    }

    public void setTypeFrais(String typeFrais) {
        this.typeFrais = typeFrais;
    }

    // ✅ Méthode pour calculer le montant en fonction du type de frais
    public void calculateMontant() {
        if ("Kilométrage".equalsIgnoreCase(this.typeFrais) && this.kilometres != null) {
            this.montant = this.kilometres * 0.5; // Exemple : 0.5€ par km
        } else if ("Nuitée".equalsIgnoreCase(this.typeFrais)) {
            this.montant = 80.0; // Exemple : 80€ pour un forfait hôtel
        } else if ("Relais étape".equalsIgnoreCase(this.typeFrais)) {
            this.montant = 120.0; // Exemple : 120€ pour un relais étape
        } else if ("Repas midi".equalsIgnoreCase(this.typeFrais)){
            this.montant = 20.0; // Valeur par défaut si le type est inconnu
        } else {
            this.montant = 0.0;
        }
    }
}
