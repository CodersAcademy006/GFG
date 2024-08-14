class Solution {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Create an ArrayList to store the result
        ArrayList<Integer> result = new ArrayList<>();
        
        int n = arr.length;
        int left = 0; // pointer for the smallest element
        int right = n - 1; // pointer for the largest element
        
        // Step 3: Alternate between largest and smallest
        while (left <= right) {
            // Add the largest element
            if (left != right) {
                result.add(arr[right]);
            }
            // Add the smallest element
            result.add(arr[left]);
            left++;
            right--;
        }
        
        return result;
    }
}
