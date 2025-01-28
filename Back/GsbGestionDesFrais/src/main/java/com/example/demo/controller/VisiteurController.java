package com.example.demo.controller;

import com.example.demo.entity.Visiteur;
import com.example.demo.service.VisiteurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visiteur")
public class VisiteurController {

    private final VisiteurService visiteurService;

    public VisiteurController(VisiteurService visiteurService) {
        this.visiteurService = visiteurService;
    }

    @GetMapping
    public List<Visiteur> getAllVisiteurs() {
        return visiteurService.getAllVisiteurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visiteur> getVisiteurById(@PathVariable Long id_visiteur) {
        Visiteur visiteur = visiteurService.getVisiteurById(id_visiteur);
        return visiteur != null ? ResponseEntity.ok(visiteur) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Visiteur> createVisiteur(@RequestBody Visiteur visiteur) {
        Visiteur createdVisiteur = visiteurService.createVisiteur(visiteur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVisiteur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visiteur> updateVisiteur(@PathVariable Long id_visiteur, @RequestBody Visiteur visiteurDetails) {
        Visiteur updatedVisiteur = visiteurService.updateVisiteur(id_visiteur, visiteurDetails);
        return updatedVisiteur != null ? ResponseEntity.ok(updatedVisiteur) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisiteur(@PathVariable Long id_visiteur) {
        visiteurService.deleteVisiteur(id_visiteur);
        return ResponseEntity.noContent().build();
    }
}
