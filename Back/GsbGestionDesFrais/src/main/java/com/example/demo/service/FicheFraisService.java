package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.FicheFrais;
import com.example.demo.entity.Visiteur;
import com.example.demo.repository.FicheFraisRepository;
import com.example.demo.repository.VisiteurRepository;

@Service
public class FicheFraisService {

    private final FicheFraisRepository ficheFraisRepository;
    private final VisiteurRepository visiteurRepository;

    public FicheFraisService(FicheFraisRepository ficheFraisRepository, VisiteurRepository visiteurRepository) {
        this.ficheFraisRepository = ficheFraisRepository;
        this.visiteurRepository = visiteurRepository;
    }

    // ✅ Récupération de toutes les fiches de frais
    public List<FicheFrais> getAllFicheFrais() {
        return ficheFraisRepository.findAll();
    }

    // ✅ Récupération par ID
    public FicheFrais getFicheFraisById(Long id) {
        return ficheFraisRepository.findById(id).orElse(null);
    }

    // ✅ Création d'une fiche de frais
    public FicheFrais createFicheFrais(FicheFrais ficheFrais) {
        if (ficheFrais.getVisiteur() == null || ficheFrais.getVisiteur().getId() == null) {
            throw new RuntimeException("ID du visiteur est manquant");
        }

        Visiteur visiteur = visiteurRepository.findById(ficheFrais.getVisiteur().getId())
                .orElseThrow(() -> new RuntimeException("Visiteur non trouvé"));

        ficheFrais.setVisiteur(visiteur);

        return ficheFraisRepository.save(ficheFrais);
    }

    // ✅ Mise à jour d'une fiche de frais
    public FicheFrais updateFicheFrais(Long id, FicheFrais ficheFraisDetails) {
        FicheFrais ficheFrais = getFicheFraisById(id);
        if (ficheFrais != null) {
            ficheFrais.setNbJustificatifs(ficheFraisDetails.getNbJustificatifs());
            ficheFrais.setMontantValide(ficheFraisDetails.getMontantValide());
            ficheFrais.setDateModif(ficheFraisDetails.getDateModif());
            return ficheFraisRepository.save(ficheFrais);
        }
        return null;
    }

    // ✅ Suppression d'une fiche de frais
    public void deleteFicheFrais(Long id) {
        ficheFraisRepository.deleteById(id);
    }
}
