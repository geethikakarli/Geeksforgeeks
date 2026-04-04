class Solution {
    public int totalWays(int[] arr, int target) {
        int sum = 0;
        for (int num : arr) sum += num;

    
        if ((sum + target) % 2 != 0 || Math.abs(target) > sum) {
            return 0;
        }

        int s = (sum + target) / 2;
        int[] dp = new int[s + 1];
        dp[0] = 1;

        for (int num : arr) {
            for (int j = s; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[s];
    }
}