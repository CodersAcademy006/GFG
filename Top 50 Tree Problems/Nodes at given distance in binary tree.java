class Solution {
    // Helper class to store node and its distance from target
    class NodeDistance {
        Node node;
        int distance;
        
        NodeDistance(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        // List to store the result
        ArrayList<Integer> result = new ArrayList<>();
        
        // Map to store parent references
        Map<Node, Node> parentMap = new HashMap<>();
        
        // Find the target node and populate parentMap
        Node targetNode = findTargetAndPopulateParent(root, target, parentMap);
        
        // If target node is not found, return empty result
        if (targetNode == null) {
            return result;
        }
        
        // BFS to find all nodes at distance k
        Queue<NodeDistance> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        
        queue.add(new NodeDistance(targetNode, 0));
        visited.add(targetNode);
        
        while (!queue.isEmpty()) {
            NodeDistance current = queue.poll();
            Node currentNode = current.node;
            int currentDistance = current.distance;
            
            if (currentDistance == k) {
                result.add(currentNode.data);
            }
            
            if (currentNode.left != null && !visited.contains(currentNode.left)) {
                visited.add(currentNode.left);
                queue.add(new NodeDistance(currentNode.left, currentDistance + 1));
            }
            
            if (currentNode.right != null && !visited.contains(currentNode.right)) {
                visited.add(currentNode.right);
                queue.add(new NodeDistance(currentNode.right, currentDistance + 1));
            }
            
            if (parentMap.containsKey(currentNode) && !visited.contains(parentMap.get(currentNode))) {
                visited.add(parentMap.get(currentNode));
                queue.add(new NodeDistance(parentMap.get(currentNode), currentDistance + 1));
            }
        }
        
        Collections.sort(result); // Sort the result list as required
        return result;
    }
    
    private Node findTargetAndPopulateParent(Node root, int target, Map<Node, Node> parentMap) {
        if (root == null) {
            return null;
        }
        
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
}
