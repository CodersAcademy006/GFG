class Compute {
    public String isSubset(long a1[], long a2[], long n, long m) {
        // Step 1: Create a frequency map for array a1
        HashMap<Long, Integer> freqMap = new HashMap<>();
        
        for (long num : a1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Traverse a2 and check in the frequency map
        for (long num : a2) {
            if (!freqMap.containsKey(num) || freqMap.get(num) == 0) {
                return "No";
            }
            // Decrement the count of the found element
            freqMap.put(num, freqMap.get(num) - 1);
        }
        
        // Step 3: If all elements are found, return "Yes"
        return "Yes";
    }
}
