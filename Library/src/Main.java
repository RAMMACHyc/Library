import classes.Book;
import classes.Emprunt;
import implementation.BookImpl;
import implementation.EmpruntImpl;
import implementation.EmprunteurImpl;
import classes.Emprunteur;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\u001B[90m");
        System.out.println("-----------------------------------------------");
        System.out.println("✎ Welcome to the Library Management System ✋");
        System.out.println("-----------------------------------------------");
        System.out.print("\u001B[0m");

        while (true) {
            System.out.print("\u001B[1m");
            System.out.print("\u001B[33m");
            System.out.println("      〖     Choose an option     〗");
            System.out.print("\u001B[0m");
            System.out.println("-----------------------------------------------");
            System.out.print("\u001B[32m");
            System.out.println("           【1】 Book Management");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[32m");
            System.out.println("           【2】 Emprunteur Management");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[32m");
            System.out.println("           【3】 Emprunt Management");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[31m");
            System.out.println("           【4】 Exit");
            System.out.print("\u001B[0m");

            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1 -> {
                    bookManagementLoop(scanner);
                }
                case 2 -> {
                    emprunteurManagementLoop(scanner);
                }
                case 3 -> manageBorrowings(scanner);

                case 4 -> {
                    System.out.println("Exiting program.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void bookManagementLoop(Scanner scanner) {
        BookImpl bookImpl = new BookImpl();

        while (true) {
            System.out.print("\u001B[1m");
            System.out.print("\u001B[33m");
            System.out.println("〖     Choose an option for Book Data     〗");
            System.out.print("\u001B[0m");
            System.out.println("-----------------------------------------------");
            System.out.print("\u001B[32m");
            System.out.println("           【1】 Insert Book");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[32m");
            System.out.println("           【2】 Display Books");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[32m");
            System.out.println("           【3】 Update Book ");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[32m");
            System.out.println("           【4】 Delete Book");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[32m");
            System.out.println("           【5】 Search Book");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[32m");
            System.out.println("           【6】 Statistics Books");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[31m");
            System.out.println("           【7】 Back to Main Menu");
            System.out.print("\u001B[0m");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("ISBN: ");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    Book bookToAdd = new Book(isbn, title, author, null);
                    bookImpl.add(bookToAdd);
                }
                case 3 -> {
                    System.out.print("Enter ISBN of the book to update: ");
                    int isbnToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("New Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("New Status: ");
                    String newStatus = scanner.nextLine();
                    Book bookToUpdate = new Book(isbnToUpdate, newTitle, newAuthor, newStatus);
                    boolean updated = bookImpl.update(bookToUpdate);
                    if (updated) {
                        System.out.println("Book updated successfully.");
                    } else {
                        System.out.println("Book not found or update failed.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter ISBN of the book to delete: ");
                    int isbnToDelete = scanner.nextInt();
                    scanner.nextLine();
                    boolean deleted = bookImpl.delete(isbnToDelete);
                    if (deleted) {
                        System.out.println("Book deleted successfully.");
                    } else {
                        System.out.println("Book not found or delete failed.");
                    }
                }
                case 2 -> {
                    List<Book> allBooks = bookImpl.show();
                    System.out.print("\u001B[90m");
                    System.out.println("-----------------------------------------------");
                    System.out.println("Books in the Library:");
                    System.out.println("-----------------------------------------------");
                    System.out.print("\u001B[0m");
                    for (Book book : allBooks) {
                        System.out.println("ISBN: " + book.getIsbn());
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Status: " + book.getStatus());
                        System.out.println();
                        System.out.print("\u001B[90m");
                        System.out.println("-----------------------------------------------");
                        System.out.print("\u001B[0m");
                    }
                }
                case 5 ->{
                        System.out.println("-----------------------------------------------");
                System.out.print("\u001B[90m");
                System.out.println("Choose an option for search:");
                System.out.println("-----------------------------------------------");
                System.out.print("\u001B[0m");
                System.out.print("\u001B[34m");
                System.out.println("1 ⃞  Search by Title");
                System.out.print("\u001B[0m");
                System.out.print("\u001B[90m");
                System.out.println("-----------------------------------------------");
                System.out.print("\u001B[0m");
                System.out.print("\u001B[34m");
                System.out.println("2 ⃞  Search by Author");
                System.out.print("\u001B[0m");
                System.out.print("\u001B[90m");
                System.out.println("-----------------------------------------------");
                System.out.print("\u001B[0m");
                int searchOption = scanner.nextInt();
                scanner.nextLine();

                switch (searchOption) {
                    case 1 -> {
                        System.out.println("Enter a title to search for:");
                        String searchTitle = scanner.nextLine();
                        List<Book> foundBooksByTitle = bookImpl.searchByTitle(searchTitle); // Pass the title as an argument
                        if (foundBooksByTitle.isEmpty()) {
                            System.out.println("No books found with the specified title.");
                        } else {
                            System.out.println("Books found with the specified title:");
                            System.out.print("\u001B[90m");
                            System.out.print("_______________________________________________\n");
                            System.out.print("\u001B[0m");
                            for (Book book : foundBooksByTitle) {
                                System.out.println("ISBN: " + book.getIsbn());
                                System.out.println("Title: " + book.getTitle());
                                System.out.println("Author: " + book.getAuthor());
                                System.out.println("Status: " + book.getStatus());
                                System.out.print("\u001B[90m");
                                System.out.print("_______________________________________________\n");
                                System.out.print("\u001B[0m");
                                System.out.println();
                            }
                        }
                        break;

                    }
                    case 2 -> {
                        System.out.println("Enter a author to search for:");
                        String searchAuthor = scanner.nextLine();
                        List<Book> foundBooksByAuthor = bookImpl.searchByAuthor(searchAuthor); // Pass the title as an argument
                        if (foundBooksByAuthor.isEmpty()) {
                            System.out.print("\u001B[90m");
                            System.out.print("_______________________________________________\n");
                            System.out.print("\u001B[0m");
                            System.out.print("\u001B[31m");
                            System.out.println("☠ No books found with the specified author");
                            System.out.print("\u001B[90m");
                            System.out.print("_______________________________________________\n");
                            System.out.print("\u001B[0m");
                        } else {
                            System.out.println("Books found with the specified author:");
                            System.out.print("\u001B[90m");
                            System.out.print("_______________________________________________\n");
                            System.out.print("\u001B[0m");
                            for (Book book : foundBooksByAuthor) {
                                System.out.println("ISBN: " + book.getIsbn());
                                System.out.println("Title: " + book.getTitle());
                                System.out.println("Author: " + book.getAuthor());
                                System.out.println("Status: " + book.getStatus());
                                System.out.print("\u001B[90m");
                                System.out.print("_______________________________________________\n");
                                System.out.print("\u001B[0m");
                                System.out.println();
                            }
                        }
                        break;

                    }
                }
                }
                case 6 -> {
                    System.out.println("Exiting book management.");
                    return;
                }
                case 7 -> {
                    System.out.println("Returning to the main menu.");
                    return; // Exit the book management loop and return to the main menu
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void emprunteurManagementLoop(Scanner scanner) {
        EmprunteurImpl emprunteurImpl = new EmprunteurImpl();

        while (true) {
            System.out.print("\u001B[1m");
            System.out.print("\u001B[33m");
            System.out.println("〖     Choose an option for Emprunteur Data     〗");
            System.out.print("\u001B[0m");
            System.out.println("-----------------------------------------------");
            System.out.print("\u001B[32m");
            System.out.println("           【1】 Add Emprunteur");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[32m");
            System.out.println("           【2】 Update Emprunteur");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[32m");
            System.out.println("           【3】 Delete Emprunteur ");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[32m");
            System.out.println("           【4】 List Emprunteurs");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[90m");
            System.out.print("_______________________________________________\n");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[31m");
            System.out.println("           【5】 Back to Main Menu");
            System.out.print("\u001B[0m");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    int id = emprunteurImpl.generateRandomRefernce();
                    System.out.println("Generated Refernce: " + id);
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Telephone: ");
                    int tel = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("CIN: ");
                    int cin = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Date of Birth (YYYY-MM-JJ): ");
                    String dateOfBirth = scanner.nextLine();

                    Emprunteur emprunteurToAdd = new Emprunteur(id, name, tel, cin, dateOfBirth);
                    emprunteurImpl.add(emprunteurToAdd);
                }
                case 2 -> {
                    System.out.print("Enter ID of the Emprunteur to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("New Telephone: ");
                    int newTel = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New CIN: ");
                    int newCin = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Date of Birth: ");
                    String newDateOfBirth = scanner.nextLine();

                    Emprunteur emprunteurToUpdate = new Emprunteur(idToUpdate, newName, newTel, newCin, newDateOfBirth);
                    boolean updated = emprunteurImpl.update(emprunteurToUpdate);
                    if (updated) {
                        System.out.println("Emprunteur updated successfully.");
                    } else {
                        System.out.println("Emprunteur not found or update failed.");
                    }
                } case 3 -> {
                    System.out.print("Enter ISBN of the book to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine();
                    boolean deleted = emprunteurImpl.deleteEmprunteur(idToDelete);
                    if (deleted) {
                        System.out.println("Book deleted successfully.");
                    } else {
                        System.out.println("Book not found or delete failed.");
                    }
                }

                case 4 ->{
                    List<Emprunteur> allEmprunteurs = emprunteurImpl.showEmprunteur();
                    System.out.print("\u001B[90m");
                    System.out.println("-----------------------------------------------");
                    System.out.println("List Emprunteurs ");
                    System.out.println("-----------------------------------------------");
                    System.out.print("\u001B[0m");
                    for (Emprunteur emprunteur : allEmprunteurs) {
                        System.out.println("Id: " + emprunteur.getId());
                        System.out.println("Name: " + emprunteur.getName());
                        System.out.println("Tel: " + emprunteur.getTel());
                        System.out.println("Cin: " + emprunteur.getCin());
                        System.out.println("Data of birth " + emprunteur.getDateOfBirth());
                        System.out.println();
                        System.out.print("\u001B[90m");
                        System.out.println("-----------------------------------------------");
                        System.out.print("\u001B[0m");
                    }
                }
                case 5 -> {
                    System.out.println("Returning to the main menu.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    private static void manageBorrowings(Scanner scanner) {
        EmpruntImpl borrowingImpl = new EmpruntImpl();

        while (true) {
            System.out.println("\nChoose an operation for Borrowings:");
            System.out.println("1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ISBN of the book to borrow: ");
                    int isbnToBorrow = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the borrower's ID: ");
                    int borrowerId = scanner.nextInt();
                    scanner.nextLine();


                    Book bookToBorrow = new Book(isbnToBorrow, "", "", "");
                    Emprunteur emprunteur = new Emprunteur(borrowerId, "", 0, 0, "");
                    borrowingImpl.borrow(bookToBorrow, emprunteur);
                    System.out.println("Book borrowed successfully.");
                }

                case 2 -> {
                    System.out.print("Enter ISBN of the book to return: ");
                    int isbnToReturn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the borrower's ID: ");
                    int borrowerIdToReturn = scanner.nextInt();
                    scanner.nextLine();

                    Book bookToReturn = new Book(isbnToReturn, "", "", "");
                    Emprunteur borrowerToReturn = new Emprunteur(borrowerIdToReturn, "", 0, 0, "");

                    Emprunt updatedBorrowing = borrowingImpl.returnBook(bookToReturn, borrowerToReturn);

                    if (updatedBorrowing != null) {
                        System.out.println("\nReturn book successfully.");
                    } else {
                        System.out.println("\nReturn book failed.");
                    }
                }



                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

}
