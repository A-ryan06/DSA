class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Digit
            if (Character.isDigit(c)) {
                seenDigit = true;
            }
            // Sign
            else if (c == '+' || c == '-') {
                // Sign is valid only at start or right after exponent
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            }
            // Dot
            else if (c == '.') {
                // Dot cannot appear after exponent or twice
                if (seenDot || seenExp) return false;
                seenDot = true;
            }
            // Exponent
            else if (c == 'e' || c == 'E') {
                // Exponent must appear once and after a digit
                if (seenExp || !seenDigit) return false;
                seenExp = true;
                seenDigit = false; // must have digit after exponent
            }
            // Invalid character
            else {
                return false;
            }
        }

        return seenDigit;
    }
}
