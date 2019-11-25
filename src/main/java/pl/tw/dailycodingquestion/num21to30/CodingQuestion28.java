package pl.tw.dailycodingquestion.num21to30;

import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm to justify text.
 * Given a sequence of words and an integer line length k,
 * return a list of strings which represents each line, fully justified.
 * <p>
 * More specifically, you should have as many words as possible in each line.
 * There should be at least one space between each word.
 * Pad extra spaces when necessary so that each line has exactly length k.
 * Spaces should be distributed as equally as possible, with the extra spaces,
 * if any, distributed starting from the left.
 * <p>
 * If you can only fit one word on a line, then you should pad the right-hand side with spaces.
 * <p>
 * Each word is guaranteed not to be longer than k.
 * <p>
 * For example, given the list of words
 * ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]
 * and k = 16, you should return the following:
 * <p>
 * ["the  quick brown", # 1 extra space on the left
 * "fox  jumps  over", # 2 extra spaces distributed evenly
 * "the   lazy   dog"] # 4 extra spaces distributed evenly
 */
public class CodingQuestion28 {

    public static void main(String[] args) {
        System.out.println(fullJustify(
                new String[]{"This", "is", "an", "example", "of", "text", "justification."},
                16
        ));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentWordsSize = 0;

        for (String word : words) {
            if (currentWordsSize + (currentLine.size() - 1) + word.length() <= maxWidth) {
                currentWordsSize += word.length();
                currentLine.add(word);
            } else {
                lines.add(getJustifiedLine(maxWidth, currentLine, currentWordsSize));

                currentLine.clear();
                currentLine.add(word);
                currentWordsSize = word.length();
            }
        }

        if (currentLine.size() > 0) {
            lines.add(getJustifiedLine(maxWidth, currentLine, currentWordsSize));
        }
        return lines;
    }

    private static String getJustifiedLine(int maxWidth, List<String> currentLine, int currentWordsSize) {
        StringBuilder sb = new StringBuilder();
        int forSpaces = maxWidth - currentWordsSize;
        int spacesBetweenWords = forSpaces / (currentLine.size() == 1 ? 1 : currentLine.size() - 1);
        int spacesToDistribute = forSpaces - (spacesBetweenWords * (currentLine.size() == 1 ? 1 : currentLine.size() - 1));
        System.out.println(spacesToDistribute);

        for (int i = 0; i < currentLine.size() - 1 || i == 0; i++) {
            sb.append((currentLine.get(i)));
            for (int j = 0; j < spacesBetweenWords; j++) {
                sb.append(' ');
            }
            if (spacesToDistribute > 0) {
                sb.append(' ');
                spacesToDistribute--;
            }
        }

        if (currentLine.size() > 1) {
            sb.append(currentLine.get(currentLine.size() - 1));
        }
        return sb.toString();
    }
}
