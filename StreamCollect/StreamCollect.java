import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {
    public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {
        List<String> orginal = s.toList();
        List<String> words = orginal.stream().map(ele -> ele.toLowerCase()).collect(Collectors.toList());
        Map<Character, List<String>> map = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            Character key = Character.toUpperCase(words.get(i).charAt(0));
            if (map.containsKey(key)) {
                map.get(key).add(orginal.get(i));
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(orginal.get(i));
            }
        }
        return map;
    }

    public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer> s) {
        Map<Integer, Optional<Integer>> map = new HashMap<>();
        List<Integer> original = s.toList();
        List<Integer> list = original.stream().map(ele -> ele % 4).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            Integer key = list.get(i);
            if (map.containsKey(key)) {
                Optional<Integer> value = map.get(key);
                if (value.get() < original.get(i)) {
                    map.put(key, Optional.of(original.get(i)));
                }
            } else {
                map.put(key, Optional.of(original.get(i)));
            }
        }
        return map;
    }

    public static String orderAndConcatWithSharp(Stream<String> s) {
        List<String> list = s.toList();
        List<String> sorted = list.stream().sorted().collect(Collectors.toList());
        String result = sorted.stream().reduce((a, b) -> a + " # " + b).orElse("");
        return "{" + result + "}";
    }

    public static void main(String[] args) {
        System.out.println(StreamCollect.mapByFirstLetter(Stream.of("Bonjour", "le", "monde !", "bonsoir")));
        System.out.println(StreamCollect.getMaxByModulo4(Stream.of(5, 12, 32, 4, 9, 17, 98, 424, 97, 5843, 48354)));
        System.out.println(StreamCollect
                .orderAndConcatWithSharp(Stream.of("Hello", "how are you ?", "where do you live ?", "Bordeaux")));
    }
}