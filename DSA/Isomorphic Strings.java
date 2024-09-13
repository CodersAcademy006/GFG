class Solution
{
    // Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1, String str2)
    {
        // If lengths of strings are different, they can't be isomorphic
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Maps to track character mappings
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        
        // Iterate through the strings
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            
            // Check if ch1 is already mapped
            if (map1.containsKey(ch1)) {
                // If it is mapped to a different character than ch2, return false
                if (map1.get(ch1) != ch2) {
                    return false;
                }
            } else {
                // If ch1 is not yet mapped, check if ch2 is already mapped to another character
                if (map2.containsKey(ch2)) {
                    return false;
                }
                // Create the new mappings
                map1.put(ch1, ch2);
                map2.put(ch2, ch1);
            }
        }
        
        // If no inconsistencies were found, the strings are isomorphic
        return true;
    }
}
