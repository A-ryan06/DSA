import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        // Step 1: Create list of numbers 1..n
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        // Step 2: Precompute factorials
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        // Step 3: Convert k to 0-based index
        k--;

        // Step 4: Build permutation
        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int blockSize = fact[i - 1];
            int index = k / blockSize;

            result.append(nums.get(index));
            nums.remove(index);

            k = k % blockSize;
        }

        return result.toString();
    }
}
