class Solution {
    // Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(Node root) {
        // If the tree is empty
        if (root == null) return 0;

        // Map to store the results of the subproblems
        Map<Node, int[]> dp = new HashMap<>();
        int[] result = getMaxSumHelper(root, dp);
        return Math.max(result[0], result[1]);
    }

    // Helper function to compute the maximum sum for the current node
    private static int[] getMaxSumHelper(Node node, Map<Node, int[]> dp) {
        if (node == null) return new int[]{0, 0};
        
        // If the result for this node is already computed, return it
        if (dp.containsKey(node)) {
            return dp.get(node);
        }

        // Compute the sum for left and right subtrees
        int[] leftResult = getMaxSumHelper(node.left, dp);
        int[] rightResult = getMaxSumHelper(node.right, dp);

        // Maximum sum including this node
        int include = node.data + leftResult[1] + rightResult[1];
        // Maximum sum excluding this node
        int exclude = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);

        // Store the result
        int[] result = new int[2];
        result[0] = include;
        result[1] = exclude;
        dp.put(node, result);

        // Return the maximum of including or excluding the current node
        return result;
    }
}
