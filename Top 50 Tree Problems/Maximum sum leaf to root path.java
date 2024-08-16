// The code given still persist some modifications, the code will not pass all the test cases as debuging is still needed.
/*class Solution {
    // Helper class to encapsulate the result
    class Result {
        int maxSum; // Stores the maximum path sum from leaf to root
        Result(int maxSum) {
            this.maxSum = maxSum;
        }
    }

    public int maxPathSum(Node root) {
        // Initialize result to hold maximum path sum
        Result result = new Result(Integer.MIN_VALUE);
        // Compute the maximum path sum
        maxPathSumUtil(root, result);
        return result.maxSum;
    }

    private int maxPathSumUtil(Node node, Result result) {
        // Base case: If node is null, return a very small value
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        // If it's a leaf node, return its own value
        if (node.left == null && node.right == null) {
            return node.data;
        }

        // Recursively get the maximum sum from left and right subtrees
        int leftSum = maxPathSumUtil(node.left, result);
        int rightSum = maxPathSumUtil(node.right, result);

        // Calculate the maximum sum path from current node
        int currentMaxSum = Math.max(leftSum, rightSum) + node.data;

        // Update the global maximum path sum if needed
        result.maxSum = Math.max(result.maxSum, currentMaxSum);

        // Return the maximum sum path from current node to a leaf
        return currentMaxSum;
    }
}*/
