class Complete {
    
    // Function to find the maximum adjacent sum in the array
    public int max_adjacent_sum(int[] arr, int n) {
        // Initialize maxSum with the minimum possible value
        int maxSum = Integer.MIN_VALUE;
        
        // Iterate through the array and calculate adjacent sums
        for (int i = 0; i < n - 1; i++) {
            int currentSum = arr[i] + arr[i + 1];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        // Return the maximum adjacent sum found
        return maxSum;
    }
}
