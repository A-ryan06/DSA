class Solution {

    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        if (s1.equals(s2))
            return true;

        String key = s1 + "#" + s2;
        if (memo.containsKey(key))
            return memo.get(key);

        // pruning: check character frequency
        if (!sameCharacters(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();

        for (int i = 1; i < n; i++) {

            // case 1: no swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {

                memo.put(key, true);
                return true;
            }

            // case 2: swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {

                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean sameCharacters(String a, String b) {

        int[] cnt = new int[26];

        for (int i = 0; i < a.length(); i++) {
            cnt[a.charAt(i) - 'a']++;
            cnt[b.charAt(i) - 'a']--;
        }

        for (int x : cnt)
            if (x != 0)
                return false;

        return true;
    }
}
