package com.gederin.providers.controller;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class HelloControllerTest {
    @Inject
    private EmbeddedServer server;

    @Inject
    @Client("/")
    private HttpClient client;

    @Test
    void testHelloWorldResponse() {
        String response = client.toBlocking()
                .retrieve(HttpRequest.GET("/hello"));

        assertEquals("Hello World from micronaut framework", response);
    }
}