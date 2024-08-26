// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // Map to store the frequency of characters in the current window
        HashMap<Character, Integer> charCount = new HashMap<>();
        int maxLength = -1;
        int left = 0;

        // Traverse the string
        for (int right = 0; right < s.length(); right++) {
            // Add the current character to the map and update its frequency
            char ch = s.charAt(right);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

            // Shrink the window if the number of unique characters exceeds k
            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                
                // Remove the character from the map if its frequency is 0
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            // If the window has exactly k unique characters, update maxLength
            if (charCount.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}
