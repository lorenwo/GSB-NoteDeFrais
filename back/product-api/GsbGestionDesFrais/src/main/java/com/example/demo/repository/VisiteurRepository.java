package com.example.demo.repository;
import com.example.demo.entity.Visiteur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {
}
