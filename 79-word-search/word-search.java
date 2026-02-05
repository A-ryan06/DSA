class Solution {

    private int rows, cols;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word;
        rows = board.length;
        cols = board[0].length;

        // Pruning: frequency check
        int[] freq = new int[128];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                freq[board[i][j]]++;
            }
        }

        for (char c : word.toCharArray()) {
            if (--freq[c] < 0) return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int index) {

        if (index == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return false;
        }

        if (board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#'; // mark visited

        boolean found =
                dfs(r + 1, c, index + 1) ||
                dfs(r - 1, c, index + 1) ||
                dfs(r, c + 1, index + 1) ||
                dfs(r, c - 1, index + 1);

        board[r][c] = temp; // backtrack

        return found;
    }
}
