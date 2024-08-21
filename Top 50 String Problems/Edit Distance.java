class Solution {
    public int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        // Create a 2D array to store the results of subproblems
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Deleting all characters from str1 to match empty str2
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Inserting all characters to an empty str1 to match str2
        }
        
        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // Characters match, no new operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Calculate the minimum operations required
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j],    // Remove
                                                      dp[i][j - 1]),   // Insert
                                                      dp[i - 1][j - 1]); // Replace
                }
            }
        }
        
        return dp[m][n];
    }
}
