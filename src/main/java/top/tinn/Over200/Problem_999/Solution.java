package top.tinn.Over200.Problem_999;

public class Solution {
    private static final int SIZE = 8;
    public int numRookCaptures(char[][] board) {
        int[] index = findRook(board);
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int ans = 0;
        for (int direction = 0; direction < 4; direction++){
            int x = index[0] + dx[direction], y = index[1] + dy[direction];
            while (isIn(x, y) && board[x][y] == '.'){
                x += dx[direction];
                y += dy[direction];
            }
            if (isIn(x, y) && board[x][y] == 'p'){
                ans++;
            }
        }
        return ans;
    }

    private boolean isIn(int i, int j) {
        return 0 <= i && i < SIZE && 0 <= j && j <SIZE;
    }

    private int[] findRook(char[][] board) {
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (board[i][j] == 'R'){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
