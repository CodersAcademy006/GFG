class Solution {
    // Function to check if two trees are identical
    private boolean areIdentical(Node root1, Node root2) {
        // Both are null, so they are identical
        if (root1 == null && root2 == null) {
            return true;
        }
        
        // One of them is null, or the values don't match
        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        
        // Recursively check the left and right subtrees
        return areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
    }
    
    // Function to check if S is a subtree of T
    public boolean isSubtree(Node T, Node S) {
        // If S is null, it's a subtree of any tree
        if (S == null) {
            return true;
        }
        
        // If T is null but S is not, S can't be a subtree
        if (T == null) {
            return false;
        }
        
        // Check if the current node of T matches with S
        if (areIdentical(T, S)) {
            return true;
        }
        
        // Recursively check left and right subtrees of T
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }
}
