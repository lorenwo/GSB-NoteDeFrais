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

    // ✅ Création d'un frais forfait
    public FraisForfait createFraisForfait(FraisForfait fraisForfait) {
        if (fraisForfait.getVisiteur() != null && fraisForfait.getVisiteur().getId() != null) {
            Visiteur visiteur = visiteurRepository.findById(fraisForfait.getVisiteur().getId())
                    .orElseThrow(() -> new RuntimeException("Visiteur non trouvé avec l'ID : " + fraisForfait.getVisiteur().getId()));
            fraisForfait.setVisiteur(visiteur);
        } else {
            throw new RuntimeException("VisiteurId est invalide ou null");
        }
    
        return fraisForfaitRepository.save(fraisForfait);
    }
    
    public boolean deleteFraisForfaitById(Long id) {
        if (fraisForfaitRepository.existsById(id)) {
            fraisForfaitRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<FraisForfait> getFraisByVisiteurId(Long visiteurId) {
        return fraisForfaitRepository.findByVisiteurId(visiteurId);
    }
    
}
