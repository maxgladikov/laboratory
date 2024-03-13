package org.aston.ems.admin_service.service;

import org.aston.ems.admin_service.ApplicationTestNoJpa;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.aston.ems.admin_service.TestFactory.USER;

class JwtServiceTest extends ApplicationTestNoJpa {

    @Autowired
    private JwtService service;

    @Test
    void shouldGenerateToken(){
        String result = service.generateToken(USER);
        assertNotNull(result);
    }

}