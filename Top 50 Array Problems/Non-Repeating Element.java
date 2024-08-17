class Solution {
    public int firstNonRepeating(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        // First pass: count occurrences of each element
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Second pass: find the first element with a count of 1
        for (int num : arr) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        
        return 0;
    }
}
