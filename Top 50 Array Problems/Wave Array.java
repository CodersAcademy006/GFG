class Solution {
    public static void convertToWave(int n, int[] arr) {
        // Traverse the array in steps of 2
        for (int i = 0; i < n - 1; i += 2) {
            // Swap arr[i] and arr[i + 1]
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
