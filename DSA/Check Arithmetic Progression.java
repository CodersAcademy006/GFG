class Solution {
    // Function to check if the given array forms an arithmetic progression
    public boolean checkIsAP(int[] arr) {
        int n = arr.length;

        // If there are less than 2 elements, we can consider it as forming an AP
        if (n < 2) return true;

        // Sort the array
        Arrays.sort(arr);

        // Calculate the common difference
        int commonDiff = arr[1] - arr[0];

        // Check if all consecutive differences are equal to the common difference
        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != commonDiff) {
                return false; // Not forming an AP
            }
        }

        return true; // It is an AP
    }
}
