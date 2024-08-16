class Solution {
    // Helper method to count single-valued subtrees
    private int countSingleValuedSubtrees(Node root) {
        if (root == null) return 0;
        
        // Count single-valued subtrees in the left and right subtrees
        int leftCount = countSingleValuedSubtrees(root.left);
        int rightCount = countSingleValuedSubtrees(root.right);
        
        // Check if current subtree is single-valued
        if (isSingleValued(root)) {
            // Return count of subtrees plus one for this subtree
            return leftCount + rightCount + 1;
        }
        
        // If not single-valued, just return the count from children
        return leftCount + rightCount;
    }
    
    // Method to check if subtree rooted at 'node' is single-valued
    private boolean isSingleValued(Node node) {
        if (node == null) return true;
        
        if (node.left == null && node.right == null) return true;
        
        boolean leftSingle = isSingleValued(node.left);
        boolean rightSingle = isSingleValued(node.right);
        
        if (node.left != null && (node.left.data != node.data || !leftSingle)) {
            return false;
        }
        
        if (node.right != null && (node.right.data != node.data || !rightSingle)) {
            return false;
        }
        
        return true;
    }
    
    // Public method to start counting single-valued subtrees
    public int singlevalued(Node root) {
        return countSingleValuedSubtrees(root);
    }
}
