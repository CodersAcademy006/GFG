class Solution {
    // Function to find a continuous sub-array which adds up to a given number.
    public ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int start = 0;
        int curr_sum = 0;

        for (int end = 0; end < n; end++) {
            // Add the current element to curr_sum
            curr_sum += arr[end];

            // Shrink the window from the start if curr_sum exceeds the target sum 's'
            while (curr_sum > s && start < end) {
                curr_sum -= arr[start];
                start++;
            }

            // If we find the subarray with the sum equal to 's'
            if (curr_sum == s) {
                result.add(start + 1); // 1-based index
                result.add(end + 1);   // 1-based index
                return result;
            }
        }

        // If no subarray found with the given sum, return -1
        result.add(-1);
        return result;
    }
}
