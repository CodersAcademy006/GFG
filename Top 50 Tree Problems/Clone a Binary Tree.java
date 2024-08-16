class Solution {
    public Tree cloneTree(Tree root) {
        if (root == null) {
            return null;
        }
        
        // Step 1: Create duplicates of nodes and insert them in the tree
        cloneNodes(root);
        
        // Step 2: Set the random pointers for the cloned nodes
        setRandomPointers(root);
        
        // Step 3: Separate the original and cloned trees
        return extractClonedTree(root);
    }
    
    // Helper method to clone nodes and insert them next to original nodes
    private void cloneNodes(Tree node) {
        if (node == null) {
            return;
        }
        
        // Clone the current node
        Tree clone = new Tree(node.data);
        // Insert the clone right after the original node
        clone.left = node.left;
        node.left = clone;
        
        // Recur for left and right subtrees
        cloneNodes(clone.left);
        cloneNodes(node.right);
    }
    
    // Helper method to set random pointers for cloned nodes
    private void setRandomPointers(Tree node) {
        if (node == null) {
            return;
        }
        
        Tree clone = node.left;
        if (clone != null) {
            clone.random = (node.random != null) ? node.random.left : null;
            setRandomPointers(clone.left);
            setRandomPointers(node.right);
        }
    }
    
    // Helper method to separate the cloned tree from the original tree
    private Tree extractClonedTree(Tree node) {
        if (node == null) {
            return null;
        }
        
        Tree clone = node.left;
        // Restore the original tree's left pointer
        node.left = clone.left;
        // Recursively extract the cloned tree
        clone.left = extractClonedTree(clone.left);
        clone.right = extractClonedTree(node.right);
        
        return clone;
    }
}
