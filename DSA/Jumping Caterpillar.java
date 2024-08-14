class Solution {
    public int uneatenLeaves(int[] arr, int n) {
        // Array to mark if a leaf is eaten
        boolean[] eaten = new boolean[n + 1];
        
        // Iterate over each caterpillar's jump factor
        for (int jump : arr) {
            for (int i = jump; i <= n; i += jump) {
                eaten[i] = true;  // Mark the leaf as eaten
            }
        }
        
        // Count the number of uneaten leaves
        int uneatenCount = 0;
        for (int i = 1; i <= n; i++) {
            if (!eaten[i]) {
                uneatenCount++;
            }
        }
        
        return uneatenCount;
    }
}
