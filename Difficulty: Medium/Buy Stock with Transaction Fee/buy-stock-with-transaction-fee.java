class Solution {
    public int maxProfit(int[] arr, int k) {
        int n = arr.length;
        
        int hold = -arr[0]; // buying first stock
        int cash = 0;       // no stock initially
        
        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + arr[i] - k); // sell
            hold = Math.max(hold, cash - arr[i]);     // buy
        }
        
        return cash;
    }
}