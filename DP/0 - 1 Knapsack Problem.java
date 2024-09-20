class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int[] wt, int[] val) {
        int N = val.length;
        int[][] dp = new int[N + 1][W + 1];
        
        // Build the dp array
        for (int i = 0; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        // The last element in dp array will hold the maximum value
        return dp[N][W];
    }
}
