class Solution {

    public int countStrings(int n, int k) {

        if (k > n - 1) return 0;

        int mod = 1000000007;

        

        // Use a flat 1D array to improve CPU cache locality

        // dp[j][0] is at dp[j * 2], dp[j][1] is at dp[j * 2 + 1]

        long[] dp = new long[(k + 1) * 2];

        dp[0] = 1; // Ends in 0

        dp[1] = 1; // Ends in 1

        

        for (int i = 2; i <= n; i++) {

            // Iterate backwards to update the DP table in place without creating a new array

            for (int j = k; j >= 0; j--) {

                int idx0 = j << 1;

                int idx1 = idx0 | 1;

                

                long prev0 = dp[idx0];

                long prev1 = dp[idx1];

                

                // If ending in 0, it can follow either a 0 or 1 from the same 'j' count

                dp[idx0] = (prev0 + prev1) % mod;

                

                // If ending in 1, it can follow a 0 from the same 'j' count,

                // or a 1 from the 'j - 1' count (which creates a new adjacent pair)

                if (j > 0) {

                    dp[idx1] = (prev0 + dp[(j - 1) << 1 | 1]) % mod;

                } else {

                    dp[idx1] = prev0;

                }

            }

        }

        

        return (int) ((dp[k << 1] + dp[k << 1 | 1]) % mod);

    }

}

 