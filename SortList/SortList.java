import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            return null;
        }
        List<Integer> sortedList = list.stream()
                .sorted()
                .collect(Collectors.toList());
        return sortedList;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) {
            return null;
        }
        List<Integer> sortedList = list.stream()
                .sorted()
                .collect(Collectors.toList());
        List<Integer> res = sortedList.reversed();
        return res;
    }
}