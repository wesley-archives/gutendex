package com.wesleybertipaglia.gutendex.controllers;

import com.wesleybertipaglia.gutendex.models.Book;
import com.wesleybertipaglia.gutendex.models.Response;
import com.wesleybertipaglia.gutendex.services.GutendexService;

public class GutendexController {

    private final GutendexService gutendexService;

    public GutendexController() {
        this.gutendexService = new GutendexService();
    }

    public Response<Book> search(String query) {
        try {
            Response<Book> response = gutendexService.search(query);
            if (response == null || response.getResults() == null) {
                throw new Exception("No data returned from Gutendex API.");
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
