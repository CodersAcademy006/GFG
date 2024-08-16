class GfG {
    
    // Helper function to find the LCA of two nodes
    private Node findLCA(Node root, int a, int b) {
        if (root == null) return null;
        
        // If root is either a or b, then root is LCA
        if (root.data == a || root.data == b) return root;
        
        // Look for LCA in left and right subtrees
        Node leftLCA = findLCA(root.left, a, b);
        Node rightLCA = findLCA(root.right, a, b);
        
        // If both left and right LCA are not null, then root is LCA
        if (leftLCA != null && rightLCA != null) return root;
        
        // Otherwise, return the non-null value
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Helper function to find the distance from a node to its ancestor
    private int findDistance(Node root, int node, int dist) {
        if (root == null) return -1;
        
        // If the current node is the target node
        if (root.data == node) return dist;
        
        // Check the left and right subtrees
        int leftDist = findDistance(root.left, node, dist + 1);
        int rightDist = findDistance(root.right, node, dist + 1);
        
        // If found in either left or right subtree
        if (leftDist != -1) return leftDist;
        if (rightDist != -1) return rightDist;
        
        return -1;
    }

    // Main function to find the distance between two nodes
    int findDist(Node root, int a, int b) {
        // Find the LCA of a and b
        Node lca = findLCA(root, a, b);
        
        // Find distance from LCA to a and b
        int distA = findDistance(lca, a, 0);
        int distB = findDistance(lca, b, 0);
        
        // The distance between a and b is the sum of distances from LCA
        return distA + distB;
    }
}
