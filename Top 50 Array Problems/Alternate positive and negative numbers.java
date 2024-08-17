class Solution {
    void rearrange(int arr[], int n) {
        int[] pos = new int[n];
        int[] neg = new int[n];
        int posCount = 0, negCount = 0;
        
        // Separate positive and negative numbers
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                pos[posCount++] = arr[i];
            } else {
                neg[negCount++] = arr[i];
            }
        }
        
        int i = 0, j = 0, k = 0;
        
        // Arrange the array in the required order
        while (i < posCount && j < negCount) {
            arr[k++] = pos[i++];
            arr[k++] = neg[j++];
        }
        
        // Append remaining positive numbers
        while (i < posCount) {
            arr[k++] = pos[i++];
        }
        
        // Append remaining negative numbers
        while (j < negCount) {
            arr[k++] = neg[j++];
        }
    }
}
