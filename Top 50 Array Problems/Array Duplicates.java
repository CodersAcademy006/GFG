class Solution {
    public static ArrayList<Integer> duplicates(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        int[] count = new int[n];
        
        // Count the frequency of each element
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        
        // Collect elements that appear more than once
        for (int i = 0; i < n; i++) {
            if (count[i] > 1) {
                result.add(i);
            }
        }
        
        // If no duplicates found, return [-1]
        if (result.isEmpty()) {
            result.add(-1);
        }
        
        return result;
    }
}
