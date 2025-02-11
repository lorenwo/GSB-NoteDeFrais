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

    public List<Visiteur> getAllVisiteurs() { //on recupere la list de visiteur du repository
        return visiteurRepository.findAll();
    }

    public Visiteur getVisiteurById(Long id) { //On recupere les visiteurs par leur ID 
        return visiteurRepository.findById(id).orElse(null);
    }

    public Visiteur createVisiteur(Visiteur visiteur) { //Creation d'un visiteur 
        return visiteurRepository.save(visiteur);
    }

    public boolean verifieMdp(String mdp) {
        return mdp != null && mdp.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
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
}
