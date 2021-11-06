package pl.tw.leetCode;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String res = "";

        int l, r = 0;

        for (int i = 0; i < s.length(); i++) {

            l = i;
            r = i;

            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    String palindrome = s.substring(l, r + 1);
                    if (palindrome.length() > res.length()) {
                        res = palindrome;
                    }
                    l--;
                    r++;
                } else {
                    break;
                }
            }

            l = i;
            r = i+1;

            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    String palindrome = s.substring(l, r + 1);
                    if (palindrome.length() > res.length()) {
                        res = palindrome;
                    }
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }

        return res;
    }
}
