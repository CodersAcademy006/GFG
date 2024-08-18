class Solution {
    public long count(int coins[], int N, int sum) {
        // Create a dp array to store the number of ways to get each sum
        long[] dp = new long[sum + 1];
        
        // Base case: There's one way to get sum 0, by choosing nothing
        dp[0] = 1;
        
        // Fill the dp array using the coins available
        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        
        // The answer is the number of ways to form the sum
        return dp[sum];
    }
}
