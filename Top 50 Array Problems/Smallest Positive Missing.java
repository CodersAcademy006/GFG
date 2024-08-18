class Solution {
    static int missingNumber(int arr[], int size) {
        // Step 1: Clean the array
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0 || arr[i] > size) {
                arr[i] = size + 1; // Step 2: Replace out-of-bound values
            }
        }
        
        // Step 3: Use index as a hash
        for (int i = 0; i < size; i++) {
            int value = Math.abs(arr[i]);
            if (value <= size) {
                // Mark the index (value - 1) as visited
                if (arr[value - 1] > 0) {
                    arr[value - 1] = -arr[value - 1];
                }
            }
        }
        
        // Step 4: Find the first unmarked index
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1; // Index + 1 is the smallest missing positive number
            }
        }
        
        // If all indices are marked, the smallest missing positive number is size + 1
        return size + 1;
    }
}
