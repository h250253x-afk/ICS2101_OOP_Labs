package lab11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> activeLoans = new ArrayList<>();

    private final Path itemsFile = Path.of("items.csv");
    private final Path membersFile = Path.of("members.csv");
    private final Path loansFile = Path.of("loans.csv");

    public Library() {
        loadDataFromCsv();
    }

    public void addItem(LibraryItem item) {
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public void borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        
        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);

        if (member == null || item == null) {
            throw new IllegalArgumentException("Invalid Member ID or Item ID provided.");
        }

        item.borrowItem(member);

        Loan loan = new Loan(item, member);
        member.addLoan(loan);
        activeLoans.add(loan);

        System.out.println("Success! Successfully checked out '" + item.getTitle() + "' for " + member.getName() + ".");
    }

    public void returnItem(String itemId) {
        LibraryItem item = items.get(itemId);
        if (item == null) {
            throw new IllegalArgumentException("Item ID not found.");
        }

        Loan targetLoan = activeLoans.stream()
                .filter(l -> l.getItem().getId().equals(itemId))
                .findFirst()
                .orElse(null);

        if (targetLoan == null) {
            System.out.println("This item is not currently listed as borrowed.");
            return;
        }

        item.giveBack();
        targetLoan.getMember().removeLoan(targetLoan);
        activeLoans.remove(targetLoan);
        System.out.println("Success! Item '" + item.getTitle() + "' returned successfully.");
    }

    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .toList();
    }

    public List<Loan> getOverdueLoans() {
        return activeLoans.stream()
                .filter(Loan::isOverdue)
                .toList();
    }

    public List<LibraryItem> getAllItems() { return new ArrayList<>(items.values()); }
    public List<Member> getAllMembers() { return new ArrayList<>(members.values()); }

    public void saveDataToCsv() {
        try {
            List<String> itemLines = items.values().stream()
                    .map(i -> {
                        if (i instanceof Book b) {
                            return String.join(",", "BOOK", b.getId(), b.getTitle(), String.valueOf(b.isAvailable()), b.getAuthor());
                        } else if (i instanceof Dvd d) {
                            return String.join(",", "DVD", d.getId(), d.getTitle(), String.valueOf(d.isAvailable()), String.valueOf(d.getRuntimeMinutes()));
                        }
                        return "";
                    })
                    .toList();
            Files.write(itemsFile, itemLines);

            List<String> memberLines = members.values().stream()
                    .map(m -> m.getMemberId() + "," + m.getName())
                    .toList();
            Files.write(membersFile, memberLines);
            
            List<String> loanLines = activeLoans.stream()
                    .map(l -> l.getMember().getMemberId() + "," + l.getItem().getId() + "," + l.getDueDate())
                    .toList();
            Files.write(loansFile, loanLines);

            System.out.println("[Persistence] All items, members, and loans saved to CSV files.");
        } catch (IOException e) {
            System.err.println("Error saving data to CSV: " + e.getMessage());
        }
    }

    private void loadDataFromCsv() {
        try {
            if (Files.exists(itemsFile)) {
                Files.readAllLines(itemsFile).stream().filter(l -> !l.isBlank()).forEach(line -> {
                    String[] p = line.split(",");
                    String type = p[0];
                    String id = p[1];
                    String title = p[2];
                    boolean available = Boolean.parseBoolean(p[3]);

                    if (type.equals("BOOK")) {
                        Book b = new Book(id, title, p[4]);
                        b.setAvailable(available);
                        items.put(id, b);
                    } else if (type.equals("DVD")) {
                        Dvd d = new Dvd(id, title, Integer.parseInt(p[4]));
                        d.setAvailable(available);
                        items.put(id, d);
                    }
                });
            }

            if (Files.exists(membersFile)) {
                Files.readAllLines(membersFile).stream().filter(l -> !l.isBlank()).forEach(line -> {
                    String[] p = line.split(",");
                    members.put(p[0], new Member(p[0], p[1]));
                });
            }

            if (Files.exists(loansFile) && !items.isEmpty() && !members.isEmpty()) {
                Files.readAllLines(loansFile).stream().filter(l -> !l.isBlank()).forEach(line -> {
                    String[] p = line.split(",");
                    Member m = members.get(p[0]);
                    LibraryItem item = items.get(p[1]);
                    LocalDate dueDate = LocalDate.parse(p[2]);

                    if (m != null && item != null) {
                        Loan loan = new Loan(item, m, LocalDate.now(), dueDate);
                        m.addLoan(loan);
                        activeLoans.add(loan);
                    }
                });
            }
        } catch (Exception e) {
            System.err.println("Notice: Could not load existing CSV data. Starting with fresh state.");
        }
    }
}