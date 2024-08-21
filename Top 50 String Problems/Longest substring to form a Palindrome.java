class Solution {
    static int longestSubstring(String S) {
        // HashMap to store the first occurrence of each bitmask
        Map<Integer, Integer> map = new HashMap<>();
        // Initialize the map with the base case
        map.put(0, -1); 
        
        int mask = 0; // Initial bitmask
        int maxLength = 0;
        
        for (int i = 0; i < S.length(); i++) {
            // Toggle the bit corresponding to the current character
            mask ^= (1 << (S.charAt(i) - 'a'));
            
            // If the current mask has been seen before
            if (map.containsKey(mask)) {
                maxLength = Math.max(maxLength, i - map.get(mask));
            } else {
                map.put(mask, i); // Store the first occurrence of this bitmask
            }
            
            // Check for the case where one character can have odd count
            for (int j = 0; j < 26; j++) {
                int maskToCheck = mask ^ (1 << j);
                if (map.containsKey(maskToCheck)) {
                    maxLength = Math.max(maxLength, i - map.get(maskToCheck));
                }
            }
        }
        
        return maxLength;
    }
}
