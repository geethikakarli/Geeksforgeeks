class Solution {
    public int validGroups(String s) {
        int n = s.length();

        // prefix sums
        int[] pfs = new int[n];
        pfs[0] = s.charAt(0) - '0';

        for (int i = 1; i < n; i++) {
            pfs[i] = pfs[i - 1] + (s.charAt(i) - '0');
        }

        Integer[][] dp = new Integer[n + 1][9 * n + 1];

        return solve(0, 0, s, pfs, dp);
    }

    private int solve(int cur, int prevSum, String s,
                      int[] pfs, Integer[][] dp) {

        int n = s.length();

        if (cur == n) {
            return 1;
        }

        if (dp[cur][prevSum] != null) {
            return dp[cur][prevSum];
        }

        int ans = 0;

        int prev = (cur > 0) ? pfs[cur - 1] : 0;

        for (int nxt = cur; nxt < n; nxt++) {

            int currSum = pfs[nxt] - prev;

            if (currSum >= prevSum) {
                ans += solve(nxt + 1, currSum, s, pfs, dp);
            }
        }

        return dp[cur][prevSum] = ans;
    }
}








