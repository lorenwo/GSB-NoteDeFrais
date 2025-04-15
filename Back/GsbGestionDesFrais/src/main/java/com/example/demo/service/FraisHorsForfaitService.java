package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.FraisHorsForfait;
import com.example.demo.repository.FraisHorsForfaitRepository;

@Service
public class FraisHorsForfaitService {

    private final FraisHorsForfaitRepository repository;

    public FraisHorsForfaitService(FraisHorsForfaitRepository repository) {
        this.repository = repository;
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

}
