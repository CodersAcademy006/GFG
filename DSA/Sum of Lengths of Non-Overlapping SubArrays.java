class Solution {
    // Function to calculate the maximum sum of lengths of non-overlapping subarrays
    // with k as the maximum element
    public int calculateMaxSumLength(List<Integer> arr, int k) {
        int maxLengthSum = 0;
        int currentLength = 0;
        boolean foundK = false;

        for (int num : arr) {
            if (num > k) {
                // Reset if we encounter a number greater than k
                if (foundK) {
                    maxLengthSum += currentLength; // Add current length to the sum
                    foundK = false; // Reset for the next segment
                }
                currentLength = 0; // Reset current length
            } else if (num == k) {
                foundK = true; // Mark that we found k in the current segment
                currentLength++; // Increase current segment length
            } else {
                // Increment current length for numbers less than k
                currentLength++;
            }
        }

        // Check for the last segment if it ended with k
        if (foundK) {
            maxLengthSum += currentLength; // Add the last segment length
        }

        return maxLengthSum;
    }
}
