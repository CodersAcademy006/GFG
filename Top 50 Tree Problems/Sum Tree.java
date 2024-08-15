class Solution {
    // This method returns the sum of the tree rooted at `node`
    // and checks if it is a sum tree or not.
    private int checkSumTree(Node node) {
        // An empty tree is a Sum Tree
        if (node == null) {
            return 0;
        }
        
        // A leaf node is also a Sum Tree
        if (node.left == null && node.right == null) {
            return node.data; // return leaf node's value
        }
        
        // Recursively check the left and right subtrees
        int leftSum = checkSumTree(node.left);
        int rightSum = checkSumTree(node.right);
        
        // If either left or right is not a Sum Tree, return -1
        if (leftSum == -1 || rightSum == -1) {
            return -1;
        }
        
        // Check if the current node's value equals the sum of its children
        if (node.data == leftSum + rightSum) {
            // Return the sum of the current subtree
            return 2 * node.data; // include current node's value
        } else {
            return -1; // Not a Sum Tree
        }
    }
    
    // Main function to check if the tree is a Sum Tree
    boolean isSumTree(Node root) {
        // Check if the tree is a Sum Tree
        return checkSumTree(root) != -1;
    }
}
