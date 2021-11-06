package pl.tw.leetCode;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> requiredCount = new HashMap<>();
        HashMap<Character, Integer> currentCount = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            currentCount.put(currChar, 0);
            int count = requiredCount.getOrDefault(currChar, 0);
            requiredCount.put(currChar, count + 1);
        }

        int have = 0;
        int need = requiredCount.size();

        int l = 0;
        int r = 0;

        String result = "";
        int resultLen = Integer.MAX_VALUE;
        while (r < s.length()) {
            char currentChar = s.charAt(r);

            if (currentCount.containsKey(currentChar)) {
                currentCount.compute(currentChar, (key, value) -> value + 1);
                if (currentCount.get(currentChar).equals(requiredCount.get(currentChar))) {
                    have++;
                }
            }

            while (have == need) {
                int len = (r - l) + 1;
                if (len < resultLen) {
                    result = s.substring(l, r + 1);
                    resultLen = len;
                }

                char leftChar = s.charAt(l);

                if (requiredCount.containsKey(leftChar)) {
                    // teraz jest spełniony warunek
                    if (currentCount.get(leftChar).equals(requiredCount.get(leftChar))) {
                        currentCount.compute(leftChar, (k, v) -> v - 1);
                        have--;
                    } else {
                        currentCount.compute(leftChar, (k, v) -> v - 1);
                    }
                }
                l++;
            }
            r++;
        }
        if (resultLen == Integer.MAX_VALUE) {
            return "";
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
}
