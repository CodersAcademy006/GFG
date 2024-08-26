//User function template for JAVA

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        // If the lengths are not equal, they can't be K-anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Frequency arrays for both strings
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Populate frequency arrays
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // Count how many characters need to be changed in s1 to make it an anagram of s2
        int changesNeeded = 0;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > freq2[i]) {
                changesNeeded += freq1[i] - freq2[i];
            }
        }

        // Check if the changes needed are less than or equal to K
        return changesNeeded <= k;
    }
}
