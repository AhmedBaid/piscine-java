import java.util.*;

public class WeddingComplex {

    public static Map<String, String> createBestCouple(Map<String, List<String>> first,
            Map<String, List<String>> second) {

        Map<String, String> result = new HashMap<>();
        Map<String, String> reverse = new HashMap<>();

        List<String> free = new ArrayList<>(first.keySet());
        Map<String, Integer> nextChoice = new HashMap<>();

        for (String person : first.keySet()) {
            nextChoice.put(person, 0);
        }

        while (!free.isEmpty()) {
            String p1 = free.remove(0);

            List<String> preferences = first.get(p1);
            String p2 = preferences.get(nextChoice.get(p1));
            nextChoice.put(p1, nextChoice.get(p1) + 1);

            if (!reverse.containsKey(p2)) {
                result.put(p1, p2);
                reverse.put(p2, p1);
            } else {
                String current = reverse.get(p2);

                List<String> prefList = second.get(p2);

                if (prefList.indexOf(p1) < prefList.indexOf(current)) {
                    result.remove(current);
                    free.add(current);

                    result.put(p1, p2);
                    reverse.put(p2, p1);
                } else {
                    free.add(p1);
                }
            }
        }

        return result;
    }
}