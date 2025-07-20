package com.wesleybertipaglia.gutendex.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wesleybertipaglia.gutendex.models.Book;
import com.wesleybertipaglia.gutendex.models.Response;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GutendexService {
    private static final String BASE_URL = "https://gutendex.com/books/?search=";
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public Response<Book> search(String query) {
        try {
            String url = BASE_URL + query.replace(" ", "+");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            var responseType = new TypeToken<Response<Book>>() {
            }.getType();
            return gson.fromJson(response.body(), responseType);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
