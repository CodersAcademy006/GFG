class Solution {
    public int alternatingMaxLength(int[] arr) {
        if (arr.length == 0) return 0;

        // Initialize lengths of increasing and decreasing subsequences
        int inc = 1; // length of subsequence ending in an increasing order
        int dec = 1; // length of subsequence ending in a decreasing order

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                // If current element is greater than the previous element,
                // then it can continue a decreasing sequence to form an increasing sequence.
                inc = dec + 1;
            } else if (arr[i] < arr[i - 1]) {
                // If current element is smaller than the previous element,
                // then it can continue an increasing sequence to form a decreasing sequence.
                dec = inc + 1;
            }
        }

        // The result is the maximum of the two lengths.
        return Math.max(inc, dec);
    }
}
