class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    // Helper function to check the validity of the BST
    boolean isBSTUtil(Node node, int min, int max) {
        // An empty tree is a BST
        if (node == null) {
            return true;
        }
        
        // Check if the current node's value is within the valid range
        if (node.data <= min || node.data >= max) {
            return false;
        }
        
        // Recursively check the left and right subtrees with updated ranges
        return isBSTUtil(node.left, min, node.data) && 
               isBSTUtil(node.right, node.data, max);
    }
}
