package com.example.product_api.service;
import com.example.product_api.model.Visiteur;
import com.example.product_api.repository.VisiteurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EatService {

    private final EatRepository EatRepository;

    public EatService(EatRepository EatRepository) {
        this.EatRepository = EatRepository;
    }

    public List<Eat> getAllEats() {
        return EatRepository.findAll();
    }

    public Eat getEatById(Long id) {
        return EatRepository.findById(id).orElse(null);
    }

    public Eat createEat(Eat Eat) {
        return EatRepository.save(Eat);
    }

    public Eat updateEat(Long id, Eat EatDetails) {
        Eat Eat = getEatById(id);
        if (Eat != null) {
            Eat.setNom(EatDetails.getNom());
            Eat.setPrenom(EatDetails.getPrenom());
            Eat.setAdresse(EatDetails.getadresse());
            Eat.setCp(EatDetails.getCp());
            Eat.setDateEmbauche(EatDetails.getDateEmbauche());
            Eat.setLogin(EatDetails.getLogin());
            Eat.setMdp(EatDetails.getMdp());
            return EatRepository.save(Eat);
        }
        return null;
    }

    public void deleteEat(Long id) {
        EatRepository.deleteById(id);
    }
}
