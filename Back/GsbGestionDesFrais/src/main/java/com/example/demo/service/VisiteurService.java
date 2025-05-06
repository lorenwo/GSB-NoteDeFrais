package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Visiteur;
import com.example.demo.repository.VisiteurRepository;

@Service
public class VisiteurService {

    private final VisiteurRepository visiteurRepository;

    public VisiteurService(VisiteurRepository visiteurRepository) {
        this.visiteurRepository = visiteurRepository;
    }

    // ✅ Récupération de la liste de tous les visiteurs
    public List<Visiteur> getAllVisiteurs() {
        return visiteurRepository.findAll();
    }

    // ✅ Récupération d'un visiteur par ID
    public Visiteur getVisiteurById(Long id) {
        return visiteurRepository.findById(id).orElse(null);
    }

    // ✅ Création d'un visiteur
    public Visiteur createVisiteur(Visiteur visiteur) {
        return visiteurRepository.save(visiteur);
    }

    // ✅ Mise à jour d'un visiteur
    public Visiteur updateVisiteur(Long id, Visiteur visiteurDetails) {
        Visiteur visiteur = getVisiteurById(id);
        if (visiteur != null) {
            visiteur.setLogin(visiteurDetails.getLogin());
            visiteur.setMdp(visiteurDetails.getMdp());
            return visiteurRepository.save(visiteur);
        }
        return null;
    }

    // ✅ Suppression d'un visiteur par ID
    public void deleteVisiteur(Long id) {
        visiteurRepository.deleteById(id);
    }

    // ✅ Authentification d'un visiteur
    public Visiteur authenticate(String login, String mdp) {
        Optional<Visiteur> optionalVisiteur = visiteurRepository.findByLogin(login);
    
        if (optionalVisiteur.isPresent()) {
            Visiteur visiteur = optionalVisiteur.get();
            String hashedInputPassword = hashPassword(mdp);
            if (visiteur.getMdp().equals(hashedInputPassword)) {
                return visiteur;
            }
        }
    
        return null;
    }
    
    private String hashPassword(String password) {
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors du hachage du mot de passe", e);
        }
    }
    
}
