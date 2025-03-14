package com.example.demo.controller;

import com.example.demo.entity.FraisForfait;
import com.example.demo.service.FraisForfaitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraisForfait")
public class FraisForfaitController {

    private final FraisForfaitService fraisForfaitService;

    public FraisForfaitController(FraisForfaitService fraisForfaitService) {
        this.fraisForfaitService = fraisForfaitService;
    }

    @GetMapping
    public List<FraisForfait> getAllFraisForfait() {
        return fraisForfaitService.getAllFraisForfait();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraisForfait> getFraisForfaitById(@PathVariable Long id_FraisForfait) {
        FraisForfait FraisForfait = fraisForfaitService.getFraisForfaitById(id_FraisForfait);
        return FraisForfait != null ? ResponseEntity.ok(FraisForfait) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FraisForfait> createFraisForfait(@RequestBody FraisForfait fraisForfait) {
        FraisForfait createdFraisForfait = fraisForfaitService.createFraisForfait(fraisForfait);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFraisForfait);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FraisForfait> updateFraisForfait(@PathVariable Long id_FraisForfait, @RequestBody FraisForfait FraisForfaitDetails) {
        FraisForfait updatedFraisForfait = fraisForfaitService.updateFraisForfait(id_FraisForfait, FraisForfaitDetails);
        return updatedFraisForfait != null ? ResponseEntity.ok(updatedFraisForfait) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFraisForfait(@PathVariable Long id_FraisForfait) {
        fraisForfaitService.deleteFraisForfait(id_FraisForfait);
        return ResponseEntity.noContent().build();
    }
}
