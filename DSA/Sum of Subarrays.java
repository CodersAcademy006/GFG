class Solution {
    public long subarraySum(int[] arr) {
        long totalSum = 0; // To store the total sum of all subarrays
        long mod = 1000000007; // The modulo value

        int n = arr.length; // Length of the array

        for (int i = 0; i < n; i++) {
            // Calculate how many subarrays include arr[i]
            // (i + 1) is the number of starting points for subarrays that can include arr[i]
            // (n - i) is the number of ending points for subarrays that can include arr[i]
            long contribution = (long) arr[i] * (i + 1) * (n - i) % mod;
            totalSum = (totalSum + contribution) % mod; // Add the contribution to the total sum
        }

        return totalSum; // Return the total sum modulo (10^9 + 7)
    }
}
