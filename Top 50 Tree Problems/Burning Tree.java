class Solution {

    // Method to find the target node and also to build parent map
    private Node findTarget(Node root, int target, Map<Node, Node> parentMap) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node targetNode = null;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.data == target) {
                targetNode = current;
            }

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.add(current.left);
            }

            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }

        return targetNode;
    }

    // Method to find the minimum time to burn the entire tree
    public int minTime(Node root, int target) {
        if (root == null) return 0;

        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = findTarget(root, target, parentMap);

        if (targetNode == null) return -1; // Target node not found

        // BFS to calculate the time to burn the entire tree
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if (parentMap.get(node) != null && !visited.contains(parentMap.get(node))) {
                    queue.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            time++;
        }

        return time - 1; // The time will be one more than the number of levels traversed
    }
}
