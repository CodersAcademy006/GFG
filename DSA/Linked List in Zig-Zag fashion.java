class Solution {
    Node zigZag(Node head) {
        if (head == null || head.next == null) {
            return head; // No need to rearrange if the list is empty or has only one node
        }

        Node curr = head;
        boolean flag = true; // True indicates we want a < b, false indicates we want a > b

        while (curr.next != null) {
            if (flag) {
                // If we expect curr < curr.next but it's not the case, swap
                if (curr.data > curr.next.data) {
                    // Swap values
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            } else {
                // If we expect curr > curr.next but it's not the case, swap
                if (curr.data < curr.next.data) {
                    // Swap values
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }

            // Move to the next pair and toggle the flag
            curr = curr.next;
            flag = !flag;
        }

        return head; // Return the rearranged head of the linked list
    }
}
