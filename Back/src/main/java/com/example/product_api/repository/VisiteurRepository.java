package com.example.product_api.repository;
import com.example.product_api.model.Visiteur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {
}
