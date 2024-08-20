class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Arrays to store the maximum heights to the left and right
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        // Fill leftMax array
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }
        
        // Fill rightMax array
        rightMax[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }
        
        // Calculate the trapped water
        long trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        
        return trappedWater;
    } 
}
