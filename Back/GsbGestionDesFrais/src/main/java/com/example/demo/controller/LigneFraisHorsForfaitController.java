package com.example.demo.controller;

import com.example.demo.entity.LigneFraisHorsForfait;
import com.example.demo.service.LigneFraisHorsForfaitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ligneFraisHorsForfait")
public class LigneFraisHorsForfaitController {

    private final LigneFraisHorsForfaitService ligneFraisHorsForfaitService;

    public LigneFraisHorsForfaitController(LigneFraisHorsForfaitService ligneFraisHorsForfaitService) {
        this.ligneFraisHorsForfaitService = ligneFraisHorsForfaitService;
    }

    @GetMapping
    public List<LigneFraisHorsForfait> getAllLigneFraisHorsForfaits() {
        return ligneFraisHorsForfaitService.getAllLigneFraisHorsForfaits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneFraisHorsForfait> getLigneFraisHorsForfaitById(@PathVariable Long id_LigneFraisHorsForfait) {
        LigneFraisHorsForfait LigneFraisHorsForfait = ligneFraisHorsForfaitService.getLigneFraisHorsForfaitById(id_LigneFraisHorsForfait);
        return LigneFraisHorsForfait != null ? ResponseEntity.ok(LigneFraisHorsForfait) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<LigneFraisHorsForfait> createLigneFraisHorsForfait(@RequestBody LigneFraisHorsForfait LigneFraisHorsForfait) {
        LigneFraisHorsForfait createdLigneFraisHorsForfait = ligneFraisHorsForfaitService.createLigneFraisHorsForfait(LigneFraisHorsForfait);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLigneFraisHorsForfait);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LigneFraisHorsForfait> updateLigneFraisHorsForfait(@PathVariable Long id_LigneFraisHorsForfait, @RequestBody LigneFraisHorsForfait ligneFraisHorsForfaitDetails) {
        LigneFraisHorsForfait updatedLigneFraisHorsForfait = ligneFraisHorsForfaitService.updateLigneFraisHorsForfait(id_LigneFraisHorsForfait, ligneFraisHorsForfaitDetails);
        return updatedLigneFraisHorsForfait != null ? ResponseEntity.ok(updatedLigneFraisHorsForfait) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLigneFraisHorsForfait(@PathVariable Long id_LigneFraisHorsForfait) {
        ligneFraisHorsForfaitService.deleteLigneFraisHorsForfait(id_LigneFraisHorsForfait);
        return ResponseEntity.noContent().build();
    }
}
