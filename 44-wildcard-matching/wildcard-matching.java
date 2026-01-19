class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // dp[i][j] = true if first i chars of s match first j chars of p
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: empty string & empty pattern
        dp[0][0] = true;

        // Handle patterns like "*", "**", "***" that can match empty string
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '?') {
                    // Exact match or '?'
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // '*' matches empty (dp[i][j-1]) or one/more chars (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}
