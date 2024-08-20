class Solution {
    // Function to count subarrays with equal number of 0s and 1s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        // Step 1: Replace 0s with -1s to transform the problem into finding subarrays with sum = 0
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        // Step 2: Use a hashmap to store the frequency of prefix sums
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int sum = 0;  // Initialize sum of elements
        int count = 0;  // Initialize the count of subarrays

        // Step 3: Traverse the array
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // If the sum is zero, it means we have found a subarray from the start to i
            if (sum == 0) {
                count++;
            }

            // If the sum is found in the map, then it means there is a subarray
            // that ends at index i with sum zero
            if (prefixSumCount.containsKey(sum)) {
                count += prefixSumCount.get(sum);
            }

            // Increment the frequency of this sum in the map
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
