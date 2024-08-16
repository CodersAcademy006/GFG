class Solution {
    // Function to find the inorder successor of the given node
    public Node inorderSuccessor(Node root, Node x) {
        if (x == null) return null;

        // Case 1: Node has a right subtree
        if (x.right != null) {
            Node successor = x.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }

        // Case 2: Node does not have a right subtree
        Node successor = null;
        Node ancestor = root;
        while (ancestor != x) {
            if (x.data < ancestor.data) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else {
                ancestor = ancestor.right;
            }
        }
        return successor;
    }
}
