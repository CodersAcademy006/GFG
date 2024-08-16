class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
        int n = parent.length;

        // Array to hold references to nodes
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        // Create a map to track children for each node
        Map<Integer, List<Node>> childMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            childMap.put(i, new ArrayList<>());
        }

        // Populate the child map based on the parent array
        for (int i = 0; i < n; i++) {
            int parentIndex = parent[i];
            if (parentIndex != -1) {
                childMap.get(parentIndex).add(nodes[i]);
            }
        }

        // Set left and right children based on the child map
        for (Map.Entry<Integer, List<Node>> entry : childMap.entrySet()) {
            List<Node> children = entry.getValue();
            Node parentNode = nodes[entry.getKey()]; // Get the actual node object

            if (children.size() > 0) {
                parentNode.left = children.get(0);
            }
            if (children.size() > 1) {
                parentNode.right = children.get(1);
            }
        }

        // Find the root node (parent value of -1)
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                return nodes[i];
            }
        }

        return null; // This should not happen if input is valid
    }
}
