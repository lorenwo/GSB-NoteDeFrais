package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Visiteur;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {

    // 🔎 Recherche par login uniquement
    Optional<Visiteur> findByLogin(String login);

    @Query("SELECT v FROM Visiteur v WHERE v.id NOT IN (SELECT DISTINCT f.visiteur.id FROM FraisHorsForfait f)")
    List<Visiteur> findVisiteursSansFraisHorsForfait();
}
