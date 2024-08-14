class Solution {
    Node intersectPoint(Node head1, Node head2) {
        // Step 1: Calculate lengths of both lists
        int len1 = 0, len2 = 0;
        
        Node curr1 = head1;
        Node curr2 = head2;

        while (curr1 != null) {
            len1++;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            len2++;
            curr2 = curr2.next;
        }

        // Step 2: Align the starting point
        curr1 = head1;
        curr2 = head2;

        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                curr1 = curr1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                curr2 = curr2.next;
            }
        }

        // Step 3: Traverse both lists together
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1; // Intersection point found
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return null; // No intersection
    }
}
