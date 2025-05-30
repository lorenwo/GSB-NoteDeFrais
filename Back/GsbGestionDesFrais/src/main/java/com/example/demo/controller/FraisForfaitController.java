package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entity.FraisForfait;
import com.example.demo.service.FraisForfaitService;

@RestController
@RequestMapping("/api/fraisForfait")
@CrossOrigin(origins = "http://localhost:4200")
public class FraisForfaitController {

    private final FraisForfaitService fraisForfaitService;

    public FraisForfaitController(FraisForfaitService fraisForfaitService) {
        this.fraisForfaitService = fraisForfaitService;
    }

    @GetMapping("/visiteur/{id}")
public ResponseEntity<List<FraisForfait>> getFraisByVisiteur(@PathVariable Long id) {
    List<FraisForfait> frais = fraisForfaitService.getFraisByVisiteurId(id);
    return ResponseEntity.ok(frais);
}

@GetMapping("/{id}")
public ResponseEntity<FraisForfait> getFraisById(@PathVariable Long id) {
    FraisForfait frais = fraisForfaitService.getFraisById(id);
    return ResponseEntity.ok(frais);
}

    // ✅ Création d'un nouveau frais
    @PostMapping
    public ResponseEntity<FraisForfait> createFraisForfait(@RequestBody FraisForfait fraisForfait) {
        FraisForfait createdFraisForfait = fraisForfaitService.createFraisForfait(fraisForfait);
        return ResponseEntity.ok(createdFraisForfait);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FraisForfait> updateFraisForfait(@PathVariable Long id, @RequestBody FraisForfait fraisDetails) {
    return ResponseEntity.ok(fraisForfaitService.updateFraisForfait(id, fraisDetails));
}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFraisForfait(@PathVariable Long id) {
        boolean deleted = fraisForfaitService.deleteFraisForfaitById(id);
        if (deleted) {
            return ResponseEntity.ok().body(null); // ✅ Retourne une réponse vide
        } else {
            return ResponseEntity.status(404).body("Frais non trouvé avec l'ID : " + id);
        }
    }
}
