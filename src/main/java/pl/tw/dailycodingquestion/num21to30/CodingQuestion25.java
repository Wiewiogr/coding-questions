package pl.tw.dailycodingquestion.num21to30;

/**
 * This problem was asked by Facebook.
 * <p>
 * Implement regular expression matching with the following special characters:
 * <p>
 * . (period) which matches any single character
 * * (asterisk) which matches zero or more of the preceding element
 * <p>
 * That is, implement a function that takes in a string and a valid regular expression and
 * returns whether or not the string matches the regular expression.
 * <p>
 * For example, given the regular expression "ra." and the string "ray", your function should return true.
 * The same regular expression on the string "raymond" should return false.
 * <p>
 * Given the regular expression ".*at" and the string "chat", your function should return true.
 * The same regular expression on the string "chats" should return false.
 */
public class CodingQuestion25 {

    public static void main(String[] args) {
        System.out.println(matches("abc", "a.c"));
        System.out.println(matches("abbbbbc", "ab*c"));
        System.out.println(matches("abc", "ab*c"));
        System.out.println(matches("ac", "ab*c"));

        System.out.println(matches("ac", "ab*bc"));
        System.out.println(matches("ray", "ra.b"));
        System.out.println(matches("raymond", "ra."));
    }

    public static boolean matches(String s, String re) {
        if (re.length() == 0 || s.length() == 0) {
            return s.length() == re.length();
        }

        if (re.charAt(0) == '.') {
            return matches(s.substring(1), re.substring(1));
        }

        if (re.length() == 1 || re.charAt(1) != '*') {
            if (re.charAt(0) == s.charAt(0)) {
                return matches(s.substring(1), re.substring(1));
            } else {
                return false;
            }
        }

        if (matches(s, re.substring(2))) {
            return true;
        }

        int i = 0;
        while (s.charAt(i) == re.charAt(0)) {
            if (matches(s.substring(++i), re.substring(2))) {
                return true;
            }
        }

        return false;
    }
}
