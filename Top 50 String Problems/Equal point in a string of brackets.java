//User function Template for Java

class Solution {
    public long countSub(String str) {
        int n = str.length();

        // Array to store counts of closing brackets from the right
        int[] rightClose = new int[n + 1];
        
        // Fill the rightClose array
        for (int i = n - 1; i >= 0; i--) {
            rightClose[i] = rightClose[i + 1] + (str.charAt(i) == ')' ? 1 : 0);
        }
        
        int leftOpen = 0;
        
        // Traverse the string to find the equal point
        for (int i = 0; i <= n; i++) {
            // Check if the number of opening brackets equals closing brackets
            if (leftOpen == rightClose[i]) {
                return i;
            }
            // Update leftOpen count if an opening bracket is encountered
            if (i < n && str.charAt(i) == '(') {
                leftOpen++;
            }
        }
        
        // Return -1 if no equal point is found (though problem guarantees at least one)
        return -1;
    }
}
