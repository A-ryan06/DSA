class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] stack = new int[n + 1];   // stack of indices
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
