package com.example.demo.controller;
import com.example.demo.entity.Etat;
import com.example.demo.service.EtatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etat")
public class EtatController {

    private final EtatService etatService;

    public EtatController(EtatService etatService) {
        this.etatService = etatService;
    }

    @GetMapping
    public List<Etat> getAllEtats() {
        return etatService.getAllEtats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etat> getEtatById(@PathVariable Long id) {
        Etat etat = etatService.getEtatById(id);
        return etat != null ? ResponseEntity.ok(etat) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Etat> createEtat(@RequestBody Etat etat) {
        Etat createdEtat = etatService.createEtat(etat);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEtat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etat> updateEtat(@PathVariable Long id, @RequestBody Etat etatDetails) {
        Etat updatedEtat = etatService.updateEtat(id, etatDetails);
        return updatedEtat != null ? ResponseEntity.ok(updatedEtat) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisiteur(@PathVariable Long id) {
        etatService.deleteEtat(id);
        return ResponseEntity.noContent().build();
    }
}
