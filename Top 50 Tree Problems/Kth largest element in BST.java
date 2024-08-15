class Solution {
    private int count = 0; // To keep track of the count of visited nodes
    private int result = -1; // To store the Kth largest element

    public int kthLargest(Node root, int k) {
        // Perform reverse in-order traversal
        reverseInOrderTraversal(root, k);
        return result; // Return the Kth largest element
    }

    private void reverseInOrderTraversal(Node node, int k) {
        // Base case
        if (node == null || count >= k) {
            return; // Stop if we've found K elements
        }

        // Visit the right subtree first (larger elements)
        reverseInOrderTraversal(node.right, k);
        
        // Increment the count of visited nodes
        count++;
        
        // If count is equal to K, we've found our Kth largest element
        if (count == k) {
            result = node.data; // Store the Kth largest element
            return; // No need to continue
        }

        // Visit the left subtree (smaller elements)
        reverseInOrderTraversal(node.left, k);
    }
}
