package com.example.demo.controller;

import com.example.demo.entity.FraisHorsForfait;
import com.example.demo.service.FraisHorsForfaitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraisHorsForfait")
@CrossOrigin(origins = "http://localhost:4200")
public class FraisHorsForfaitController {

    private final FraisHorsForfaitService service;

    public FraisHorsForfaitController(FraisHorsForfaitService service) {
        this.service = service;
    }

    @GetMapping("/visiteur/{id}")
    public List<FraisHorsForfait> getByVisiteur(@PathVariable Long id) {
        return service.getByVisiteurId(id);
    }

    @GetMapping("/{id}")
public ResponseEntity<FraisHorsForfait> getFraisHorsForfaitById(@PathVariable Long id) {
    FraisHorsForfait frais = service.getById(id);
    return ResponseEntity.ok(frais);
}


    @PostMapping
    public FraisHorsForfait create(@RequestBody FraisHorsForfait f) {
        return service.save(f);
    }

@PutMapping("/{id}")
public ResponseEntity<?> updateFraisHorsForfait(@PathVariable Long id, @RequestBody FraisHorsForfait f) {
    Object result = service.updateFraisHorsForfait(id, f);
    return ResponseEntity.ok(result);
}


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deleted = service.deleteById(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
