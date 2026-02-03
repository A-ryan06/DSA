class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int max = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;
    }

    private int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] stack = new int[n + 1];
        int top = -1;
        int max = 0;

        for (int i = 0; i <= n; i++) {

            int h = (i == n) ? 0 : heights[i];

            while (top != -1 && h < heights[stack[top]]) {
                int height = heights[stack[top--]];
                int right = i;
                int left = (top == -1) ? -1 : stack[top];
                int width = right - left - 1;
                max = Math.max(max, height * width);
            }

            stack[++top] = i;
        }

        return max;
    }
}
