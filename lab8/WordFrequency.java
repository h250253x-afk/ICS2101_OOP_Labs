import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "apple banana apple cherry banana apple";
        Map<String, Integer> map = new HashMap<>();
        for (String w : text.split(" ")) map.merge(w, 1, Integer::sum);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        System.out.println(list);
    }
}