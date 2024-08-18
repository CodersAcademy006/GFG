class Solution {
    ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        int i = 0;
        while (i < n - 1) {
            // Find the local minima
            while (i < n - 1 && A[i + 1] <= A[i]) {
                i++;
            }
            
            // If we reached the end, break
            if (i == n - 1) {
                break;
            }
            
            int buy = i++;
            
            // Find the local maxima
            while (i < n && A[i] >= A[i - 1]) {
                i++;
            }
            
            int sell = i - 1;
            
            // Store the buy and sell indices
            ArrayList<Integer> transaction = new ArrayList<>();
            transaction.add(buy);
            transaction.add(sell);
            result.add(transaction);
        }
        
        return result;
    }
}
