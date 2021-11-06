package pl.tw.leetCode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    // gorsza złożoność, ale proste
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray); // O(nlogn)
            String sorted = new String(charArray);

            result.putIfAbsent(sorted, new ArrayList<>());
            result.compute(sorted, (key, list) -> {
                list.add(word);
                return list;
            });
        }

        return new ArrayList<>(result.values());
    }

    // lepsza złożoność
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (String word : strs) {
            char[] charCount = new char[26];
            for (int i = 0; i < word.length(); i++) {
                charCount[word.charAt(i)- 'a']++;
            }
            String wordKey = Arrays.toString(charCount);

            result.putIfAbsent(wordKey, new ArrayList<>());
            result.compute(wordKey, (key, list) -> {
                list.add(word);
                return list;
            });
        }

        return new ArrayList<>(result.values());
    }


}
