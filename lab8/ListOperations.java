import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOperations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(3, 7, 2, 9, 1, 8, 4, 6, 5, 10));
        int sum = 0, max = Integer.MIN_VALUE;
        for (int v : list) {
            sum += v;
            if (v > max) max = v;
        }
        System.out.println("Sum: " + sum + ", Max: " + max);
        Collections.reverse(list);
        System.out.println("Reversed: " + list);
    }
}