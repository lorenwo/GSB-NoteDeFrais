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
	    private Long id_ficheFrais;
	
	    private int nbJustificatifs;
	    private double montantValide;
	    private LocalDate dateModif;

	    @ManyToOne
	    @JoinColumn(name = "visiteur_id", nullable = false)
	    private Visiteur visiteur;

	    @ManyToOne
	    @JoinColumn(name = "mois", nullable = false)
	    private LigneFraisForfait mois;

	    public Long getId_ficheFrais() {
	        return id_ficheFrais;
	    }

	    public void setId_ficheFrais(Long id_ficheFrais) {
	        this.id_ficheFrais = id_ficheFrais;
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

		public Visiteur getVisiteur() {
			return visiteur;
		}

		public void setVisiteur(Visiteur visiteur) {
			this.visiteur = visiteur;
		}
		
		

		

	    
	    
	}