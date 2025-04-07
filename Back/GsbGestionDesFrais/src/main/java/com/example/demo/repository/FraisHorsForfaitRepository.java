package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FraisHorsForfait;

public interface FraisHorsForfaitRepository extends JpaRepository<FraisHorsForfait, Long> {
    List<FraisHorsForfait> findByVisiteurId(Long visiteurId);
}
