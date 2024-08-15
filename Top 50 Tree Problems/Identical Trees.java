class Solution {
    // Function to check if two trees are identical.
    boolean isIdentical(Node root1, Node root2) {
        // If both nodes are null, they are identical
        if (root1 == null && root2 == null) {
            return true;
        }
        
        // If one of the nodes is null or the values are different, they are not identical
        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        
        // Recursively check the left and right subtrees
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
}
