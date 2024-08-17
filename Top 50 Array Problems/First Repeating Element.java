class Solution {
    public static int firstRepeated(int[] arr) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        
        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            if (indexMap.containsKey(arr[i])) {
                // Update the minimum index if this is the first repeat found
                minIndex = Math.min(minIndex, indexMap.get(arr[i]) + 1);
            } else {
                // Store the first occurrence index of the element
                indexMap.put(arr[i], i);
            }
        }
        
        // If minIndex is unchanged, no repeating element was found
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
}
