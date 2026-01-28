class Solution {
    public int uniquePaths(int m, int n) {
        int totalMoves = m + n - 2;
        int downMoves = m - 1;

        long res = 1;
        for (int i = 1; i <= downMoves; i++) {
            res = res * (totalMoves - downMoves + i) / i;
        }

        return (int) res;
    }
}
