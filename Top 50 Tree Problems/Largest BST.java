class Solution {
    
    // A utility class to store information about the subtree
    static class SubtreeInfo {
        int size;      // Size of the BST
        int min;       // Minimum value in the BST
        int max;       // Maximum value in the BST
        boolean isBST; // Flag to check if the subtree is a BST

        SubtreeInfo(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        return largestBSTSubtree(root).size;
    }

    // Function to return the largest BST subtree information
    static SubtreeInfo largestBSTSubtree(Node node) {
        // Base case
        if (node == null) {
            return new SubtreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        // Recur for left and right subtrees
        SubtreeInfo leftInfo = largestBSTSubtree(node.left);
        SubtreeInfo rightInfo = largestBSTSubtree(node.right);

        // Create a variable to store the current node's information
        SubtreeInfo currentInfo = new SubtreeInfo(0, 0, 0, false);

        // Check if the current subtree is a BST
        if (leftInfo.isBST && rightInfo.isBST && leftInfo.max < node.data && node.data < rightInfo.min) {
            // Update the size of the current BST
            currentInfo.size = leftInfo.size + rightInfo.size + 1;
            currentInfo.min = Math.min(node.data, leftInfo.min);
            currentInfo.max = Math.max(node.data, rightInfo.max);
            currentInfo.isBST = true;
        } else {
            // If not a BST, carry forward the maximum size found in subtrees
            currentInfo.size = Math.max(leftInfo.size, rightInfo.size);
        }

        return currentInfo;
    }
}
