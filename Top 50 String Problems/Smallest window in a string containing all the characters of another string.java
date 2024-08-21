class Solution
{
    public static String smallestWindow(String s, String p)
    {
        if (s.length() < p.length()) return "-1";

        // Frequency maps for the characters in P and current window in S
        Map<Character, Integer> charCountP = new HashMap<>();
        for (char c : p.toCharArray()) {
            charCountP.put(c, charCountP.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> charCountWindow = new HashMap<>();
        int required = charCountP.size(); // Number of unique characters in P
        int formed = 0; // Number of unique characters in current window which match the requirement
        int l = 0; // Left pointer for the window
        int r = 0; // Right pointer for the window

        int minLength = Integer.MAX_VALUE; // Length of the smallest window
        int minLengthStart = 0; // Starting index of the smallest window

        while (r < s.length()) {
            // Expand the window by including s[r]
            char c = s.charAt(r);
            charCountWindow.put(c, charCountWindow.getOrDefault(c, 0) + 1);
            
            if (charCountP.containsKey(c) && charCountWindow.get(c).intValue() == charCountP.get(c).intValue()) {
                formed++;
            }
            
            // Try to contract the window until the point it ceases to be 'desirable'
            while (l <= r && formed == required) {
                c = s.charAt(l);
                
                // Update the smallest window
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    minLengthStart = l;
                }
                
                // The character at the position pointed by `l` is no longer a part of the window
                charCountWindow.put(c, charCountWindow.get(c) - 1);
                if (charCountP.containsKey(c) && charCountWindow.get(c).intValue() < charCountP.get(c).intValue()) {
                    formed--;
                }
                
                // Move left pointer
                l++;
            }
            
            // Move right pointer
            r++;
        }

        // If we found a valid window
        if (minLength == Integer.MAX_VALUE) {
            return "-1";
        }
        
        return s.substring(minLengthStart, minLengthStart + minLength);
    }
}
