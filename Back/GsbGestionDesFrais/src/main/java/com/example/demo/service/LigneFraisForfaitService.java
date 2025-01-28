package com.example.demo.service;
import com.example.demo.entity.LigneFraisForfait;
import com.example.demo.repository.LigneFraisForfaitRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LigneFraisForfaitService {

    private final LigneFraisForfaitRepository ligneFraisForfaitRepository;

    public LigneFraisForfaitService(LigneFraisForfaitRepository ligneFraisForfaitRepository) {
        this.ligneFraisForfaitRepository = ligneFraisForfaitRepository;
    }

    public List<LigneFraisForfait> getAllLigneFraisForfait() { // on recupere LigneFraisForfait de repository
        return ligneFraisForfaitRepository.findAll();
    }

    public LigneFraisForfait getLigneFraisForfaitById(Long id) { // on recupere par l'ID
        return ligneFraisForfaitRepository.findById(id).orElse(null);
    }

    public LigneFraisForfait createLigneFraisForfait(LigneFraisForfait ligneFraisForfait) { // on crée une LIgneFraisForfait
        return ligneFraisForfaitRepository.save(ligneFraisForfait);
    }

    public LigneFraisForfait updateLigneFraisForfait(Long id, LigneFraisForfait ligneFraisForfaitDetails) { //on l'améliore
        LigneFraisForfait ligneFraisForfait = getLigneFraisForfaitById(id);
        if (ligneFraisForfait != null) {
            ligneFraisForfait.setMois(ligneFraisForfaitDetails.getMois());
            ligneFraisForfait.setQuantite(ligneFraisForfaitDetails.getQuantite());
            return ligneFraisForfaitRepository.save(ligneFraisForfait);
        }
        return null;
    }

    public void deleteLigneFraisForfait(Long id) { // on supprime une ligneFraisForfait par son ID
        ligneFraisForfaitRepository.deleteById(id);
    }
}
