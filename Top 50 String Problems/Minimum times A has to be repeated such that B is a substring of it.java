class Solution {
    static int minRepeats(String A, String B) {
        // Lengths of A and B
        int lenA = A.length();
        int lenB = B.length();
        
        // Number of times A needs to be repeated to at least fit B
        int repeats = (int) Math.ceil((double) lenB / lenA);

        // Construct a string by repeating A enough times
        StringBuilder repeatedA = new StringBuilder();
        for (int i = 0; i < repeats; i++) {
            repeatedA.append(A);
        }

        // Check if B is a substring of the repeated string
        if (repeatedA.indexOf(B) != -1) {
            return repeats;
        }

        // Append one more A to handle cases where B might span across the end of the repeated string
        repeatedA.append(A);

        // Check again if B is a substring
        if (repeatedA.indexOf(B) != -1) {
            return repeats + 1;
        }

        // If B is not found in the repeated A string, return -1
        return -1;
    }
}
