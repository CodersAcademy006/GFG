class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int n = arr1.size();
        int m = arr2.size();
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int result = 0;

        // Traverse both arrays
        while (i < n && j < m) {
            if (arr1.get(i) < arr2.get(j)) {
                sum1 += arr1.get(i++);
            } else if (arr1.get(i) > arr2.get(j)) {
                sum2 += arr2.get(j++);
            } else { // If both are equal
                result += Math.max(sum1, sum2) + arr1.get(i);
                sum1 = sum2 = 0;
                i++;
                j++;
            }
        }

        // Add remaining elements of arr1
        while (i < n) {
            sum1 += arr1.get(i++);
        }

        // Add remaining elements of arr2
        while (j < m) {
            sum2 += arr2.get(j++);
        }

        // Add the maximum of remaining sums
        result += Math.max(sum1, sum2);

        return result;
    }
}
