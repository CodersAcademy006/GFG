class Solution {
    // Function to construct binary tree from inorder and preorder traversals
    public static Node buildTree(int inorder[], int preorder[], int n) {
        return buildTreeUtil(inorder, preorder, 0, n - 1, 0);
    }

    // Helper function to construct the tree
    private static Node buildTreeUtil(int inorder[], int preorder[], int inStart, int inEnd, int preIndex) {
        // Base case
        if (inStart > inEnd) {
            return null;
        }

        // The current root is the next element in preorder
        Node root = new Node(preorder[preIndex]);

        // Find the index of this root in inorder
        int inIndex = search(inorder, inStart, inEnd, root.data);

        // Recursively construct the left and right subtrees
        // Left subtree
        root.left = buildTreeUtil(inorder, preorder, inStart, inIndex - 1, preIndex + 1);
        // Right subtree
        root.right = buildTreeUtil(inorder, preorder, inIndex + 1, inEnd, preIndex + (inIndex - inStart) + 1);

        return root;
    }

    // Helper function to find the index of a value in the inorder array
    private static int search(int inorder[], int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1; // This line should never be reached if the input is valid
    }
}
