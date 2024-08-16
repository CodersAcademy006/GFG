class Solution {
    // Function to return a list of integers denoting the node values of both BSTs in sorted order
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        // Perform in-order traversal for both BSTs
        inOrderTraversal(root1, list1);
        inOrderTraversal(root2, list2);
        
        // Merge the two sorted lists
        return mergeSortedLists(list1, list2);
    }

    // Helper function for in-order traversal
    private void inOrderTraversal(Node node, List<Integer> list) {
        if (node == null) return;
        inOrderTraversal(node.left, list);
        list.add(node.data);
        inOrderTraversal(node.right, list);
    }

    // Helper function to merge two sorted lists
    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        
        // Merge the two lists using two pointers
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i++));
            } else {
                mergedList.add(list2.get(j++));
            }
        }
        
        // Add remaining elements from list1
        while (i < list1.size()) {
            mergedList.add(list1.get(i++));
        }
        
        // Add remaining elements from list2
        while (j < list2.size()) {
            mergedList.add(list2.get(j++));
        }
        
        return mergedList;
    }
}
