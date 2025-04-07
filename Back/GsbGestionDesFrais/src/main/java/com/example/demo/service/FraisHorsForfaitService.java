package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.FraisHorsForfait;
import com.example.demo.repository.FraisHorsForfaitRepository;

@Service
public class FraisHorsForfaitService {

    private final FraisHorsForfaitRepository repository;

    public FraisHorsForfaitService(FraisHorsForfaitRepository repository) {
        this.repository = repository;
    }

    public List<FraisHorsForfait> getByVisiteurId(Long id) {
        return repository.findByVisiteurId(id);
    }

    public FraisHorsForfait save(FraisHorsForfait f) {
        return repository.save(f);
    }

    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
