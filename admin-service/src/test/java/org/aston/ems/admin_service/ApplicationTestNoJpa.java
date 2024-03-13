package org.aston.ems.admin_service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test_no_jpa")
//@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
public class ApplicationTestNoJpa {


    @BeforeAll
    static void setUp(){
    }

    @AfterAll
    static void tearDown(){
    }


}
