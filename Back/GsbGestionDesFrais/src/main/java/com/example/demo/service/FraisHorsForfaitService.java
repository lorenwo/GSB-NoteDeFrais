package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.FraisHorsForfait;
import com.example.demo.repository.FraisHorsForfaitRepository;
import com.example.demo.entity.FraisForfait;
import com.example.demo.repository.FraisForfaitRepository;

@Service
public class FraisHorsForfaitService {

private final FraisHorsForfaitRepository repository;
private final FraisForfaitRepository fraisForfaitRepository; // ✅ AJOUT

public FraisHorsForfaitService(
    FraisHorsForfaitRepository repository,
    FraisForfaitRepository fraisForfaitRepository // ✅ AJOUT
) {
    this.repository = repository;
    this.fraisForfaitRepository = fraisForfaitRepository;
}

    public List<FraisHorsForfait> getByVisiteurId(Long id) {
        return repository.findByVisiteurId(id);
    }

    public FraisHorsForfait save(FraisHorsForfait f) {
        return repository.save(f);
    }

    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public FraisHorsForfait update(Long id, FraisHorsForfait fraisDetails) {
        FraisHorsForfait existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Frais hors forfait non trouvé avec l’ID : " + id));
    
        existing.setDate(fraisDetails.getDate());
        existing.setMontant(fraisDetails.getMontant());
        existing.setTypeFrais(fraisDetails.getTypeFrais());
        existing.setDescription(fraisDetails.getDescription());
    
        return repository.save(existing);
    }

    public FraisHorsForfait getById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Frais hors forfait non trouvé avec l'ID : " + id));
}

public Object updateFraisHorsForfait(Long id, FraisHorsForfait fraisDetails) {
    FraisHorsForfait existing = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Frais hors forfait non trouvé avec l’ID : " + id));

    // 💡 Mise à jour des champs
    existing.setDate(fraisDetails.getDate());
    existing.setMontant(fraisDetails.getMontant());
    existing.setTypeFrais(fraisDetails.getTypeFrais());
    existing.setDescription(fraisDetails.getDescription());

    // ✅ Vérification si on peut rebasculer en frais forfait
    if (peutAllerDansForfait(existing)) {
        // 1. On supprime de hors forfait
        repository.deleteById(id);

        // 2. On crée un nouveau frais forfait
        FraisForfait nouveau = new FraisForfait();
        nouveau.setDate(existing.getDate());
        nouveau.setMontant(existing.getMontant());
        nouveau.setTypeFrais(existing.getTypeFrais());
        nouveau.setDescription(existing.getDescription());
        nouveau.setVisiteur(existing.getVisiteur());

        fraisForfaitRepository.save(nouveau);
        return nouveau; // ↩️ on retourne le nouveau forfait
    }

    // Sinon, on reste dans hors forfait
    return repository.save(existing);
}

private boolean peutAllerDansForfait(FraisHorsForfait f) {
    double montant = f.getMontant();
    String type = f.getTypeFrais();

    return switch (type) {
        case "Nuitée" -> montant <= 100;
        case "Repas midi" -> montant <= 25;
        case "Relais étape" -> montant <= 140;
        case "Kilométrage" -> false; // ne devrait jamais être hors forfait
        case "Hors forfait" -> false;
        default -> false;
    };
}


}
