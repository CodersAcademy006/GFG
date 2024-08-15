class GfG {
    public boolean isSymmetric(Node root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }
        return isMirror(root.left, root.right); // Check if left and right subtrees are mirror images
    }
    
    private boolean isMirror(Node left, Node right) {
        // If both nodes are null, they are symmetric
        if (left == null && right == null) {
            return true;
        }
        // If one of the nodes is null and the other is not, they are not symmetric
        if (left == null || right == null) {
            return false;
        }
        // Check if the current nodes are equal and recurse for their children
        return (left.data == right.data) && 
               isMirror(left.left, right.right) && 
               isMirror(left.right, right.left);
    }
}
