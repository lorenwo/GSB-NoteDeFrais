package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.VisiteurService;

@SpringBootTest
class VisiteurServiceTest {

    private final VisiteurService visiteurService = new VisiteurService(null);

    @Test
    void testVerifieMdp(){
        assertTrue(visiteurService.verifieMdp("Kyliann121105!"));
        assertFalse(visiteurService.verifieMdp("test1"));
    }
}
