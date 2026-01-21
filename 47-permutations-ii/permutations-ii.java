import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Step 1: sort to handle duplicates
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Base case: full permutation formed
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip used numbers
            if (used[i]) continue;

            // Skip duplicates:
            // If current number == previous number AND previous not used,
            // then this branch would create a duplicate permutation
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore
            backtrack(nums, used, current, result);

            // Un-choose (backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
