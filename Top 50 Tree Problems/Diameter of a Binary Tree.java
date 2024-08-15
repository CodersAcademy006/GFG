class Solution {
    int diameter; // Variable to store the diameter of the tree

    // Function to compute the height of the tree and update the diameter
    private int height(Node node) {
        if (node == null) {
            return 0; // Base case: height of an empty tree is 0
        }

        // Recursively compute the height of the left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update the diameter
        diameter = Math.max(diameter, leftHeight + rightHeight + 1);

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Function to find the diameter of the tree
    int diameter(Node root) {
        diameter = 0; // Initialize the diameter
        height(root); // Compute the height and update the diameter
        return diameter; // Return the diameter
    }
}
