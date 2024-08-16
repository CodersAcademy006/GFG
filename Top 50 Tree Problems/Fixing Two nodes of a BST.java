class Solution {
    
    // Helper class to keep track of the swapped nodes
    private class Result {
        Node first, second, prev;
        
        Result() {
            this.first = null;
            this.second = null;
            this.prev = null;
        }
    }

    // Main function to correct the BST
    public Node correctBST(Node root) {
        Result result = new Result();
        // Perform in-order traversal to find swapped nodes
        inorderTraversal(root, result);
        
        // If two nodes are found, swap their values
        if (result.first != null && result.second != null) {
            int temp = result.first.data;
            result.first.data = result.second.data;
            result.second.data = temp;
        }
        
        return root;
    }

    // In-order traversal to find nodes that are out of order
    private void inorderTraversal(Node root, Result result) {
        if (root == null) return;
        
        // Traverse the left subtree
        inorderTraversal(root.left, result);
        
        // Check if previous node is greater than current node
        if (result.prev != null && root.data < result.prev.data) {
            // If this is the first occurrence of misplaced nodes
            if (result.first == null) {
                result.first = result.prev;
                result.second = root;
            } else {
                // If this is the second occurrence of misplaced nodes
                result.second = root;
            }
        }
        
        // Update the previous node
        result.prev = root;
        
        // Traverse the right subtree
        inorderTraversal(root.right, result);
    }
}
