package pl.tw.mediumarticle.pre.lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        HashMap<Character, String> values = new HashMap<>();
        values.put('2', "abc");
        values.put('3', "def");
        values.put('4', "ghi");
        values.put('5', "jkl");
        values.put('6', "mno");
        values.put('7', "pqrs");
        values.put('8', "tuv");
        values.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        combinations(0, digits, new StringBuilder(), result, values);
        return result;
    }


    void combinations(int pointer, String digits, StringBuilder currentCombination, List<String> results, HashMap<Character, String> values) {
        if (pointer >= digits.length()) {
            results.add(currentCombination.toString());
            return;
        }

        String letters = values.get(digits.charAt(pointer));

        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            combinations(pointer + 1, digits, currentCombination, results, values);
            currentCombination.deleteCharAt(pointer);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test().letterCombinations("23"));
        System.out.println(new Test().letterCombinations(""));
        System.out.println(new Test().letterCombinations("2"));
    }
}
