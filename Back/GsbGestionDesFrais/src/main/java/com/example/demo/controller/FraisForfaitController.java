package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    // ✅ Récupération de tous les frais
    @GetMapping
    public ResponseEntity<List<FraisForfait>> getAllFraisForfait() {
        List<FraisForfait> fraisForfaits = fraisForfaitService.getAllFraisForfait();
        return ResponseEntity.ok(fraisForfaits);
    }

    // ✅ Création d'un nouveau frais
    @PostMapping
    public ResponseEntity<FraisForfait> createFraisForfait(@RequestBody FraisForfait fraisForfait) {
        FraisForfait createdFraisForfait = fraisForfaitService.createFraisForfait(fraisForfait);
        return ResponseEntity.ok(createdFraisForfait);
    }
}
