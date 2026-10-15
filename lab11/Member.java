package lab11;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String memberId;
    private final String name;
    private final List<Loan> currentLoans = new ArrayList<>();

    public Member(String memberId, String name) {
        if (memberId == null || memberId.isBlank() || name == null || name.isBlank()) {
            throw new IllegalArgumentException("Member ID and Name cannot be blank.");
        }
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Loan> getCurrentLoans() { return currentLoans; }

    public boolean canBorrow() {
        return currentLoans.size() < 3; // Max 3 active loans constraint
    }

    public void addLoan(Loan loan) {
        currentLoans.add(loan);
    }

    public void removeLoan(Loan loan) {
        currentLoans.remove(loan);
    }

    @Override
    public String toString() {
        return String.format("Member ID: %s | Name: %-15s | Active Loans: %d/3", memberId, name, currentLoans.size());
    }
}