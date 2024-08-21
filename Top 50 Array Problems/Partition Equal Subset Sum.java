class Solution{
    public int equalPartition(int N, int arr[])
    {
        int totalSum = 0;
        // Calculate the total sum of the array
        for(int num : arr) {
            totalSum += num;
        }
        
        // If the total sum is odd, we cannot partition it into two equal halves
        if(totalSum % 2 != 0) {
            return 0;
        }
        
        int target = totalSum / 2;
        // Create a boolean dp array to check if sum `target` can be achieved
        boolean dp[] = new boolean[target + 1];
        
        // Base case: sum 0 is always achievable
        dp[0] = true;
        
        // Process each element in the array
        for(int i = 0; i < N; i++) {
            // Traverse backwards to avoid overwriting values in dp
            for(int j = target; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }
        
        // If the target sum can be achieved, return 1
        return dp[target] ? 1 : 0;
    }
}
