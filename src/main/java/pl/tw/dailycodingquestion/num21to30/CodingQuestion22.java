package pl.tw.dailycodingquestion.num21to30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Given a dictionary of words and a string made up of those words (no spaces),
 * return the original sentence in a list.
 * If there is more than one possible reconstruction, return any of them.
 * If there is no possible reconstruction, then return null.
 * <p>
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
 * you should return ['the', 'quick', 'brown', 'fox'].
 * <p>
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond',
 * and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
public class CodingQuestion22 {

    public static void main(String[] args) {
        System.out.println(getListOfWords("bedbathandbeyond", Set.of("bed", "bath", "bedbath", "and", "beyond")));
    }

    public static List<String> getListOfWords(String s, Set<String> dictionary) {
        HashMap<Integer, String> wordBeginnings = new HashMap<>();
        wordBeginnings.put(0, "");

        for (int i = 1; i < s.length() + 1; i++) {
            HashMap<Integer, String> newWordBeginnings = (HashMap<Integer, String>) wordBeginnings.clone();

            int finalI = i;
            wordBeginnings.forEach((key, value) -> {
                String word = s.substring(key, finalI);
                if (dictionary.contains(word)) {
                    newWordBeginnings.put(finalI, word);
                }
            });
            wordBeginnings = newWordBeginnings;
        }

        if (!wordBeginnings.containsKey(s.length())) {
            return null;
        }

        int currentPointer = s.length();
        List<String> words = new ArrayList<>();
        while (currentPointer > 0) {
            String word = wordBeginnings.get(currentPointer);
            words.add(word);
            currentPointer -= word.length();
        }

        return words;
    }
}
