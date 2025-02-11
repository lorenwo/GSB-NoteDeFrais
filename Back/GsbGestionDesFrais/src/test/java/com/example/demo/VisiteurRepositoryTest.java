package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Visiteur;
import com.example.demo.repository.VisiteurRepository;


@SpringBootTest(properties="Spring.config.name=application-test")
class VisiteurRepositoryTest {

    @Autowired
    private VisiteurRepository visiteurRepository;

    @Test
    void testFindByMdp() {
        // Sauvegarde d'un utilisateur
        Visiteur visiteur = new Visiteur("Test123!");
        visiteurRepository.save(visiteur);

        // Vérification de la présence de l'utilisateur
        assertTrue(visiteurRepository.findByMdp("Test123!").isPresent(),
                   "L'utilisateur doit exister");

        assertFalse(visiteurRepository.findByMdp("existePas123!").isPresent(),
                    "L'utilisateur ne doit pas exister");
    }
}

