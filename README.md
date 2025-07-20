# Gutendex Book Search

A simple Java console application to search for books and authors using the [Gutendex API](https://gutendex.com/). This project was created as a learning tool to practice HTTP requests, JSON handling, and building a structured CLI (command-line interface) app with Java.

## Table of Contents
- [Features](#features)
- [Get Started](#get-started)
- [Usage Example](#usage-example)
- [Contributing](#contributing)
- [License](#license)

## Features

- Search for books or authors using the Gutendex API
- Interactive and user-friendly console menu
- Clean and modular Java code (MVC pattern)
- HTTP client using `java.net.http.HttpClient`
- JSON parsing with Gson

## Get Started

### Prerequisites
- Java 21+
- Maven

### Running the project

1. Clone the repository

```bash
git clone https://github.com/wesley-archives/gutendex-book-search.git
```

2. Navigate to the project directory

```bash
cd gutendex-book-search
```

3. Build the project

```bash
mvn clean install
```

4. Run the app

```bash
mvn exec:java -Dexec.mainClass="com.wesleybertipaglia.gutendex.views.GutendexMenuView"
```

## Usage Example

```bash
-------------------------------------
📚 GUTENDEX SEARCH MENU
-------------------------------------

1. Search for books or authors
0. Exit

Choose an option: 1

🔎 Enter search term (title or author): sherlock holmes

✅ Found 5 book(s):

📖 Title: The Adventures of Sherlock Holmes
✍️  Author(s):
   - Arthur Conan Doyle (1859 - 1930)
------
📖 Title: A Study in Scarlet
✍️  Author(s):
   - Arthur Conan Doyle (1859 - 1930)
------
...
```

## Contributing

Contributions are welcome! If you have any suggestions, bug reports, or improvements, feel free to open an issue or a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
