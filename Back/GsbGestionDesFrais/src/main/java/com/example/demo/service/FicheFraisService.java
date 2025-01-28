package com.example.demo.service;
import com.example.demo.entity.FicheFrais;
import com.example.demo.repository.FicheFraisRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FicheFraisService {

    private final FicheFraisRepository ficheFraisRepository;

    public FicheFraisService(FicheFraisRepository ficheFraisRepository) {
        this.ficheFraisRepository = ficheFraisRepository;
    }

    public List<FicheFrais> getAllFicheFrais() { // on recupere FicheFrais de repository
        return ficheFraisRepository.findAll();
    }

    public FicheFrais getFicheFraisById(Long id) { // on recupere FicheFrias par l'ID
        return ficheFraisRepository.findById(id).orElse(null);
    }

    public FicheFrais createFicheFrais(FicheFrais ficheFrais) { // on crée une FicheFrais
        return ficheFraisRepository.save(ficheFrais);
    }

    public FicheFrais updateFicheFrais(Long id, FicheFrais ficheFraisDetails) { // on ameliore 
        FicheFrais ficheFrais = getFicheFraisById(id);
        if (ficheFrais != null) {
            ficheFrais.setNbJustificatifs(ficheFraisDetails.getNbJustificatifs());
            ficheFrais.setMontantValide(ficheFraisDetails.getMontantValide());
            ficheFrais.setDateModif(ficheFraisDetails.getDateModif());
            return ficheFraisRepository.save(ficheFrais);
        }
        return null;
    }

    public void deleteFicheFrais(Long id) { // on supprime une ficheFrais
        ficheFraisRepository.deleteById(id);
    }
}
