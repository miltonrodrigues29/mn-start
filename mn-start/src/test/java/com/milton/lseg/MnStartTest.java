package com.milton.lseg;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class HelloWorldControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void helloWorldEndpointTest() {
        var response = client.toBlocking().retrieve("/hello");
        assertEquals("Hello from Service", response);
    }

    @Test
    void helloWorldEndPointRespondWithProperStatusCodeAndContext() {
        var response = client.toBlocking().exchange("/hello", String.class);
        assertEquals("Hello from Service", response.getBody().get());
        assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void helloFromConfigEndpointReturnMessageFromConfig() {
        var response = client.toBlocking().exchange("/hello/config", String.class);
        assertEquals("Hello from application.yml", response.getBody().get());
        assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void helloFromConfigTranslation() {
        var response = client.toBlocking().exchange("/hello/config/translation", String.class);
        assertEquals("Hallo Welt", response.getBody().get());
        assertEquals(HttpStatus.OK, response.getStatus());
    }

}
