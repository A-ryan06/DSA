import java.util.*;

class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {

            int lineLen = words[i].length();
            int j = i + 1;

            // pick as many words as possible
            while (j < words.length &&
                   lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }

            int wordCount = j - i;
            StringBuilder line = new StringBuilder();

            // last line OR only one word in the line
            if (j == words.length || wordCount == 1) {

                line.append(words[i]);

                for (int k = i + 1; k < j; k++) {
                    line.append(" ");
                    line.append(words[k]);
                }

                // fill remaining spaces at end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                int totalWordLength = 0;
                for (int k = i; k < j; k++) {
                    totalWordLength += words[k].length();
                }

                int totalSpaces = maxWidth - totalWordLength;
                int gaps = wordCount - 1;

                int spaceEach = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int spaces = spaceEach;
                        if (extra > 0) {
                            spaces++;
                            extra--;
                        }

                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
