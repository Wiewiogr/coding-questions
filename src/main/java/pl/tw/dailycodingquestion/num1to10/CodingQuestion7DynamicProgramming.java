package pl.tw.dailycodingquestion.num1to10;

public class CodingQuestion7DynamicProgramming {

    public static void main(String[] args) {
        String message = "01";
        cache = new Integer[message.length()];
        System.out.println(decode(message, 0));
    }

    private static Integer[] cache;

    private static int decode(String message, int cursor) {

        int remaining = message.length() - cursor;

        if (remaining == 0) {
            return 1;
        }

        if (message.charAt(cursor) == '0') {
            return 0;
        }

        if (cache[cursor] != null) {
            return cache[cursor];
        }

        int result;
        if (remaining >= 2) {
            Integer decoded = Integer.valueOf(message.substring(cursor, cursor + 2));
            if (decoded <= 26 && decoded > 0) {
                result = decode(message, cursor + 2) + decode(message, cursor + 1);
            } else {
                result = decode(message, cursor + 1);
            }
        } else {
            result = decode(message, cursor + 1);
        }

        cache[cursor] = result;
        return result;
    }
}
