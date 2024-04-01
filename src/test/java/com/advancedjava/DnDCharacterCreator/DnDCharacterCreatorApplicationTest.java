package com.advancedjava.DnDCharacterCreator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.TestPropertySourceUtils;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = DnDCharacterCreatorApplicationTest.Initializer.class)
public class DnDCharacterCreatorApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Test
    public void testMain() {
        String port = applicationContext.getEnvironment().getProperty("local.server.port");
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/", String.class);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @TestConfiguration
    public static class TestConfig {

        @Bean
        public TestRestTemplate restTemplate() {
            return new TestRestTemplate();
        }
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                    configurableApplicationContext, "local.server.port=8080");
        }
    }
}