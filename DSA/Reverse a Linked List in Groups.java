class Solution {
    public static Node reverse(Node head, int k) {
        if (head == null || k <= 1) {
            return head; // No need to reverse if the list is empty or k is 1
        }

        Node current = head;
        Node prevTail = null; // To connect the reversed segments
        Node newHead = null; // The new head of the final reversed list

        while (current != null) {
            Node groupHead = current; // The head of the current group
            Node prev = null; // Previous node in the current group
            int count = 0;

            // Reverse the next k nodes
            while (current != null && count < k) {
                Node nextNode = current.next; // Store the next node
                current.next = prev; // Reverse the current node
                prev = current; // Move prev to current
                current = nextNode; // Move to the next node
                count++;
            }

            // After reversing, prev will be the new head of the reversed segment
            if (newHead == null) {
                newHead = prev; // Set the new head of the final list
            } else {
                prevTail.next = prev; // Connect the previous part with the new part
            }

            // Connect the tail of the current reversed segment to the next part
            prevTail = groupHead; // groupHead is now the last node of the reversed segment
            prevTail.next = current; // Connect it to the next segment (not reversed yet)
        }

        return newHead; // Return the new head of the reversed linked list
    }
}
