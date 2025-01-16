package com.example.demo.controller;

import com.example.demo.entity.FicheFrais;
import com.example.demo.service.FicheFraisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ficheFrais")
public class FicheFraisController {

    private final FicheFraisService ficheFraisService;

    public FicheFraisController(FicheFraisService ficheFraisService) {
        this.ficheFraisService = ficheFraisService;
    }

    @GetMapping
    public List<FicheFrais> getAllFicheFrais() {
        return ficheFraisService.getAllFicheFrais();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FicheFrais> getFicheFraisById(@PathVariable Long id_FicheFrais) {
        FicheFrais FicheFrais = ficheFraisService.getFicheFraisById(id_FicheFrais);
        return FicheFrais != null ? ResponseEntity.ok(FicheFrais) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FicheFrais> createFicheFrais(@RequestBody FicheFrais ficheFrais) {
        FicheFrais createdFicheFrais = ficheFraisService.createFicheFrais(ficheFrais);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFicheFrais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FicheFrais> updateFicheFrais(@PathVariable Long id_FicheFrais, @RequestBody FicheFrais ficheFraisDetails) {
        FicheFrais updatedFicheFrais = ficheFraisService.updateFicheFrais(id_FicheFrais, ficheFraisDetails);
        return updatedFicheFrais != null ? ResponseEntity.ok(updatedFicheFrais) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFicheFrais(@PathVariable Long id_FicheFrais) {
        ficheFraisService.deleteFicheFrais(id_FicheFrais);
        return ResponseEntity.noContent().build();
    }
}
