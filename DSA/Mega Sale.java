class Solution {
    public int maxProfit(int m, int[] arr) {
        // Filter out useless laptops (negative prices)
        int[] uselessLaptops = Arrays.stream(arr)
                                      .filter(price -> price < 0)
                                      .toArray();
        
        // Sort the useless laptops in ascending order
        Arrays.sort(uselessLaptops);
        
        // Calculate the maximum profit by summing up the absolute values of the lowest `m` prices
        int profit = 0;
        for (int i = 0; i < Math.min(m, uselessLaptops.length); i++) {
            profit += -uselessLaptops[i]; // Adding the absolute value of the price
        }
        
        return profit;
    }
}
