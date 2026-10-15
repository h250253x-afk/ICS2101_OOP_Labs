package lab11;

public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public abstract int loanPeriodDays();

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public void borrowItem(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if (!available) {
            throw new ItemNotAvailableException("Item '" + title + "' (ID: " + id + ") is currently not available.");
        }
        if (!member.canBorrow()) {
            throw new MemberLimitExceededException("Member " + member.getName() + " has reached the maximum loan limit of 3 items.");
        }
        setAvailable(false);
    }

    @Override
    public void giveBack() {
        setAvailable(true);
    }

    @Override
    public String toString() {
        return String.format("[%s] ID: %s | Title: %-20s | Loan Period: %d days | Available: %b",
                getClass().getSimpleName(), id, title, loanPeriodDays(), available);
    }
}