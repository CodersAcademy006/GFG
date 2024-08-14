class Solution {
    public static int maxWater(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0; // No buildings, no water.

        int left = 0, right = n - 1;
        int left_max = 0, right_max = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= left_max) {
                    left_max = arr[left];
                } else {
                    waterTrapped += left_max - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= right_max) {
                    right_max = arr[right];
                } else {
                    waterTrapped += right_max - arr[right];
                }
                right--;
            }
        }

        return waterTrapped;
    }
}
