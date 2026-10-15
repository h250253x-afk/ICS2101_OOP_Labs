package lab11;

import java.util.List;
import java.util.Scanner;

public class MainTerminal {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add Item (Book / DVD)");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. Search Items by Title (Streams)");
            System.out.println("6. List Overdue Items");
            System.out.println("7. Save and Exit");
            System.out.print("Select an option (1-7): ");

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Enter Type (1 for Book, 2 for DVD): ");
                        String type = scanner.nextLine().trim();
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine().trim();
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine().trim();

                        if (type.equals("1")) {
                            System.out.print("Enter Author: ");
                            String author = scanner.nextLine().trim();
                            library.addItem(new Book(id, title, author));
                            System.out.println("Book added successfully.");
                        } else if (type.equals("2")) {
                            System.out.print("Enter Runtime (minutes): ");
                            int runtime = Integer.parseInt(scanner.nextLine().trim());
                            library.addItem(new Dvd(id, title, runtime));
                            System.out.println("DVD added successfully.");
                        } else {
                            System.out.println("Invalid type selected.");
                        }
                    }
                    case "2" -> {
                        System.out.print("Enter Member ID: ");
                        String mid = scanner.nextLine().trim();
                        System.out.print("Enter Member Name: ");
                        String name = scanner.nextLine().trim();
                        library.registerMember(new Member(mid, name));
                        System.out.println("Member registered successfully.");
                    }
                    case "3" -> {
                        System.out.print("Enter Member ID: ");
                        String mid = scanner.nextLine().trim();
                        System.out.print("Enter Item ID: ");
                        String iid = scanner.nextLine().trim();
                        library.borrow(mid, iid);
                    }
                    case "4" -> {
                        System.out.print("Enter Item ID to return: ");
                        String iid = scanner.nextLine().trim();
                        library.returnItem(iid);
                    }
                    case "5" -> {
                        System.out.print("Enter title keyword to search: ");
                        String query = scanner.nextLine().trim();
                        List<LibraryItem> results = library.searchByTitle(query);
                        System.out.println("\n--- Search Results ---");
                        if (results.isEmpty()) {
                            System.out.println("No matching items found.");
                        } else {
                            results.forEach(System.out::println);
                        }
                    }
                    case "6" -> {
                        List<Loan> overdue = library.getOverdueLoans();
                        System.out.println("\n--- Overdue Loans ---");
                        if (overdue.isEmpty()) {
                            System.out.println("No overdue items currently.");
                        } else {
                            overdue.forEach(System.out::println);
                        }
                    }
                    case "7" -> {
                        library.saveDataToCsv();
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (ItemNotAvailableException | MemberLimitExceededException e) {
                System.err.println("[Business Rule Error] " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("[Input Error] " + e.getMessage());
            } catch (Exception e) {
                System.err.println("[System Error] " + e.getMessage());
            }
        }
        scanner.close();
    }
}