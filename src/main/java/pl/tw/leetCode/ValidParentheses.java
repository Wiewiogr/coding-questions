package pl.tw.leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ValidParentheses {

    // '(', ')', '{', '}', '[' and ']'
    public boolean isValid(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (isOpening(character)) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) return false;
                char poppedCharacter = stack.pop();
                if (!isMatching(poppedCharacter, character)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }
}
