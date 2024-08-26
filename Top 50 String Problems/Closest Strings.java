//User function Template for Java

class Solution {
    int shortestDistance(ArrayList<String> s, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int minDistance = Integer.MAX_VALUE;
        
        // Traverse through the list of words
        for (int i = 0; i < s.size(); i++) {
            String word = s.get(i);
            
            // If word matches word1, update index1
            if (word.equals(word1)) {
                index1 = i;
            }
            
            // If word matches word2, update index2
            if (word.equals(word2)) {
                index2 = i;
            }
            
            // If both indices are updated, calculate the distance
            if (index1 != -1 && index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }
        
        return minDistance;
    }
}
