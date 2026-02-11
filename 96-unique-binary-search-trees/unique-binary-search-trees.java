class Solution {
    public int numTrees(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int nodes = 2; nodes <= n; nodes++) {

            int total = 0;

            for (int root = 1; root <= nodes; root++) {
                total += dp[root - 1] * dp[nodes - root];
            }

            dp[nodes] = total;
        }

        return dp[n];
    }
}
