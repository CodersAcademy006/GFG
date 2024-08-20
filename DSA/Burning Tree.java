class Solution {
    // Map to store parent pointers
    private Map<Node, Node> parentMap = new HashMap<>();

    // Function to find the target node and build parent map
    private Node findTargetAndBuildParentMap(Node root, int target) {
        Node targetNode = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
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

    // Function to perform BFS and determine the maximum time to burn the tree
    public static int minTime(Node root, int target) {
        Solution solution = new Solution();
        Node targetNode = solution.findTargetAndBuildParentMap(root, target);

        if (targetNode == null) {
            return -1; // Target node not found
        }

        // BFS to burn the tree
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        int maxTime = 0;

        queue.add(targetNode);
        visited.add(targetNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            maxTime++;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.add(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.add(current.right);
                }
                if (solution.parentMap.containsKey(current) && !visited.contains(solution.parentMap.get(current))) {
                    visited.add(solution.parentMap.get(current));
                    queue.add(solution.parentMap.get(current));
                }
            }
        }

        return maxTime - 1; // Subtract 1 because we incremented maxTime once extra in the loop
    }
}
