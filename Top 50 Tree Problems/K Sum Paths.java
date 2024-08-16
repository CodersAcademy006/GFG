class Solution {
    // Function to count the number of paths with sum k
    public int sumK(Node root, int k) {
        // Map to store the frequency of prefix sums
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        // Initialize the map with the base case
        prefixSumCounts.put(0, 1);
        // Start the DFS traversal
        return countPaths(root, k, prefixSumCounts, 0);
    }
    
    // Recursive function to count paths with sum k
    private int countPaths(Node node, int k, Map<Integer, Integer> prefixSumCounts, int currentSum) {
        if (node == null) {
            return 0;
        }
        
        // Update the current path sum
        currentSum += node.data;
        
        // Calculate the number of valid paths ending at this node
        int numPaths = prefixSumCounts.getOrDefault(currentSum - k, 0);
        
        // Update the hash map with the current path sum
        prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        
        // Recursively count paths in the left and right subtrees
        numPaths += countPaths(node.left, k, prefixSumCounts, currentSum);
        numPaths += countPaths(node.right, k, prefixSumCounts, currentSum);
        
        // Remove the current path sum from the hash map to backtrack
        prefixSumCounts.put(currentSum, prefixSumCounts.get(currentSum) - 1);
        
        return numPaths;
    }
}
