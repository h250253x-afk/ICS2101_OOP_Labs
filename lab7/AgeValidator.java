class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) { super(msg); }
}

public class AgeValidator {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age out of bounds: " + age);
        }
    }
}

