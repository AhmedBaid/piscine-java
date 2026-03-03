import java.util.*;
import java.util.stream.Collectors;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> l = coins.stream().collect(Collectors.toList());
        Collections.sort(l);
        Collections.reverse(l);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            while (amount - l.get(i) >= 0) {
                res.add(l.get(i));
                amount -= l.get(i);
            }
        }
        return res;
    }
}