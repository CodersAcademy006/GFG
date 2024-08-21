class Solution {
    int lps(String s) {
        int n = s.length();
        int[] lps = new int[n]; // Array to hold the length of the longest prefix suffix values
        
        // Length of the previous longest prefix suffix
        int length = 0;
        int i = 1;
        
        // The loop calculates lps[i] for i = 1 to n-1
        while (i < n) {
            if (s.charAt(i) == s.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                // Mismatch after length matches
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // The length of the longest proper prefix which is also suffix
        // We need to subtract 1 because the entire string should not be considered
        return lps[n - 1];
    }
}
