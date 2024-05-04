package com.cursoalura.actividadlibros.modulos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectionApi {
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse response;

    public ConectionApi() {
        client = HttpClient.newHttpClient();
    }

    public String consultar(String url) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body().toString();
    }
}

