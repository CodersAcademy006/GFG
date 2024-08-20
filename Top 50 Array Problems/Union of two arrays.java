class Solution {
    public static int doUnion(int arr1[], int arr2[]) {
        // Use a HashSet to store distinct elements
        Set<Integer> unionSet = new HashSet<>();
        
        // Add all elements from the first array
        for (int num : arr1) {
            unionSet.add(num);
        }
        
        // Add all elements from the second array
        for (int num : arr2) {
            unionSet.add(num);
        }
        
        // The size of the set represents the number of distinct elements in the union
        return unionSet.size();
    }
}
