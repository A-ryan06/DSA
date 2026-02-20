import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start,
                           List<String> path,
                           List<List<String>> result) {

        // If we reached the end, store one partition
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {

            // Check if substring is palindrome
            if (isPalindrome(s, start, i)) {

                // Choose
                path.add(s.substring(start, i + 1));

                // Explore
                backtrack(s, i + 1, path, result);

                // Undo choice (Backtrack)
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}