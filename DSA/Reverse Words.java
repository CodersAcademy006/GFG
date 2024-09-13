class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // Splitting the string by '.' and storing words in an array.
        String[] words = str.split("\\.");
        // Reversing the array of words.
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(".");
            }
        }
        // Returning the reversed string.
        return result.toString();
    }
}
