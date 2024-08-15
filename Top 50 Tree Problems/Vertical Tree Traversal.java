import java.util.*;

class Solution {
    public ArrayList<Integer> verticalOrder(Node root) {
        // A TreeMap to store the vertical order of nodes
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // Queue for level order traversal
        Queue<Pair> queue = new LinkedList<>();
        
        // Start with the root at horizontal distance 0
        queue.add(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd; // horizontal distance
            
            // Add the node to the corresponding vertical level
            if (!map.containsKey(hd)) {
                map.put(hd, new ArrayList<>());
            }
            map.get(hd).add(node.data);
            
            // Enqueue left and right children with their corresponding horizontal distances
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1)); // left child at hd - 1
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1)); // right child at hd + 1
            }
        }
        
        // Collecting the results from the TreeMap in order of vertical levels
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> verticalLevel : map.values()) {
            result.addAll(verticalLevel);
        }
        
        return result;
    }
    
    // Helper class to hold the node and its horizontal distance
    class Pair {
        Node node;
        int hd; // horizontal distance

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
