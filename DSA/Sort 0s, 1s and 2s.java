class Solution {
    public static void sort012(int a[], int n) {
        int low = 0;     // Pointer for the next position of 0
        int mid = 0;     // Current element pointer
        int high = n - 1; // Pointer for the next position of 2
        
        while (mid <= high) {
            if (a[mid] == 0) {
                // Swap 0 to the low position
                int temp = a[low];
                a[low] = a[mid];
                a[mid] = temp;
                low++;
                mid++;
            } else if (a[mid] == 1) {
                // Move to the next element
                mid++;
            } else {
                // Swap 2 to the high position
                int temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
            }
        }
    }
}
