import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, dict, memo);
    }

    private List<String> dfs(String s, Set<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        // If entire string is a valid word
        if (dict.contains(s)) {
            result.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);

            if (dict.contains(prefix)) {
                String suffix = s.substring(i);
                List<String> suffixWays = dfs(suffix, dict, memo);

                for (String way : suffixWays) {
                    result.add(prefix + " " + way);
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}