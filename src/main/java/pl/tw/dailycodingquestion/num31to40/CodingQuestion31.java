package pl.tw.dailycodingquestion.num31to40;

/**
 * The edit distance between two strings refers to the minimum number of character insertions, deletions,
 * and substitutions required to change one string to the other.
 * For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”,
 * substitute the “e” for “i”, and append a “g”.
 * <p>
 * Given two strings, compute the edit distance between them.
 *
 * https://leetcode.com/problems/edit-distance/
 */
public class CodingQuestion31 {

    public static void main(String[] args) {
        System.out.println(distance("kitten", "sitting"));
    }

    public static int distance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][];
        for (int i = 0; i < s1.length() + 1; i++) {
            dp[i] = new int[s2.length() + 1];
            dp[i][0] = i;
        }

        for (int j = 0; j < s2.length() + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j],
                            Math.min(
                                    dp[i][j - 1],
                                    dp[i - 1][j - 1]
                            )
                    ) + 1;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
