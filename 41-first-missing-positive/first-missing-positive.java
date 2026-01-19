class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number x at index x-1 (if in range 1..n)
        for (int i = 0; i < n; i++) {
            while (
                nums[i] >= 1 && nums[i] <= n &&
                nums[nums[i] - 1] != nums[i]
            ) {
                // Swap nums[i] with nums[nums[i] - 1]
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Step 2: Find the first index where nums[i] != i+1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all 1..n are present
        return n + 1;
    }
}
