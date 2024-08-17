class Solution {
    int[] sumClosest(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int[] result = new int[2];
        int closestDiff = Integer.MAX_VALUE;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum - k);
            
            if (diff < closestDiff) {
                closestDiff = diff;
                result[0] = arr[left];
                result[1] = arr[right];
            } else if (diff == closestDiff) {
                // If the difference is the same, choose the pair with the maximum absolute difference
                if (Math.abs(arr[left] - arr[right]) > Math.abs(result[0] - result[1])) {
                    result[0] = arr[left];
                    result[1] = arr[right];
                }
            }
            
            if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
