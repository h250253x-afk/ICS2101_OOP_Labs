enum Level {
    LOW,
    MEDIUM,
    HIGH
}

public class EnumLevel {

    public static void printLevelAdvice(Level lvl) {
        switch (lvl) {
            case LOW -> System.out.println("Low Level: lower priority task.");
            case MEDIUM -> System.out.println("Medium Level: moderate urgency.");
            case HIGH -> System.out.println("High Level: urgent task.");
        }
    }

    public static void main(String[] args) {

        for (Level lvl : Level.values()) {
            System.out.print("[" + lvl + "] -> ");
            printLevelAdvice(lvl);
        }
    }
}