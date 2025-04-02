package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FraisForfait;

public interface FraisForfaitRepository extends JpaRepository<FraisForfait, Long> {
    List<FraisForfait> findByVisiteurId(Long visiteurId); // 🔥 AJOUT
}
