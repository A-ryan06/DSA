class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // If we can't reach this index, return false
            if (i > maxReach) {
                return false;
            }

            // Update the farthest index we can reach
            maxReach = Math.max(maxReach, i + nums[i]);

            // If we can already reach or pass the last index
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
