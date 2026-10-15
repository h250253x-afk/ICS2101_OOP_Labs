package lab11;

// Borrowable.java
public interface Borrowable {
    void borrowItem(Member member) throws ItemNotAvailableException, MemberLimitExceededException;
    void giveBack();
}