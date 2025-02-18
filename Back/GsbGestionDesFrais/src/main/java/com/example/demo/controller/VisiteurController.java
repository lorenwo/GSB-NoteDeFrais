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

import com.example.demo.entity.Visiteur;
import com.example.demo.service.VisiteurService;

@RestController
@RequestMapping("/api/visiteur")
@CrossOrigin(origins = "http://localhost:4200") // ✅ Gère les problèmes CORS
public class VisiteurController {

    private final VisiteurService visiteurService;

    public VisiteurController(VisiteurService visiteurService) {
        this.visiteurService = visiteurService;
    }

    @GetMapping
    public ResponseEntity<List<Visiteur>> getAllVisiteurs() {
        List<Visiteur> visiteurs = visiteurService.getAllVisiteurs();
        return ResponseEntity.ok(visiteurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visiteur> getVisiteurById(@PathVariable("id") Long id) {
        Visiteur visiteur = visiteurService.getVisiteurById(id);
        return visiteur != null ? ResponseEntity.ok(visiteur) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Visiteur> createVisiteur(@RequestBody Visiteur visiteur) {
        Visiteur createdVisiteur = visiteurService.createVisiteur(visiteur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVisiteur);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Visiteur visiteur) {
        Visiteur authenticatedVisiteur = visiteurService.authenticate(visiteur.getLogin(), visiteur.getMdp());
        if (authenticatedVisiteur != null) {
            return ResponseEntity.ok(authenticatedVisiteur);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants invalides");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Visiteur> updateVisiteur(@PathVariable("id") Long id, @RequestBody Visiteur visiteurDetails) {
        Visiteur updatedVisiteur = visiteurService.updateVisiteur(id, visiteurDetails);
        return updatedVisiteur != null ? ResponseEntity.ok(updatedVisiteur) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisiteur(@PathVariable("id") Long id) {
        visiteurService.deleteVisiteur(id);
        return ResponseEntity.noContent().build();
    }
}