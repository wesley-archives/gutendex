package com.wesleybertipaglia.gutendex;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.wesleybertipaglia.gutendex.views.GutendexMenuView;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		GutendexMenuView.main(args);
	}
}
