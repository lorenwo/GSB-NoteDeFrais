package com.example.demo.controller;

import com.example.demo.entity.LigneFraisForfait;
import com.example.demo.service.LigneFraisForfaitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ligneFraisForfait")
public class LigneFraisForfaitController {

    private final LigneFraisForfaitService ligneFraisForfaitService;

    public LigneFraisForfaitController(LigneFraisForfaitService ligneFraisForfaitService) {
        this.ligneFraisForfaitService = ligneFraisForfaitService;
    }

    @GetMapping
    public List<LigneFraisForfait> getAllLigneFraisForfait() {
        return ligneFraisForfaitService.getAllLigneFraisForfait();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneFraisForfait> getLigneFraisForfaitById(@PathVariable Long id_LigneFraisForfait) {
        LigneFraisForfait LigneFraisForfait = ligneFraisForfaitService.getLigneFraisForfaitById(id_LigneFraisForfait);
        return LigneFraisForfait != null ? ResponseEntity.ok(LigneFraisForfait) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<LigneFraisForfait> createLigneFraisForfait(@RequestBody LigneFraisForfait ligneFraisForfait) {
        LigneFraisForfait createdLigneFraisForfait = ligneFraisForfaitService.createLigneFraisForfait(ligneFraisForfait);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLigneFraisForfait);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LigneFraisForfait> updateLigneFraisForfait(@PathVariable Long id_LigneFraisForfait, @RequestBody LigneFraisForfait LigneFraisForfaitDetails) {
        LigneFraisForfait updatedLigneFraisForfait = ligneFraisForfaitService.updateLigneFraisForfait(id_LigneFraisForfait, LigneFraisForfaitDetails);
        return updatedLigneFraisForfait != null ? ResponseEntity.ok(updatedLigneFraisForfait) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLigneFraisForfait(@PathVariable Long id_LigneFraisForfait) {
        ligneFraisForfaitService.deleteLigneFraisForfait(id_LigneFraisForfait);
        return ResponseEntity.noContent().build();
    }
}
