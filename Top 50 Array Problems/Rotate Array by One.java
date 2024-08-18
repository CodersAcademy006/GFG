class Solution {
    public void rotate(int[] arr) {
        int n = arr.length;
        
        // If the array has only one element, no rotation is needed.
        if (n <= 1) return;
        
        // Store the last element
        int lastElement = arr[n - 1];
        
        // Shift all elements to the right by one position
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        
        // Place the last element at the first position
        arr[0] = lastElement;
    }
}
