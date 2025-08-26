import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int year;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%d)", title, author, year);
    }
}

class Library {
    private final List<Book> books = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
        System.out.println("Book added: " + b);
    }

    void displayAll() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("\n--- All Books ---");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    void searchByTitle(String query) {
        String q = query.toLowerCase();
        boolean found = false;
        for (Book b : books) {
            if (b.title.toLowerCase().contains(q)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No matching title found.");
    }

    void removeByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).title.equalsIgnoreCase(title)) {
                Book removed = books.remove(i);
                System.out.println("Removed: " + removed);
                return;
            }
        }
        System.out.println("No book with that exact title.");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add new book");
            System.out.println("2. Display all books");
            System.out.println("3. Search a book by title");
            System.out.println("4. Remove a book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter year: ");
                    int year = Integer.parseInt(sc.nextLine());
                    lib.addBook(new Book(title, author, year));
                    break;
                case 2:
                    lib.displayAll();
                    break;
                case 3:
                    System.out.print("Enter title to search: ");
                    lib.searchByTitle(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter exact title to remove: ");
                    lib.removeByTitle(sc.nextLine());
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
