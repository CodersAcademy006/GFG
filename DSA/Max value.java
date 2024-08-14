class Solution {
    // Function to find maximum value among the difference of element and index.
    public int maxVal(List<Integer> arr) {
        int n = arr.size();
        
        // Initialize max and min values
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        // Traverse the array to calculate (arr[i] - i)
        for (int i = 0; i < n; i++) {
            int currentValue = arr.get(i) - i; // Calculate arr[i] - i
            if (currentValue > maxValue) {
                maxValue = currentValue; // Update maxValue
            }
            if (currentValue < minValue) {
                minValue = currentValue; // Update minValue
            }
        }

        // Return the maximum difference
        return maxValue - minValue;
    }
}
