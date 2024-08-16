class Solution {
    // Function to connect nodes at the same level
    public void connect(Node root) {
        if (root == null) return;
        
        // Initialize a queue for level-order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            
            // Process nodes at the current level
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                
                // Connect the previous node's nextRight to the current node
                if (prev != null) {
                    prev.nextRight = node;
                }
                
                // Update the previous node
                prev = node;
                
                // Add child nodes to the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            
            // The last node of each level should point to NULL
            if (prev != null) {
                prev.nextRight = null;
            }
        }
    }
}
