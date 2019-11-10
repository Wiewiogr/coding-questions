package pl.tw.dailycodingquestion;

import java.util.HashMap;

/**
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 * <p>
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
public class CodingQuestion13 {

    public static void main(String[] args) {
        System.out.println(findLongestSubstring("abcba", 2));
        System.out.println(findLongestSubstring("abcba", 5));
        System.out.println(findLongestSubstring("abcdefghijk", 2));
        System.out.println(findLongestSubstring("abcgdefghijk", 6));
    }

    public static int findLongestSubstring(String s, int k) {
        int l = 0, r = 0, ans = 0;
        int size = s.length();

        HashMap<Character, Integer> charCount = new HashMap<>();

        while (l < size && r < size) {
            if (charCount.size() < k ||
                    (charCount.size() == k && charCount.containsKey(s.charAt(r)))) {
                int count = charCount.getOrDefault(s.charAt(r), 0);
                charCount.put(s.charAt(r), ++count);
                r++;
                ans = Math.max(ans, r - l);
            } else {
                int count = charCount.get(s.charAt(l));
                count--;
                if (count == 0) {
                    charCount.remove(s.charAt(l));
                } else {
                    charCount.put(s.charAt(l), count);
                }
                l++;
            }
        }
        return ans;
    }
}
