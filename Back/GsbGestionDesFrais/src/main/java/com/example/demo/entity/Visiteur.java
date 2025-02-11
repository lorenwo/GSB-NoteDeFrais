package com.example.demo.entity;
import java.sql.Date;


import jakarta.persistence.*;

@Entity
public class Visiteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_visiteur;

    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private Double cp;
    private Date dateEmbauche;
    private String login;
    private String mdp;


 
    public Visiteur(String mdp) {
        this.mdp = mdp;
    }

    public Visiteur() {
        
    }

    // Getters et Setters
    public Long getId_visiteur() {
        return id_visiteur;
    }

    public void setId_visiteur(Long id_visiteur) {
        this.id_visiteur = id_visiteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getadresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    public Double getCp() {
        return cp;
    }

    public void setCp(Double cp) {
        this.cp = cp;
    }
    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
