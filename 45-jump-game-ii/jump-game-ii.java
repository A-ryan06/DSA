class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            // Update the farthest we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the end of current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
