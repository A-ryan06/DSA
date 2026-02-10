class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int parts,
                           StringBuilder current, List<String> result) {

        // If 4 parts formed
        if (parts == 4) {
            if (index == s.length()) {
                result.add(current.toString());
            }
            return;
        }

        // Try length 1 to 3
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) break;

            String part = s.substring(index, index + len);

            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0')
                break;

            int value = Integer.parseInt(part);
            if (value > 255) break;

            int beforeAddLength = current.length();

            if (parts > 0) current.append('.');
            current.append(part);

            backtrack(s, index + len, parts + 1, current, result);

            // backtrack
            current.setLength(beforeAddLength);
        }
    }
}
