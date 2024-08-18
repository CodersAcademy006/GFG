class Solution {
    public static boolean find3Numbers(int arr[], int n, int x) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Traverse the array and use the two-pointer technique
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                
                if (sum == x) {
                    return true;  // Triplet found
                } else if (sum < x) {
                    left++;  // Move left pointer to increase the sum
                } else {
                    right--;  // Move right pointer to decrease the sum
                }
            }
        }
        
        return false;  // No triplet found
    }
}
