package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Visiteur;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {

    // 🔎 Recherche par login uniquement
    Optional<Visiteur> findByLogin(String login);

    // ❌ Supprimé : on n'utilise plus la recherche par login + mdp
    // @Query("SELECT v FROM Visiteur v WHERE v.login = :login AND v.mdp = :mdp")
    // Optional<Visiteur> findByLoginAndMdp(@Param("login") String login, @Param("mdp") String mdp);

    @Query("SELECT v FROM Visiteur v WHERE v.id NOT IN (SELECT DISTINCT f.visiteur.id FROM FraisHorsForfait f)")
    List<Visiteur> findVisiteursSansFraisHorsForfait();
}
