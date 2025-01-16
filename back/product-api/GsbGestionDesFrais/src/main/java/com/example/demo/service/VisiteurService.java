package com.example.demo.service;
import com.example.demo.entity.Visiteur;
import com.example.demo.repository.VisiteurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisiteurService {

    private final VisiteurRepository visiteurRepository;

    public VisiteurService(VisiteurRepository visiteurRepository) {
        this.visiteurRepository = visiteurRepository;
    }

    public List<Visiteur> getAllVisiteurs() {
        return visiteurRepository.findAll();
    }

    public Visiteur getVisiteurById(Long id) {
        return visiteurRepository.findById(id).orElse(null);
    }

    public Visiteur createVisiteur(Visiteur visiteur) {
        return visiteurRepository.save(visiteur);
    }

    public Visiteur updateVisiteur(Long id, Visiteur visiteurDetails) {
        Visiteur visiteur = getVisiteurById(id);
        if (visiteur != null) {
            visiteur.setNom(visiteurDetails.getNom());
            visiteur.setPrenom(visiteurDetails.getPrenom());
            visiteur.setAdresse(visiteurDetails.getadresse());
            visiteur.setCp(visiteurDetails.getCp());
            visiteur.setDateEmbauche(visiteurDetails.getDateEmbauche());
            visiteur.setLogin(visiteurDetails.getLogin());
            visiteur.setMdp(visiteurDetails.getMdp());
            return visiteurRepository.save(visiteur);
        }
        return null;
    }

    public void deleteVisiteur(Long id) {
        visiteurRepository.deleteById(id);
    }
}
