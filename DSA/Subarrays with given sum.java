class Solution {
    public static int subArraySum(int[] arr, int k) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        int cumulativeSum = 0;
        int count = 0;

        // Initialize the map with the base case
        sumCount.put(0, 1);

        // Iterate through the array
        for (int num : arr) {
            cumulativeSum += num;

            // Check if there is a cumulative sum that, when subtracted, equals k
            if (sumCount.containsKey(cumulativeSum - k)) {
                count += sumCount.get(cumulativeSum - k);
            }

            // Update the count of the current cumulative sum in the map
            sumCount.put(cumulativeSum, sumCount.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count; // Return the count of subarrays that sum to k
    }
}
