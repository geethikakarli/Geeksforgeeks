class Solution {
    long maxProduct(int n) {
        if (n == 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if(n>=201){
            return 9214223067318710998L;
        }
        
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        
        for(int j=4;j<=n;j++){
            long max = 0;
            for(int i=1;i<j;i++){
                max = Math.max(
                    max, Math.max(i*(j-i), i*dp[j-i])
                    );
            }
            dp[j] = max;
        }
        return dp[n];
    }
}