import java.util.HashSet;
class Solution
{
    // Function to check if a string is Pangram or not.
    public static boolean checkPangram(String s) {
        // Set to store unique alphabetic characters
        HashSet<Character> seenLetters = new HashSet<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // Convert to lowercase and check if it's a letter
            if (Character.isLetter(c)) {
                seenLetters.add(Character.toLowerCase(c));
            }
        }
        
        // If the set contains 26 characters, it's a pangram
        return seenLetters.size() == 26;
    }
}
