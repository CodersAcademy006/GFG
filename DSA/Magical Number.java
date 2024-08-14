class Solution {
    public int findMagicalNumber(int[] arr) {
        int left = 0, right = arr.length - 1;
        int magicalNumber = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if arr[mid] is a magical number
            if (arr[mid] == mid) {
                magicalNumber = mid; // Found a magical number
                right = mid - 1; // Continue to search for the leftmost
            } else if (arr[mid] > mid) {
                right = mid - 1; // Search in the left half
            } else {
                left = mid + 1; // Search in the right half
            }
        }
        
        return magicalNumber != -1 ? arr[magicalNumber] : -1; // Return the magical number or -1 if none found
    }
}
