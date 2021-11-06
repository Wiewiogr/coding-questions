package pl.tw.leetCode;

import pl.tw.App;

import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> numberOfCharacters = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            numberOfCharacters.putIfAbsent(s.charAt(i), 0);
            numberOfCharacters.compute(s.charAt(i), (c, count) -> count + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            if (!numberOfCharacters.containsKey(character)) {
                return false;
            }

            int charCount = numberOfCharacters.get(character);
            if (charCount == 1) {
                numberOfCharacters.remove(character);
            } else {
                numberOfCharacters.put(character, charCount - 1);
            }
        }
        return true;
    }
}
