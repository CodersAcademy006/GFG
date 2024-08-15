class Solution
{
    // Initialize pointers for the head and previous node of the DLL
    Node head = null;
    Node prev = null;

    // Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        // Start the conversion process
        convertToDLL(root);
        return head;
    }

    // Helper function to perform the in-order traversal and convert the tree
    void convertToDLL(Node node)
    {
        // Base case
        if (node == null) {
            return;
        }

        // Recur for the left subtree
        convertToDLL(node.left);

        // Process the current node
        if (prev == null) {
            // This means we are at the leftmost node
            head = node; // This is the head of the DLL
        } else {
            // Link the previous node and the current node
            node.left = prev; // Previous becomes the previous pointer
            prev.right = node; // Current becomes the next pointer
        }
        // Update the previous node to current
        prev = node;

        // Recur for the right subtree
        convertToDLL(node.right);
    }
}
