package com.example.demo.repository;
import com.example.demo.entity.Etat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatRepository extends JpaRepository<Etat, Long> {
}
