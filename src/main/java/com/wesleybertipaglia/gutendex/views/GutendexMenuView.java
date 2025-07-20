package com.wesleybertipaglia.gutendex.views;

import java.util.Scanner;

import com.wesleybertipaglia.gutendex.controllers.GutendexController;
import com.wesleybertipaglia.gutendex.models.Author;
import com.wesleybertipaglia.gutendex.models.Book;
import com.wesleybertipaglia.gutendex.models.Response;
import com.wesleybertipaglia.gutendex.utils.ScreenUtil;

public class GutendexMenuView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GutendexController gutendexController = new GutendexController();

    public static void main(String[] args) {
        ScreenUtil.clearScreen();

        while (true) {
            showMenu();
            String choice = scanner.nextLine();
            handleChoice(choice);
        }
    }

    private static void showMenu() {
        System.out.println("-------------------------------------");
        System.out.println("\n📚 GUTENDEX SEARCH MENU\n");
        System.out.println("-------------------------------------");
        System.out.println("1. Search for books or authors");
        System.out.println("0. Exit");
        System.out.print("\nChoose an option: ");
    }

    private static void handleChoice(String choice) {
        switch (choice) {
            case "1" -> search();
            case "0" -> exitProgram();
            default -> System.out.println("\n⚠️ Invalid option. Please try again.");
        }
    }

    private static void search() {
        System.out.print("\n🔎 Enter search term (title or author): ");
        String query = scanner.nextLine();

        Response<Book> response = gutendexController.search(query);

        if (response == null || response.getResults().isEmpty()) {
            System.out.println("❌ No results found.");
            return;
        }

        System.out.println("\n✅ Found " + response.getResults().size() + " book(s):\n");

        for (Book book : response.getResults()) {
            System.out.println("📖 Title: " + book.getTitle());
            System.out.println("✍️  Author(s):");

            for (Author author : book.getAuthors()) {
                String years = (author.getBirth_year() != 0 || author.getDeath_year() != 0)
                        ? " (" + author.getBirth_year() + " - " + author.getDeath_year() + ")"
                        : "";
                System.out.println("   - " + author.getName() + years);
            }
            System.out.println("\n------");
        }
    }

    private static void exitProgram() {
        System.out.println("\n👋 Exiting... Goodbye!");
        scanner.close();
        System.exit(0);
    }
}