class Solution {
    // Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) {
        // If the list is empty or has only one node, no duplicates are possible.
        if (head == null || head.next == null) {
            return head;
        }

        // HashSet to store the data values of the nodes
        HashSet<Integer> set = new HashSet<>();

        // Initialize pointers
        Node current = head;
        Node prev = null;

        while (current != null) {
            // If the data is already in the set, it's a duplicate
            if (set.contains(current.data)) {
                // Remove the current node by linking the previous node to the next node
                prev.next = current.next;
            } else {
                // Add the data to the set
                set.add(current.data);
                // Update prev to current
                prev = current;
            }
            // Move to the next node
            current = current.next;
        }

        // Return the modified head of the list
        return head;
    }
}
