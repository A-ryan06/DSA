class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        long prev = 1;
        row.add(1);
        
        for (int k = 1; k <= rowIndex; k++) {
            long current = prev * (rowIndex - k + 1) / k;
            row.add((int) current);
            prev = current;
        }
        
        return row;
    }
}