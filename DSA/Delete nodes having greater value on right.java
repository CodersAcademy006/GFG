class Solution {
    Node compute(Node head) {
        // Reverse the linked list
        Node prev = null, current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev; // New head of the reversed list

        // Now remove nodes with greater values on the right
        Node maxNode = head;
        Node newHead = head; // This will be the new head of the modified list
        current = head.next;

        while (current != null) {
            if (current.data < maxNode.data) {
                // Skip current node
                current = current.next;
            } else {
                // Update maxNode and include current in the new list
                maxNode = current;
                newHead.next = maxNode; // Link to the new list
                newHead = newHead.next; // Move the newHead forward
                current = current.next; // Move to the next node
            }
        }

        // Terminate the new list
        newHead.next = null;

        // Reverse the modified list to restore original order
        prev = null;
        current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev; // Return the new head of the modified list
    }
}
