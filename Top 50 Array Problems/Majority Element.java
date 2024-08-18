class Solution {
    static int majorityElement(int a[], int size) {
        // Phase 1: Find the candidate for majority element
        int candidate = -1;
        int count = 0;
        
        for (int num : a) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        // Phase 2: Verify if the candidate is actually the majority element
        count = 0;
        for (int num : a) {
            if (num == candidate) {
                count++;
            }
        }
        
        // Check if candidate is majority element
        if (count > size / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}
