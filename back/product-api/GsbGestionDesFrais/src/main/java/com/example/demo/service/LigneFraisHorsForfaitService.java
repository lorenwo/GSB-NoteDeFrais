package com.example.demo.service;
import com.example.demo.entity.LigneFraisHorsForfait;
import com.example.demo.repository.LigneFraisHorsForfaitRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LigneFraisHorsForfaitService {

    private final LigneFraisHorsForfaitRepository ligneFraisHorsForfaitRepository;

    public LigneFraisHorsForfaitService(LigneFraisHorsForfaitRepository ligneFraisHorsForfaitRepository) {
        this.ligneFraisHorsForfaitRepository = ligneFraisHorsForfaitRepository;
    }

    public List<LigneFraisHorsForfait> getAllLigneFraisHorsForfaits() {
        return ligneFraisHorsForfaitRepository.findAll();
    }

    public LigneFraisHorsForfait getLigneFraisHorsForfaitById(Long id) {
        return ligneFraisHorsForfaitRepository.findById(id).orElse(null);
    }

    public LigneFraisHorsForfait createLigneFraisHorsForfait(LigneFraisHorsForfait LigneFraisHorsForfait) {
        return ligneFraisHorsForfaitRepository.save(LigneFraisHorsForfait);
    }

    public LigneFraisHorsForfait updateLigneFraisHorsForfait(Long id, LigneFraisHorsForfait ligneFraisHorsForfaitDetails) {
        LigneFraisHorsForfait ligneFraisHorsForfait = getLigneFraisHorsForfaitById(id);
        if (ligneFraisHorsForfait != null) {
            ligneFraisHorsForfait.setDate(ligneFraisHorsForfaitDetails.getDate());
            ligneFraisHorsForfait.setMontant(ligneFraisHorsForfaitDetails.getMontant());
            ligneFraisHorsForfait.setLibelle(ligneFraisHorsForfaitDetails.getLibelle());
            return ligneFraisHorsForfaitRepository.save(ligneFraisHorsForfait);
        }
        return null;
    }

    public void deleteLigneFraisHorsForfait(Long id) {
       ligneFraisHorsForfaitRepository.deleteById(id);
    }
}
