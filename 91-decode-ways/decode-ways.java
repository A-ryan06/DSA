class Solution {
    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;   // first char is guaranteed not '0'

        for (int i = 2; i <= n; i++) {

            // one digit
            char one = s.charAt(i - 1);
            if (one != '0') {
                dp[i] += dp[i - 1];
            }

            // two digits
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
