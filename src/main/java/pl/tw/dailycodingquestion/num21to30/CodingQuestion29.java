package pl.tw.dailycodingquestion.num21to30;

/**
 * Run-length encoding is a fast and simple method of encoding strings.
 * The basic idea is to represent repeated successive characters as a single count and character.
 * For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 * <p>
 * Implement run-length encoding and decoding.
 * You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
 * You can assume the string to be decoded is valid.
 */
public class CodingQuestion29 {

    public static void main(String[] args) {
        System.out.println(encode("AAAAABCCDDD"));
        System.out.println(decode("35A12B2C100D"));
    }

    public static String encode(String s) {
        StringBuilder sb = new StringBuilder();

        int occurences = 1;
        char lastChar = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == lastChar) {
                occurences++;
            } else {
                sb.append(occurences).append(lastChar);
                lastChar = s.charAt(i);
                occurences = 1;
            }
        }

        sb.append(occurences).append(lastChar);
        return sb.toString();
    }

    public static String decode(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            int numberStart = i;
            int numberEnd = i;
            while (Character.isDigit(s.charAt(i))) {
                i++;
                numberEnd++;
            }

            int timesRepeated = Integer.parseInt(s.substring(numberStart, numberEnd));
            char repeatedLetter = s.charAt(i);

            for (int j = 0; j < timesRepeated; j++) {
                sb.append(repeatedLetter);
            }
            i++;
        }
        return sb.toString();
    }
}
