class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;

        // Traverse all three arrays simultaneously
        while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            // If x = y and y = z, add to result and move forward in all arrays
            if (arr1.get(i).equals(arr2.get(j)) && arr2.get(j).equals(arr3.get(k))) {
                // Avoid adding duplicates in the result list
                if (result.isEmpty() || !result.get(result.size() - 1).equals(arr1.get(i))) {
                    result.add(arr1.get(i));
                }
                i++;
                j++;
                k++;
            }
            // x < y, move forward in arr1
            else if (arr1.get(i) < arr2.get(j)) {
                i++;
            }
            // y < z, move forward in arr2
            else if (arr2.get(j) < arr3.get(k)) {
                j++;
            }
            // z is smallest, move forward in arr3
            else {
                k++;
            }
        }

        // If no common elements were found, return [-1]
        if (result.isEmpty()) {
            result.add(-1);
        }

        return result;
    }
}
