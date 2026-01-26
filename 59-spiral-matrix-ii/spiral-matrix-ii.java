class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {

            // Step A: Left → Right (top row)
            for (int col = left; col <= right; col++) {
                matrix[top][col] = num++;
            }
            top++;

            // Step B: Top → Bottom (right column)
            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = num++;
            }
            right--;

            // Step C: Right → Left (bottom row)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    matrix[bottom][col] = num++;
                }
                bottom--;
            }

            // Step D: Bottom → Top (left column)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    matrix[row][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }
}
