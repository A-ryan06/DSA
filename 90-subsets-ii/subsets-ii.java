class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);   // Step 1

        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start, int[] nums,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Step 3
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Step 4: skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 5
            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}
