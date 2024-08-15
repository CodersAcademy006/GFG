class Solution {
    
    // Function to reverse the linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node addOne(Node head) {
        // Step 1: Reverse the linked list
        head = reverseList(head);

        // Step 2: Add one to the reversed list
        Node curr = head;
        int carry = 1;
        while (curr != null) {
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;

            // If carry is zero, no need to propagate further
            if (carry == 0) {
                break;
            }

            // Move to the next node
            if (curr.next == null && carry > 0) {
                curr.next = new Node(carry);
                carry = 0;
            }
            curr = curr.next;
        }

        // Step 3: Reverse the list again to restore original order
        head = reverseList(head);

        return head;
    }
}
