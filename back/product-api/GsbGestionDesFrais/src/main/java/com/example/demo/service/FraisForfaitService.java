package com.example.demo.service;
import com.example.demo.entity.FraisForfait;
import com.example.demo.repository.FraisForfaitRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FraisForfaitService {

    private final FraisForfaitRepository fraisForfaitRepository;

    public FraisForfaitService(FraisForfaitRepository fraisForfaitRepository) {
        this.fraisForfaitRepository = fraisForfaitRepository;
    }

    public List<FraisForfait> getAllFraisForfait() {
        return fraisForfaitRepository.findAll();
    }

    public FraisForfait getFraisForfaitById(Long id) {
        return fraisForfaitRepository.findById(id).orElse(null);
    }

    public FraisForfait createFraisForfait(FraisForfait fraisForfait) {
        return fraisForfaitRepository.save(fraisForfait);
    }

    public FraisForfait updateFraisForfait(Long id, FraisForfait fraisForfaitDetails) {
        FraisForfait fraisForfait = getFraisForfaitById(id);
        if (fraisForfait != null) {
            fraisForfait.setLibelle(fraisForfaitDetails.getLibelle());
            fraisForfait.setMontant(fraisForfaitDetails.getMontant());
            return fraisForfaitRepository.save(fraisForfait);
        }
        return null;
    }

    public void deleteFraisForfait(Long id) {
        fraisForfaitRepository.deleteById(id);
    }
}
