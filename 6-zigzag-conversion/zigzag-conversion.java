class Solution {
    public String convert(String s, int numRows) {

        // Edge case
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Create StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        int direction = 1; // 1 = down, -1 = up

        // Traverse characters
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Change direction at boundaries
            if (currentRow == 0) {
                direction = 1;
            } else if (currentRow == numRows - 1) {
                direction = -1;
            }

            currentRow += direction;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
