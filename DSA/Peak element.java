class Solution {
    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public int peakElement(int[] arr, int n) {
        int low = 0;
        int high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if mid is a peak element
            boolean leftGreater = (mid == 0) || (arr[mid] >= arr[mid - 1]);
            boolean rightGreater = (mid == n - 1) || (arr[mid] >= arr[mid + 1]);
            
            if (leftGreater && rightGreater) {
                return mid;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1; // This line should never be reached if input constraints are followed
    }
}
