// This code has passed only 3 testcases including the compiling one. The approach iss correct but the bug still persist's. This code may still not provide the correct output.
// Understand the code and try to write the code yourself so that the question must be solved.

/*class Solution {
    
    // Helper class to store result during recursion
    private static class Result {
        int maxSum;
    }
    
    int maxPathSum(Node root) {
        Result result = new Result();
        result.maxSum = Integer.MIN_VALUE;
        findMaxPathSum(root, result);
        return result.maxSum;
    }
    
    private int findMaxPathSum(Node node, Result result) {
        if (node == null) return 0;
        
        // If the node is a leaf node or has only one child, it's a special node
        boolean isSpecialNode = (node.left == null || node.right == null);
        
        // Find max path sums in left and right subtrees
        int leftSum = findMaxPathSum(node.left, result);
        int rightSum = findMaxPathSum(node.right, result);
        
        // Compute max path sum including current node
        int currentSum = node.data;
        
        if (node.left != null) currentSum += leftSum;
        if (node.right != null) currentSum += rightSum;
        
        // Update the global maxSum if current path sum is greater
        result.maxSum = Math.max(result.maxSum, currentSum);
        
        // Return the maximum path sum that can be extended to its parent
        if (node.left == null) return (node.right != null) ? node.data + rightSum : node.data;
        if (node.right == null) return (node.left != null) ? node.data + leftSum : node.data;
        
        return node.data + Math.max(leftSum, rightSum);
    }
}*/
