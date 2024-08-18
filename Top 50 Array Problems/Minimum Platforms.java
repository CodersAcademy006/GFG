class Solution {
    // Function to find the minimum number of platforms required at the railway station
    static int findPlatform(int arr[], int dep[], int n) {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Initialize pointers for arrival and departure times
        int i = 0;  // Pointer for arrival
        int j = 0;  // Pointer for departure
        int platforms_needed = 0;  // Current number of platforms needed
        int max_platforms_needed = 0;  // Maximum number of platforms needed

        // Traverse both arrays
        while (i < n && j < n) {
            // If next event is an arrival, increment platform count
            if (arr[i] <= dep[j]) {
                platforms_needed++;
                i++;
            } 
            // If next event is a departure, decrement platform count
            else {
                platforms_needed--;
                j++;
            }

            // Update maximum platforms needed
            if (platforms_needed > max_platforms_needed) {
                max_platforms_needed = platforms_needed;
            }
        }

        return max_platforms_needed;
    }
}
