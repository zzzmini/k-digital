package com.my.jpaTest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CascadeServiceTest {
    @Autowired
    CascadeService cascadeService;

    @Test
    void saveCascade() {
        cascadeService.saveCascade();
    }

    @Test
    void deleteCascade() {
        cascadeService.deleteCascade();
    }
}