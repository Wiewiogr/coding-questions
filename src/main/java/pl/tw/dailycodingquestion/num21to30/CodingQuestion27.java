package pl.tw.dailycodingquestion.num21to30;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Given a string of round, curly, and square open and closing brackets,
 * return whether the brackets are balanced (well-formed).
 * <p>
 * For example, given the string "([])[]({})", you should return true.
 * <p>
 * Given the string "([)]" or "((()", you should return false.
 */

public class CodingQuestion27 {

    public static Set<Character> OPENING_CHARACTERS = Set.of('[', '{', '(');
    public static Map<Character, Character> MATCHING_OPENINGS = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public static void main(String[] args) {
        System.out.println(check("([])[]({})"));
        System.out.println(check("([)]"));
        System.out.println(check("((()"));
    }
    public static boolean check(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (OPENING_CHARACTERS.contains(c)) {
                stack.push(c);
            } else { // is closing
                char opening = stack.pop();
                if (MATCHING_OPENINGS.get(c) != opening) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
