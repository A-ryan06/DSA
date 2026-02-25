class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];

        // Step 1: count frequency
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        // Step 2: process characters
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            count[idx]--;

            // If already in stack, skip
            if (visited[idx]) continue;

            // Maintain lexicographical order
            while (!stack.isEmpty() &&
                   stack.peek() > c &&
                   count[stack.peek() - 'a'] > 0) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[idx] = true;
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}