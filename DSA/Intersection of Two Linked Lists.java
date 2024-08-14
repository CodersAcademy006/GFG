class Solution {
    public Node findIntersection(Node head1, Node head2) {
        // Create a set to store the values from the second linked list
        Set<Integer> set = new HashSet<>();
        
        // Traverse the second linked list and add its values to the set
        Node current = head2;
        while (current != null) {
            set.add(current.data);
            current = current.next;
        }

        // Create a dummy node to build the intersection linked list
        Node dummy = new Node(0);
        Node tail = dummy;

        // Traverse the first linked list and check for intersections
        current = head1;
        while (current != null) {
            // If the current node's value exists in the set, it's an intersection
            if (set.contains(current.data)) {
                tail.next = new Node(current.data); // Add it to the intersection list
                tail = tail.next; // Move the tail pointer
            }
            current = current.next; // Move to the next node
        }

        return dummy.next; // Return the next of dummy node as the result
    }
}
