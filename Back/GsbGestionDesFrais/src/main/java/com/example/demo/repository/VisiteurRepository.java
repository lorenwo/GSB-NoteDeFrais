package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Visiteur;
public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {
    Optional<Visiteur> findByLoginAndMdp(String login, String mdp);
}