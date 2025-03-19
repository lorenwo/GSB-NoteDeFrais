package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.FraisForfait;
import com.example.demo.entity.Visiteur;
import com.example.demo.repository.FraisForfaitRepository;
import com.example.demo.repository.VisiteurRepository;

@Service
public class FraisForfaitService {

    private final FraisForfaitRepository fraisForfaitRepository;
    private final VisiteurRepository visiteurRepository;

    public FraisForfaitService(FraisForfaitRepository fraisForfaitRepository, VisiteurRepository visiteurRepository) {
        this.fraisForfaitRepository = fraisForfaitRepository;
        this.visiteurRepository = visiteurRepository;
    }

    // ✅ Récupération de tous les frais
    public List<FraisForfait> getAllFraisForfait() {
        return fraisForfaitRepository.findAll();
    }

    // ✅ Création d'un frais forfait
    public FraisForfait createFraisForfait(FraisForfait fraisForfait) {
        if (fraisForfait.getVisiteur() != null && fraisForfait.getVisiteur().getId() != null) {
            Visiteur visiteur = visiteurRepository.findById(fraisForfait.getVisiteur().getId())
                    .orElseThrow(() -> new RuntimeException("Visiteur non trouvé avec l'ID : " + fraisForfait.getVisiteur().getId()));
            fraisForfait.setVisiteur(visiteur);
        } else {
            throw new RuntimeException("VisiteurId est invalide ou null");
        }
    
        // ✅ Calcul automatique du montant basé sur le type de frais
        fraisForfait.calculateMontant();
    
        return fraisForfaitRepository.save(fraisForfait);
    }
    
    
}
