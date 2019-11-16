package pl.tw.dailycodingquestion;

/**
 * A builder is looking to build a row of N houses that can be of K different colors.
 * He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
 * <p>
 * Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
 * return the minimum cost which achieves this goal.
 */
public class CodingQuestion19NotOptimalButGeneric {

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
        int n = costs.length;
        int[][] cache = new int[n][];

        for (int i = 0; i < n; i++) {
            cache[i] = new int[k];
        }

        for (int i = 0; i < k; i++) {
            cache[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                cache[i][j] = Integer.MAX_VALUE;
                for (int m = 0; m < k; m++) {
                    if (m != j) {
                        cache[i][j] = Math.min(cache[i][j], cache[i - 1][m] + costs[i][j]);
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            minCost = Math.min(cache[n - 1][i], minCost);
        }

        return minCost;
    }
}
