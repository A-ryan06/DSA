class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int k = words.length;
        int totalLen = wordLen * k;

        if (s.length() < totalLen) return result;

        // Frequency map of words
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // Try all offsets
        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset, count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (freq.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    // Too many occurrences → shrink window
                    while (window.get(word) > freq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Found valid concatenation
                    if (count == k) {
                        result.add(left);
                    }
                } else {
                    // Reset window
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}
