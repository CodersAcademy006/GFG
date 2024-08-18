class Solution {
    // Function to find the minimum and maximum in the array
    public Pair<Long, Long> getMinMax(int[] arr) {
        int n = arr.length;
        
        // Initialize minimum and maximum with the first element
        long min = arr[0];
        long max = arr[0];
        
        // Traverse the array to find the min and max elements
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        // Return the results in a Pair object
        return new Pair<>(min, max);
    }
}
