package top.tinn.BacktrackProblem.Problem_037;

/**
 * 37. 解数独
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 * 一个数独。
 *
 *
 *
 * 答案被标成红色。
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // box size
    int n = 3;
    // row size
    int N = n * n;

    //记录行/列/小方块中数字使用情况
    int [][] rows = new int[N][N + 1];
    int [][] columns = new int[N][N + 1];
    int [][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;
    public void solveSudoku(char[][] board) {
        this.board=board;

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                char num=board[i][j];
                if (num!='.'){
                    int d=Character.getNumericValue(num);
                    placeNumber(d,i,j);
                }
            }
        }
        backtrack(0,0);
    }

    private void placeNumber(int d, int i, int j) {
        int idx=(i/n)*n+j/n;
        rows[i][d]++;
        columns[j][d]++;
        boxes[idx][d]++;
        board[i][j]=(char)(d+'0');
    }

    private void backtrack(int i,int j){
        if (board[i][j]=='.'){
            for (int d=1;d<10;d++){
                if (couldPlace(d,i,j)){
                    placeNumber(d,i,j);
                    placeNextNumber(i,j);

                    if (!sudokuSolved) removeNumber(d,i,j);
                }
            }
        }else 
            placeNextNumber(i,j);
    }

    private void removeNumber(int d, int i, int j) {
        int idx=(i/n)*n+j/n;
        rows[i][d]--;
        columns[j][d]--;
        boxes[idx][d]--;
        board[i][j]='.';
    }

    private void placeNextNumber(int i, int j) {
        if(i==N-1&&j==N-1) sudokuSolved=true;
        else {
            if (j==N-1) backtrack(i+1,0);
            else backtrack(i,j+1);
        }
    }

    private boolean couldPlace(int d, int i, int j) {
        int idx=(i/n)*n+j/n;
        return rows[i][d]+columns[j][d]+boxes[idx][d]==0;
    }
}
