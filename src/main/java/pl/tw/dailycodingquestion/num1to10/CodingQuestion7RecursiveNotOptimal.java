package pl.tw.dailycodingquestion.num1to10;

import java.util.HashSet;

/**
 * This problem was asked by Facebook.
 * <p>
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * <p>
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * <p>
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class CodingQuestion7RecursiveNotOptimal {

    public static void main(String[] args) {
        String message = "111";
        decode(message, "", 0);
        System.out.println(resultSet);
    }

    private static char[] mappings = "abcdefghijklmnopqrstuvwxyz".toCharArray();


    private static HashSet<String> resultSet = new HashSet<>();

    private static void decode(String message, String result, int cursor) {


        int remaining = message.length() - cursor;
        if (remaining >= 1) {
            String newResult = result + mappings[Integer.valueOf(message.charAt(cursor) + "") - 1];
            if (remaining == 1) {
                resultSet.add(newResult);
            } else {
                decode(message, newResult, cursor + 1);
            }
        }
        if (remaining >= 2) {
            Integer decoded = Integer.valueOf(message.substring(cursor, cursor + 2));
            if (decoded < 26) {
                String newResult = result + mappings[decoded - 1];
                if (remaining == 2) {
                    resultSet.add(newResult);
                } else {
                    decode(message, newResult, cursor + 2);
                }
            }
        }
    }
}
