class Solution {
    public ArrayList<Integer> ExtremeNode(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = false; // start with rightmost node
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node leftMost = null;
            Node rightMost = null;
            
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                
                if (i == 0) leftMost = current; // first node at this level
                if (i == levelSize - 1) rightMost = current; // last node at this level
                
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            
            if (!leftToRight) {
                if (rightMost != null) result.add(rightMost.data);
            } else {
                if (leftMost != null) result.add(leftMost.data);
            }
            
            leftToRight = !leftToRight; // toggle the order for the next level
        }
        
        return result;
    }
}
