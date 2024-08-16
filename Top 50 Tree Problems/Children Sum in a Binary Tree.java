class Solution {
    // Function to check whether all nodes of a tree have the value 
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // Helper function to check the sum property and get the sum of the subtree
        return isSumPropertyHelper(root) ? 1 : 0;
    }
    
    // Function to check if a subtree satisfies the sum property and returns the sum of the subtree
    private static boolean isSumPropertyHelper(Node node) {
        // Base case: empty tree is considered to satisfy the property
        if (node == null) {
            return true;
        }
        
        // Base case: leaf nodes are considered to satisfy the property
        if (node.left == null && node.right == null) {
            return true;
        }
        
        // Recursively check left and right subtrees
        boolean leftValid = isSumPropertyHelper(node.left);
        boolean rightValid = isSumPropertyHelper(node.right);
        
        // Calculate sum of left and right children (0 if the child is null)
        int leftSum = (node.left != null) ? node.left.data : 0;
        int rightSum = (node.right != null) ? node.right.data : 0;
        
        // Check if the current node satisfies the property
        boolean currentValid = (node.data == leftSum + rightSum);
        
        // Return whether current node and its children satisfy the property
        return leftValid && rightValid && currentValid;
    }
}
