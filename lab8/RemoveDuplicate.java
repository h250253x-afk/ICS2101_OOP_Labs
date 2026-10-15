import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        List<String> names = List.of("Israel", "Nyasha", "James", "Nyasha", "Israel", "Tariro", "James");
        Set<String> uniqueNames = new LinkedHashSet<>(names);
        System.out.println(uniqueNames);
    }
}

