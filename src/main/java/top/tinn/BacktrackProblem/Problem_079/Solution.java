package top.tinn.BacktrackProblem.Problem_079;

import org.junit.jupiter.api.Test;

/**
 * 79. 单词搜索
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = 'ABCCED', 返回 true.
 * 给定 word = 'SEE', 返回 true.
 * 给定 word = 'ABCB', 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private boolean result;
    private boolean[][] mark;
    public boolean exist(char[][] board, String word) {
        result=false;
        mark=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                backtrack(board,word,i,j,0);
            }
        }
        return result;
    }

    private void backtrack(char[][] board, String word,int row,int column,int k){
        if (k==word.length()) {
            result=true;
            return;
        }
        if (row<0||row>=board.length||column<0||column>=board[0].length) return;
        if (mark[row][column]) return;
        if (board[row][column]!=word.charAt(k)) return;
        else{
            mark[row][column]=true;
            backtrack(board,word,row+1,column,k+1);
            backtrack(board,word,row-1,column,k+1);
            backtrack(board,word,row,column+1,k+1);
            backtrack(board,word,row,column-1,k+1);
            mark[row][column]=false;
        }
    }

    @Test
    public void test() {
        char[][] board = new char[3][];
        board[0] = new char[]{'A', 'B', 'C', 'E'};
        board[1] = new char[]{'S', 'F', 'C', 'S'};
        board[2] = new char[]{'A', 'D', 'E', 'E'};
        exist(board,"ABCCED");
    }
}
