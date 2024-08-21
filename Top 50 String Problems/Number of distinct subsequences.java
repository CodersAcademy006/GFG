class Solution {
    static final int MOD = 1000000007;
    
    int distinctSubsequences(String S) {
        int n = S.length();
        int[] dp = new int[n+1];
        dp[0] = 1; // There is 1 subsequence of an empty string: ""
        
        int[] lastOccurrence = new int[26]; // To store the last occurrence of each character
        Arrays.fill(lastOccurrence, -1);
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] * 2 % MOD; // All subsequences from dp[i-1], plus new subsequences formed by adding S[i-1]
            
            int charIdx = S.charAt(i-1) - 'a';
            if (lastOccurrence[charIdx] != -1) {
                // If the character has appeared before, we subtract the subsequences counted before that point
                dp[i] = (dp[i] - dp[lastOccurrence[charIdx] - 1] + MOD) % MOD;
            }
            
            // Update the last occurrence of the character
            lastOccurrence[charIdx] = i;
        }
        
        return dp[n];
    }
}
