class Solution {
    public int longestSubarray(int arr[]) {
        int maxLength = 0;  // To store the length of the longest subarray
        int currentLength = 0;  // To store the length of the current non-negative subarray
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                currentLength++;  // Increment current length for non-negative numbers
            } else {
                maxLength = Math.max(maxLength, currentLength);  // Update max length if needed
                currentLength = 0;  // Reset current length for the next subarray
            }
        }
        
        // Final comparison in case the longest subarray is at the end of the array
        maxLength = Math.max(maxLength, currentLength);
        
        return maxLength;
    }
}
