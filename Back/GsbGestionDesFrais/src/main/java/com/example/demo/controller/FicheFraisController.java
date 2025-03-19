package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FicheFrais;
import com.example.demo.service.FicheFraisService;

@RestController
@RequestMapping("/api/ficheFrais")
@CrossOrigin(origins = "http://localhost:4200") // ✅ Gère les problèmes CORS
public class FicheFraisController {

    private final FicheFraisService ficheFraisService;

    public FicheFraisController(FicheFraisService ficheFraisService) {
        this.ficheFraisService = ficheFraisService;
    }

    // ✅ Récupération de toutes les fiches de frais
    @GetMapping
    public List<FicheFrais> getAllFicheFrais() {
        List<FicheFrais> ficheFraisList = ficheFraisService.getAllFicheFrais();
    
        // ✅ Log pour voir le JSON renvoyé
        ficheFraisList.forEach(f -> {
            System.out.println("ID Visiteur: " + (f.getVisiteur() != null ? f.getVisiteur().getId() : "null"));
            System.out.println("Type de Frais: " + f.getType());
            System.out.println("Description: " + f.getDescription());
            System.out.println("Date: " + f.getDateModif());
            System.out.println("Montant: " + f.getMontantValide());
        });
    
        return ficheFraisList;
    }
    

    // ✅ Récupération d'une fiche par ID
    @GetMapping("/{id}")
    public ResponseEntity<FicheFrais> getFicheFraisById(@PathVariable Long id) {
        FicheFrais ficheFrais = ficheFraisService.getFicheFraisById(id);
        return ficheFrais != null ? ResponseEntity.ok(ficheFrais) : ResponseEntity.notFound().build();
    }

    // ✅ Création d'une fiche de frais
    @PostMapping
    public ResponseEntity<FicheFrais> createFicheFrais(@RequestBody FicheFrais ficheFrais) {
        try {
            FicheFrais createdFicheFrais = ficheFraisService.createFicheFrais(ficheFrais);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFicheFrais);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // ✅ Mise à jour d'une fiche de frais
    @PutMapping("/{id}")
    public ResponseEntity<FicheFrais> updateFicheFrais(@PathVariable Long id, @RequestBody FicheFrais ficheFrais) {
        FicheFrais updatedFicheFrais = ficheFraisService.updateFicheFrais(id, ficheFrais);
        return updatedFicheFrais != null ? ResponseEntity.ok(updatedFicheFrais) : ResponseEntity.notFound().build();
    }

    // ✅ Suppression d'une fiche de frais
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFicheFrais(@PathVariable Long id) {
        ficheFraisService.deleteFicheFrais(id);
        return ResponseEntity.noContent().build();
    }
}
