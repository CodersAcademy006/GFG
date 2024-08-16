class Solution {

    private static final int MOD = 1000000007;
    
    // Function to compute the number of unique BSTs
    public int numTrees(int N) {
        // Array to store the number of unique BSTs for each count of nodes
        long[] dp = new long[N + 1];
        dp[0] = 1; // There's one BST for 0 nodes (the empty tree)
        dp[1] = 1; // There's one BST for 1 node
        
        // Fill the dp array
        for (int i = 2; i <= N; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                dp[i] = (dp[i] + dp[j - 1] * dp[i - j]) % MOD;
            }
        }
        
        return (int) dp[N];
    }
}
