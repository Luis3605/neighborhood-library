import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private final List<Book> inventory;

    public LibraryApp() {
        // Initialize inventory with at least 20 books
        inventory = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            inventory.add(new Book(i, "ISBN" + i, "Book Title " + i));
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the library!");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    showCheckedOutBooks();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : inventory) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
            }
        }

        System.out.println("Select a book to check out (enter book ID) or enter 0 to go back to the home screen:");
        Scanner scanner = new Scanner(System.in);
        int bookId = scanner.nextInt();

        if (bookId == 0) {
            return;
        }

        Book selectedBook = findBookById(bookId);
        if (selectedBook != null && !selectedBook.isCheckedOut()) {
            scanner.nextLine();
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            selectedBook.checkOut(name);
            System.out.println("Book checked out successfully to " + name);
        } else {
            System.out.println("Invalid book ID or the book is already checked out.");
        }
    }

    private void showCheckedOutBooks() {
        System.out.println("Checked Out Books:");
        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() +
                        ", Title: " + book.getTitle() + ", Checked Out To: " + book.getCheckedOutTo());
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Options:");
        System.out.println("C - Check In a book");
        System.out.println("X - Go back to the home screen");

        String option = scanner.nextLine();
        if (option.equalsIgnoreCase("C")) {
            System.out.print("Enter the ID of the book to check in: ");
            int bookId = scanner.nextInt();
            Book selectedBook = findBookById(bookId);
            if (selectedBook != null && selectedBook.isCheckedOut()) {
                selectedBook.checkIn();
                System.out.println("Book checked in successfully.");
            } else {
                System.out.println("Invalid book ID or the book is not checked out.");
            }
        } else if (option.equalsIgnoreCase("X")) {
            return;
        } else {
            System.out.println("Invalid option.");
        }
    }

    private Book findBookById(int id) {
        for (Book book : inventory) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryApp libraryApp = new LibraryApp();
        libraryApp.run();
    }
}
