package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.FraisForfait;
import com.example.demo.entity.FraisHorsForfait;
import com.example.demo.entity.Visiteur;
import com.example.demo.repository.FraisForfaitRepository;
import com.example.demo.repository.FraisHorsForfaitRepository;
import com.example.demo.repository.VisiteurRepository;

@Service
public class FraisForfaitService {

    private final FraisForfaitRepository fraisForfaitRepository;
    private final VisiteurRepository visiteurRepository;
    private final FraisHorsForfaitRepository fraisHorsForfaitRepository;

    public FraisForfaitService(
        FraisForfaitRepository fraisForfaitRepository,
        VisiteurRepository visiteurRepository,
        FraisHorsForfaitRepository fraisHorsForfaitRepository
    ) {
        this.fraisForfaitRepository = fraisForfaitRepository;
        this.visiteurRepository = visiteurRepository;
        this.fraisHorsForfaitRepository = fraisHorsForfaitRepository;
    }

    public FraisForfait createFraisForfait(FraisForfait fraisForfait) {
        // 🔍 Vérifier le visiteur
        if (fraisForfait.getVisiteur() != null && fraisForfait.getVisiteur().getId() != null) {
            Visiteur visiteur = visiteurRepository.findById(fraisForfait.getVisiteur().getId())
                .orElseThrow(() -> new RuntimeException("Visiteur non trouvé avec l'ID : " + fraisForfait.getVisiteur().getId()));
            fraisForfait.setVisiteur(visiteur);
        } else {
            throw new RuntimeException("VisiteurId est invalide ou null");
        }

        // 🔁 Traitement automatique : si montant dépasse le plafond → enregistrer en hors forfait
        if (doitAllerDansHorsForfait(fraisForfait)) {
            FraisHorsForfait hors = new FraisHorsForfait();
            hors.setVisiteur(fraisForfait.getVisiteur());
            hors.setDate(fraisForfait.getDate());
            hors.setMontant(fraisForfait.getMontant());
            hors.setDescription(fraisForfait.getDescription());
            hors.setTypeFrais(fraisForfait.getTypeFrais());

            fraisHorsForfaitRepository.save(hors);

            // 💡 Optionnel : log ou message d’info
            System.out.println("Frais redirigé vers hors forfait automatiquement.");

            return null; // le frais forfait n'est pas sauvegardé
        }

        return fraisForfaitRepository.save(fraisForfait);
    }

    private boolean doitAllerDansHorsForfait(FraisForfait f) {
        if (f.getMontant() == null) return false;

        double montant = f.getMontant();
        String type = f.getTypeFrais();

        return switch (type) {
            case "Nuitée" -> montant > 100;
            case "Repas midi" -> montant > 25;
            case "Relais étape" -> montant > 140;
            case "Kilométrage" -> false; // pas de seuil car montant calculé auto
            case "Hors forfait" -> false; // autorisé
            default -> false;
        };
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

public FraisForfait updateFraisForfait(Long id, FraisForfait fraisDetails) {
    FraisForfait existing = fraisForfaitRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Frais non trouvé avec l’ID : " + id));

    // ➕ Met à jour les champs
    existing.setDate(fraisDetails.getDate());
    existing.setTypeFrais(fraisDetails.getTypeFrais());
    existing.setKilometres(fraisDetails.getKilometres());
    existing.setMontant(fraisDetails.getMontant());
    existing.setDescription(fraisDetails.getDescription());

    // ✅ Vérifie s’il devient un hors forfait
    if (doitAllerDansHorsForfait(existing)) {
        // 🔥 Supprime le frais forfait existant
        fraisForfaitRepository.deleteById(id);

        // ➕ Crée un nouveau frais hors forfait
        FraisHorsForfait hors = new FraisHorsForfait();
        hors.setVisiteur(existing.getVisiteur());
        hors.setDate(existing.getDate());
        hors.setMontant(existing.getMontant());
        hors.setDescription(existing.getDescription());
        hors.setTypeFrais(existing.getTypeFrais());

        fraisHorsForfaitRepository.save(hors);

        // 💡 Peut retourner null ou un indicateur
        return null;
    }

    return fraisForfaitRepository.save(existing);
}


    public FraisForfait getFraisById(Long id) {
    return fraisForfaitRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Frais non trouvé avec l'ID : " + id));
}


}
