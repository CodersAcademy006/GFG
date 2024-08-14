class Solution {
    // Function to get the count of elements between num1 and num2 in array arr.
    public int getCount(ArrayList<Integer> arr, int num1, int num2) {
        int n = arr.size();
        int leftIndex = -1;
        int rightIndex = -1;

        // Find the leftmost occurrence of num1 and rightmost occurrence of num2
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == num1 && leftIndex == -1) {
                leftIndex = i; // Set the leftmost index for num1
            }
            if (arr.get(i) == num2) {
                rightIndex = i; // Keep updating to get the rightmost index for num2
            }
        }

        // Check if we have valid indices
        if (leftIndex == -1 || rightIndex == -1 || leftIndex >= rightIndex) {
            return 0; // Return 0 if invalid indices
        }

        // Count the elements between the two indices
        return rightIndex - leftIndex - 1;
    }
}
