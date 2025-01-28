package com.example.demo.service;
import com.example.demo.entity.Etat;
import com.example.demo.repository.EtatRepository ;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtatService {

    private final EtatRepository etatRepository;

    public EtatService(EtatRepository etatRepository) {
        this.etatRepository = etatRepository;
    }

    public List<Etat> getAllEtats() { // on recupere la liste de tout les Etats
        return etatRepository.findAll();
    }

    public Etat getEtatById(Long id) { // on recupere les Etats par l'ID 
        return etatRepository.findById(id).orElse(null);
    }

    public Etat createEtat(Etat etat) { // on crée un Etat
        return etatRepository.save(etat);
    }

    public Etat updateEtat(Long id, Etat etatDetails) { // on améliore 
        Etat etat = getEtatById(id);
        if (etat != null) {
            etat.setLibelle(etatDetails.getLibelle());
            return etatRepository.save(etat);
        }
        return null;
    }

    public void deleteEtat(Long id) { // on supprime un Etat
        etatRepository.deleteById(id);
    }
}
