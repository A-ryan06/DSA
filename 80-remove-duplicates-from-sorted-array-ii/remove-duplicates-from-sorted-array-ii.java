class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length <= 2) return nums.length;

        int write = 2;  // position to write next valid element

        for (int read = 2; read < nums.length; read++) {
            // allow current number only if it is not equal
            // to the element two positions before write
            if (nums[read] != nums[write - 2]) {
                nums[write] = nums[read];
                write++;
            }
        }

        return write;
    }
}
