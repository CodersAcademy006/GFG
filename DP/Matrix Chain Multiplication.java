class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N][N];
        
        // Initialize the dp table
        for (int i = 1; i < N; i++) {
            dp[i][i] = 0;
        }
        
        // Fill the dp table
        for (int len = 2; len < N; len++) {
            for (int i = 1; i < N - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + arr[i-1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        
        // Return the minimum cost of matrix multiplication
        return dp[1][N-1];
    }
}
