import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case: empty or single interval
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: List to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 3: Add the first interval
        int[] current = intervals[0];
        merged.add(current);

        // Step 4: Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // If overlapping or touching
            if (next[0] <= current[1]) {
                // Merge by updating end
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap → add new interval
                current = next;
                merged.add(current);
            }
        }

        // Step 5: Convert List to 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}
