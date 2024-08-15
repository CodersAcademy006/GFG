class Solution {
    private List<Integer> inorderList = new ArrayList<>();
    private int index = 0;

    // Helper function to perform inorder traversal and store the result in a list
    private void inorderTraversal(Node root) {
        if (root == null) return;
        inorderTraversal(root.left);
        inorderList.add(root.data);
        inorderTraversal(root.right);
    }

    // Helper function to convert the BST into a Max Heap
    private void convertToMaxHeap(Node root) {
        if (root == null) return;
        convertToMaxHeap(root.left);
        convertToMaxHeap(root.right);
        root.data = inorderList.get(index++);
    }

    public void convertToMaxHeapUtil(Node root) {
        inorderTraversal(root);
        convertToMaxHeap(root);
    }
}
