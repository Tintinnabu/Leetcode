package top.tinn.Over200.Problem_529;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: Tinn
 * @Date: 2020/8/20 9:25
 */
public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = board.length;
        int col = board[0].length;
        int clickRow = click[0];
        int clickCol = click[1];
        if (board[clickRow][clickCol] == 'M'){
            board[clickRow][clickCol] = 'X';
        } else {
            dfs(board, clickRow, clickCol);
        }
        return board;
    }

    private void dfs(char[][] board, int i, int j){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'E'){
            return;
        }
        int mines = 0;
        for (int ii = Math.max(i - 1, 0); ii < Math.min(board.length, i + 2); ii++){
            for (int jj = Math.max(j - 1, 0); jj < Math.min(board[0].length, j + 2); jj++){
                if (ii == i && jj == j){
                    continue;
                }
                if (board[ii][jj] == 'M'){
                    mines++;
                }
            }
        }
        if (mines == 0){
            board[i][j] = 'B';
            for (int ii = Math.max(i - 1, 0); ii < Math.min(board.length, i + 2); ii++){
                for (int jj = Math.max(j - 1, 0); jj < Math.min(board[0].length, j + 2); jj++){
                    if (ii == i && jj == j){
                        continue;
                    }
                    dfs(board, ii, jj);
                }
            }
        }else{
            board[i][j] = (char)('0' + mines);
        }
    }

    @Test
    public void test(){
        char[][] board = new char[4][];
        board[0] = new char[]{'E', 'E', 'E', 'E', 'E'};
        board[1] = new char[]{'E', 'E', 'M', 'E', 'E'};
        board[2] = new char[]{'E', 'E', 'E', 'E', 'E'};
        board[3] = new char[]{'E', 'E', 'E', 'E', 'E'};
        board = updateBoard(board, new int[]{3, 0});
        System.out.println(Arrays.toString(board));
    }
}
