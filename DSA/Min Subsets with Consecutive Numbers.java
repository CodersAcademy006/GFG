class Solution {
    public int numOfSubset(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Initialize subset count
        int subsetCount = 1; // Start with one subset
        
        // Step 3: Iterate through the array
        for (int i = 1; i < arr.length; i++) {
            // If current element is not consecutive to the previous one
            if (arr[i] != arr[i - 1] + 1) {
                subsetCount++; // Start a new subset
            }
        }
        
        return subsetCount; // Return the total number of subsets
    }
}
