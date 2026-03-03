import java.util.*;

public class Wedding {

    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {

        List<String> firstList = new ArrayList<>(first);
        List<String> secondList = new ArrayList<>(second);

        Collections.shuffle(firstList);
        Collections.shuffle(secondList);

        int length = Math.min(firstList.size(), secondList.size());

        Map<String, String> couples = new HashMap<>();

        for (int i = 0; i < length; i++) {
            couples.put(firstList.get(i), secondList.get(i));
        }

        return couples;
    }
}