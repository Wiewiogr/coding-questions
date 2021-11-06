package pl.tw.leetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithourRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> characterSet = new HashSet<>();
        String longestSubstring = "";
        int l = 0;

        for (int r = 1; r < s.length(); r++) {
            while (characterSet.contains(s.charAt(r))) {
                characterSet.remove(s.charAt(l));
                l++;
            }

            characterSet.add(s.charAt(r));
            if ((r - l) > longestSubstring.length()) {
                longestSubstring = s.substring(l, r);
            }
        }
        System.out.println(longestSubstring);
        return longestSubstring.length();
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithourRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }
}
