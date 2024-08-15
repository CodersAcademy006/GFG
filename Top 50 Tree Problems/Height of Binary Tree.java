class Solution {
    // Function to find the height of the binary tree.
    int height(Node root) {
        // If the tree is empty, return 0
        if (root == null) {
            return 0;
        }
        
        // Compute the height of each subtree
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        // The height of the tree is the max of the heights of the left and right subtrees plus one for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
