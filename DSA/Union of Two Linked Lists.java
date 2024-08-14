class Solution {
    public static Node findUnion(Node head1, Node head2) {
        HashSet<Integer> set = new HashSet<>();
        
        // Traverse the first linked list and add elements to the set
        while (head1 != null) {
            set.add(head1.data);
            head1 = head1.next;
        }
        
        // Traverse the second linked list and add elements to the set
        while (head2 != null) {
            set.add(head2.data);
            head2 = head2.next;
        }
        
        // Convert the set to a list and sort it
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        
        // Create a new linked list from the sorted elements
        Node dummyHead = new Node(0); // Dummy head for ease of use
        Node current = dummyHead;
        
        for (int value : sortedList) {
            current.next = new Node(value);
            current = current.next;
        }
        
        return dummyHead.next; // Return the head of the new linked list
    }
}
