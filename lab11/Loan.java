package lab11;

import java.time.LocalDate;

// Loan.java
public class Loan {
    private final LibraryItem item;
    private final Member member;
    private final LocalDate issueDate;
    private final LocalDate dueDate;

    public Loan(LibraryItem item, Member member) {
        this.item = item;
        this.member = member;
        this.issueDate = LocalDate.now();
        this.dueDate = issueDate.plusDays(item.loanPeriodDays());
    }

    public Loan(LibraryItem item, Member member, LocalDate issueDate, LocalDate dueDate) {
        this.item = item;
        this.member = member;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public LibraryItem getItem() { return item; }
    public Member getMember() { return member; }
    public LocalDate getDueDate() { return dueDate; }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return String.format("Loan [Item: %s (%s) | Member: %s | Due Date: %s | Overdue: %b]",
                item.getTitle(), item.getId(), member.getName(), dueDate, isOverdue());
    }
}