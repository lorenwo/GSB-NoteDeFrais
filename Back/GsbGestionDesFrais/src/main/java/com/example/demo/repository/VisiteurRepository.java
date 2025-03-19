package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Visiteur;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {

    // ✅ Utilisation d'une requête JPQL pour assurer la validité
    @Query("SELECT v FROM Visiteur v WHERE v.login = :login AND v.mdp = :mdp")
    Optional<Visiteur> findByLoginAndMdp(@Param("login") String login, @Param("mdp") String mdp);
}
