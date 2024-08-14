class Solution {
    int[] getMoreAndLess(int[] arr, int x) {
        int[] result = new int[2];

        // Finding the count of elements less than or equal to x
        int lessEqualCount = upperBound(arr, x);
        result[0] = lessEqualCount;

        // Finding the count of elements greater than or equal to x
        int greaterEqualCount = arr.length - lowerBound(arr, x);
        result[1] = greaterEqualCount;

        return result;
    }

    // Function to find the index of the first element greater than x
    private int upperBound(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= x) {
                left = mid + 1; // Move to the right half
            } else {
                right = mid; // Move to the left half
            }
        }
        return left; // This is the count of elements <= x
    }

    // Function to find the index of the first element >= x
    private int lowerBound(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1; // Move to the right half
            } else {
                right = mid; // Move to the left half
            }
        }
        return left; // This is the index of the first element >= x
    }
}
