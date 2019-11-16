package pl.tw.dailycodingquestion;

/**
 * A builder is looking to build a row of N houses that can be of K different colors.
 * He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
 * <p>
 * Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
 * return the minimum cost which achieves this goal.
 */
public class CodingQuestion19Optimal {

    public static void main(String[] args) {
        System.out.println(
                minCost(
                        new int[][]{
                                {0, 1, 2},
                                {3, 5, 8},
                                {2, 1, 3},
                                {4, 2, 5}
                        },
                        3
                )
        );
    }

    public static int minCost(int[][] costs, int k) {
        int[] dp = new int[k];

        int min1 = 0, min2 = 0, prevMin1 = 0, prevMin2 = 0;

        for (int i = 0; i < costs.length; i++) {
            prevMin1 = min1;
            prevMin2 = min2;
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                if (dp[j] != prevMin1 || prevMin1 == prevMin2) {
                    dp[j] = prevMin1 + costs[i][j];
                } else {
                    dp[j] = prevMin2 + costs[i][j];
                }

                if (dp[j] <= min1) {
                    min2 = min1;
                    min1 = dp[j];
                } else if (dp[j] < min2) {
                    min2 = dp[j];
                }
            }
        }
        return min1;
    }
}
