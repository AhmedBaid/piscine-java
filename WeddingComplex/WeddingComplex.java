import java.util.*;

public class WeddingComplex {

    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {

        Map<String, String> couples = new HashMap<>();

        Map<String, String> engagedTo = new HashMap<>();

        Map<String, Integer> nextProposalIndex = new HashMap<>();

        Queue<String> free = new LinkedList<>(first.keySet());

        for (String person : first.keySet()) {
            nextProposalIndex.put(person, 0);
        }

        while (!free.isEmpty()) {
            String proposer = free.poll();
            List<String> preferences = first.get(proposer);

            String candidate = preferences.get(nextProposalIndex.get(proposer));
            nextProposalIndex.put(proposer, nextProposalIndex.get(proposer) + 1);

            if (!engagedTo.containsKey(candidate)) {
                engagedTo.put(candidate, proposer);
                couples.put(proposer, candidate);
            } else {
                String currentPartner = engagedTo.get(candidate);
                List<String> candidatePrefs = second.get(candidate);
                if (candidatePrefs.indexOf(proposer) < candidatePrefs.indexOf(currentPartner)) {
                    couples.remove(currentPartner);
                    free.add(currentPartner);
                    engagedTo.put(candidate, proposer);
                    couples.put(proposer, candidate);
                } else {
                    free.add(proposer);
                }
            }
        }
        return couples;
    }
}