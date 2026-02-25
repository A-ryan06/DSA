class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[] dir = {-1, 0, 1};

        // First pass: mark transitions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int liveNeighbors = 0;

                for (int dx : dir) {
                    for (int dy : dir) {
                        if (dx == 0 && dy == 0) continue;

                        int x = i + dx;
                        int y = j + dy;

                        if (x >= 0 && x < m && y >= 0 && y < n &&
                           (board[x][y] == 1 || board[x][y] == -1)) {
                            liveNeighbors++;
                        }
                    }
                }

                // Apply rules
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1; // Live -> Dead
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 2; // Dead -> Live
                    }
                }
            }
        }

        // Second pass: finalize board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
}