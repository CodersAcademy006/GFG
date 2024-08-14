class Solution {
    // Function for finding inverse permutation
    public static ArrayList<Integer> inversePermutation(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> inverse = new ArrayList<>(n);

        // Initialize the inverse array with zeros
        for (int i = 0; i < n; i++) {
            inverse.add(0);
        }

        // Fill the inverse array
        for (int i = 0; i < n; i++) {
            // arr[i] is the value, and we place the index i + 1 (1-based index) in the position of arr[i]
            inverse.set(arr[i] - 1, i + 1); // arr[i] - 1 for 0-based indexing
        }

        return inverse;
    }
}
