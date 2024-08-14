class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        if (head == null) {
            return false; // An empty list has no loop.
        }

        Node slow = head; // Tortoise
        Node fast = head; // Hare

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by 1
            fast = fast.next.next; // Move fast by 2

            if (slow == fast) {
                return true; // There is a loop
            }
        }

        return false; // No loop found
    }
}
