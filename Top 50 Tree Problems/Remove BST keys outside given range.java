class Solution {
    
    public Node removekeys(Node root, int min, int max) {
        if (root == null) return null;
        
        // Recursively fix the left and right subtrees
        root.left = removekeys(root.left, min, max);
        root.right = removekeys(root.right, min, max);
        
        // If the current node's value is less than the minimum value, 
        // replace it with the right subtree
        if (root.data < min) {
            return root.right;
        }
        
        // If the current node's value is greater than the maximum value,
        // replace it with the left subtree
        if (root.data > max) {
            return root.left;
        }
        
        // If the current node is within the range, return it
        return root;
    }
}
