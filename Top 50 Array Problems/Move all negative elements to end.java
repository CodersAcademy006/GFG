class Solution {
    public void segregateElements(int[] arr) {
        int n = arr.length;
        int[] positive = new int[n];
        int[] negative = new int[n];
        int posCount = 0;
        int negCount = 0;
        
        // Separate positive and negative elements
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                positive[posCount++] = arr[i];
            } else {
                negative[negCount++] = arr[i];
            }
        }
        
        // Copy positive elements back to the array
        int index = 0;
        for (int i = 0; i < posCount; i++) {
            arr[index++] = positive[i];
        }
        
        // Copy negative elements back to the array
        for (int i = 0; i < negCount; i++) {
            arr[index++] = negative[i];
        }
    }
}
