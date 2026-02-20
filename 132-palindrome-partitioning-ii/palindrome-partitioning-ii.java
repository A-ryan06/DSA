import java.util.*;

class Solution {

    public int minCut(String s) {
        int n = s.length();

        // dp[i] = minimum cuts for substring [0..i]
        int[] dp = new int[n];

        // palindrome table
        boolean[][] pal = new boolean[n][n];

        for (int i = 0; i < n; i++) {

            int minCuts = i; // worst case: cut every character

            for (int j = 0; j <= i; j++) {

                // Check palindrome s[j..i]
                if (s.charAt(j) == s.charAt(i) &&
                   (i - j <= 2 || pal[j + 1][i - 1])) {

                    pal[j][i] = true;

                    // If whole substring is palindrome
                    if (j == 0) {
                        minCuts = 0;
                    } else {
                        minCuts = Math.min(minCuts, dp[j - 1] + 1);
                    }
                }
            }

            dp[i] = minCuts;
        }

        return dp[n - 1];
    }
}