class Solution {
    int minDiff(int[] arr, int k) {
        // Sort the array
        Arrays.sort(arr);
        int n = arr.length;

        // Initialize the minimum difference to a large value
        int minDiff = Integer.MAX_VALUE;

        // Iterate through the array and check the difference for each k-sized window
        for (int i = 0; i + k - 1 < n; i++) {
            int diff = arr[i + k - 1] - arr[i]; // max - min for the current window
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff; // Return the minimum difference found
    }
}
