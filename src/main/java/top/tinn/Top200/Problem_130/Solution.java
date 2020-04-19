package top.tinn.Top200.Problem_130;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * @Author Tinn
 * @Date 2020/4/18 16:14
 */
public class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        if(row == 0) return;
        int column = board[0].length;
        boolean[][] mark = new boolean[row][column];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if ((i == 0 || i == row - 1)
                        && board[i][j] == 'O'
                && !mark[i][j]){
                    mark[i][j] = true;
                    dfs(board, i, j, mark);
                }
                if ((j == 0 || j == column - 1)
                    && board[i][j] == 'O'
                        && !mark[i][j]){
                    mark[i][j] = true;
                    dfs(board, i, j, mark);
                }
            }
        }
        modify(board, mark, row, column);
    }

    private void modify(char[][] board, boolean[][] mark, int row, int column) {
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++) {
                if (!mark[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int row, int column, boolean[][] mark) {
        int[] rowDirection = {1, -1, 0, 0};
        int[] colDirection = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++){
            int newRow = row + rowDirection[i];
            int newCol = column + colDirection[i];
            if (newRow >= 0 && newRow < board.length
            && newCol >= 0 && newCol < board[0].length
                    && board[newRow][newCol] == 'O'
            && !mark[newRow][newCol]){
                mark[newRow][newCol] = true;
                dfs(board, newRow, newCol, mark);
            }
        }
    }

    @Test
    public void test(){
        char[][] board = new char[3][3];
        board[0] = new char[]{'O', 'O', 'O'};
        board[1] = new char[]{'O', 'O', 'O'};
        board[2] = new char[]{'O', 'O', 'O'};
        solve(board);
    }
}
