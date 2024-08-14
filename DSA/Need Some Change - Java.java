class Solution {
    static void swapElements(int[] arr) {
        // Iterate through the array and swap elements
        for (int i = 0; i < arr.length - 2; i++) {
            // Swap arr[i] with arr[i + 2]
            int temp = arr[i];
            arr[i] = arr[i + 2];
            arr[i + 2] = temp;
        }
    }
}
