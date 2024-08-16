class Solution {
    // Index wrapper to track the current index in pre[]
    private static class Index {
        int index;
        Index(int index) {
            this.index = index;
        }
    }

    // Function to construct the binary tree
    public Node constructTree(int n, int pre[], char preLN[]) {
        Index index = new Index(0); // Initialize the index
        return constructTreeHelper(pre, preLN, index, n);
    }

    // Helper function to construct the tree
    private Node constructTreeHelper(int[] pre, char[] preLN, Index index, int n) {
        // Base case
        if (index.index >= n) {
            return null;
        }

        // Create a new node with the current data
        Node node = new Node(pre[index.index]);

        // Check if the current node is a leaf node
        if (preLN[index.index] == 'L') {
            // It's a leaf node, no children
            index.index++;
            return node;
        }

        // If it's not a leaf node, process left and right subtrees
        index.index++;
        node.left = constructTreeHelper(pre, preLN, index, n);
        node.right = constructTreeHelper(pre, preLN, index, n);

        return node;
    }
}
