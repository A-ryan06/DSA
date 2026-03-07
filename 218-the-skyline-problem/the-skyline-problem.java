import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); 
            events.add(new int[]{b[1], b[2]});  
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);

        int prev = 0;

        List<List<Integer>> result = new ArrayList<>();

        for (int[] e : events) {

            int x = e[0];
            int h = e[1];

            if (h < 0)
                pq.add(-h);
            else
                pq.remove(h);

            int curr = pq.peek();

            if (curr != prev) {
                result.add(Arrays.asList(x, curr));
                prev = curr;
            }
        }

        return result;
    }
}