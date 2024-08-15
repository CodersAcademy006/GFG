class Solution {
    public ArrayList<Integer> largestValues(Node root) {
        ArrayList<Integer> result = new ArrayList<>(); // List to store the largest values
        if (root == null) {
            return result; // If the tree is empty, return the empty list
        }

        Queue<Node> queue = new LinkedList<>(); // Queue for level order traversal
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Get the number of nodes at the current level
            int maxVal = Integer.MIN_VALUE; // Initialize max value for this level

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll(); // Dequeue the current node
                maxVal = Math.max(maxVal, currentNode.data); // Update max value

                // Add left and right children to the queue if they exist
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(maxVal); // Add the largest value of this level to the result list
        }
        
        return result; // Return the list of largest values
    }
}
