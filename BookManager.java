import java.util.Scanner;

public class BookManager {
    public static void main(String[] args) {
       
        String[] books = {
            "The Great Gatsby",
            "To Kill a Mockingbird",
            "1984",
            "The Catcher in the Rye",
            "The Hobbit",
            "Pride and Prejudice",
            "Brave New World",
            "The Lord of the Rings",
            "Fahrenheit 451",
            "Animal Farm"
        };

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Book Management System!");

      
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. View all books");
            System.out.println("2. Search for a book");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    
                    System.out.println("\n--- List of Books ---");
                    for (int i = 0; i < books.length; i++) {
                        System.out.println((i + 1) + ". " + books[i]);
                    }
                    break;

                case 2:
                    
                    System.out.print("\nEnter the book title (or part of it) to search: ");
                    String searchQuery = scanner.nextLine().trim();
                    boolean found = false;

                    System.out.println("\nSearch Results:");
                    for (String book : books) {
                        
                        if (book.toLowerCase().contains(searchQuery.toLowerCase())) {
                            System.out.println("- " + book);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No books found matching \"" + searchQuery + "\".");
                    }
                    break;

                case 3:
                   
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1, 2, or 3.");
            }
        }
        
      
    }
}