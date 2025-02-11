package com.example.demo.repository;
import com.example.demo.entity.Visiteur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long>{
   Optional<Visiteur> findByMdp(String mdp); 
}
