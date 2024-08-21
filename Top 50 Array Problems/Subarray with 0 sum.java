class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        // Using HashSet to store prefix sums
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        
        // Traverse the array and keep adding elements to sum
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            
            // Check if sum is 0 or already exists in the set
            if (sum == 0 || set.contains(sum)) {
                return true;
            }
            
            // Add the current sum to the set
            set.add(sum);
        }
        
        // If no subarray with sum 0 was found, return false
        return false;
    }
}
