package com.example.demo.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Visiteur;
import com.example.demo.repository.VisiteurRepository;

@Service
public class VisiteurService {

    private final VisiteurRepository visiteurRepository;

    public VisiteurService(VisiteurRepository visiteurRepository) {
        this.visiteurRepository = visiteurRepository;
    }

    public List<Visiteur> getAllVisiteurs() { //on recupere la list de visiteur du repository
        return visiteurRepository.findAll();
    }

    public Visiteur getVisiteurById(Long id) { //On recupere les visiteurs par leur ID 
        return visiteurRepository.findById(id).orElse(null);
    }

    public Visiteur createVisiteur(Visiteur visiteur) { //Creation d'un visiteur 
        return visiteurRepository.save(visiteur);
    }

    public Visiteur updateVisiteur(Long id, Visiteur visiteurDetails) { // amélioration d'un visiteur
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

    public void deleteVisiteur(Long id) { // suppression d'un visiteur 
        visiteurRepository.deleteById(id);
    }
    public Visiteur authenticate(String login, String mdp) {
        return visiteurRepository.findByLoginAndMdp(login, mdp).orElse(null);
    }
    
}