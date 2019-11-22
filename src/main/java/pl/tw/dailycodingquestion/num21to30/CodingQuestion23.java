package pl.tw.dailycodingquestion.num21to30;

import java.util.LinkedList;

/**
 * You are given an M by N matrix consisting of booleans that represents a board.
 * Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
 * <p>
 * Given this matrix, a start coordinate, and an end coordinate,
 * return the minimum number of steps required to reach the end coordinate from the start.
 * If there is no possible path, then return null.
 * You can move up, left, down, and right.
 * You cannot move through walls.
 * You cannot wrap around the edges of the board.
 */
public class CodingQuestion23 {

    public static void main(String[] args) {

        System.out.println(minimumNumberOfSteps(
                new boolean[][]{
                        new boolean[]{false, false, false, false},
                        new boolean[]{true, true, false, true},
                        new boolean[]{false, false, false, false},
                        new boolean[]{false, false, false, false}
                },
// no possible path
//                new boolean[][]{
//                        new boolean[]{false, false, false, false},
//                        new boolean[]{true, true, true, true},
//                        new boolean[]{false, false, false, false},
//                        new boolean[]{false, false, false, false}
//                },
                new int[]{3, 0},
                new int[]{0, 0}
        ));
    }

    public static int[][] directions = new int[][]{
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, -1}
    };

    public static Integer minimumNumberOfSteps(boolean[][] board, int[] start, int[] end) {
        int[][] steps = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            steps[i] = new int[board[0].length];
            for (int j = 0; j < steps[i].length; j++) {
                steps[i][j] = -1;
            }
        }
        steps[start[0]][start[1]] = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];

                if (notWithinBoard(x, y, board) ||
                        board[x][y] ||
                        steps[x][y] != -1) {
                    continue;
                }

                steps[x][y] = steps[current[0]][current[1]] + 1;

                if (x == end[0] && y == end[1]) {
                    return steps[x][y];
                }
                queue.offer(new int[]{x, y});
            }
        }
        return null;
    }

    private static boolean notWithinBoard(int x, int y, boolean[][] board) {
        return x < 0 || y < 0 || x >= board.length || y >= board[0].length;
    }
}
