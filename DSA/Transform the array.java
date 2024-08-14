class Solution {
    public ArrayList<Integer> valid(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Process valid numbers
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                // If the last element in the result is equal to the current number,
                // we need to double the last element and make the current one zero.
                if (!result.isEmpty() && result.get(result.size() - 1) == arr[i]) {
                    int last = result.remove(result.size() - 1); // Remove the last valid number
                    result.add(last * 2); // Add doubled value
                    arr[i] = 0; // Set current number to zero
                } else {
                    result.add(arr[i]); // Add valid number to result
                }
            }
        }

        // Step 2: Fill the rest with zeros
        while (result.size() < n) {
            result.add(0); // Add zeros to the end of the list
        }

        return result;
    }
}
