class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // Initialize variables
        long max_so_far = arr[0];
        long max_ending_here = arr[0];
        long min_ending_here = arr[0];
        
        // Traverse through the array
        for (int i = 1; i < n; i++) {
            // If the current element is negative, swap max and min
            if (arr[i] < 0) {
                long temp = max_ending_here;
                max_ending_here = min_ending_here;
                min_ending_here = temp;
            }
            
            // Calculate the maximum and minimum product ending at the current index
            max_ending_here = Math.max(arr[i], max_ending_here * arr[i]);
            min_ending_here = Math.min(arr[i], min_ending_here * arr[i]);
            
            // Update the maximum product found so far
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        
        return max_so_far;
    }
}
