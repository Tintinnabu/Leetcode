package top.tinn.剑指offer.Interview_12;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 11:16
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (dfs(board,words,i,j,0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word,int i,int j,int k){
        if (i<0||i>=board.length||j<0||j>=board[0].length||board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i+1, j, k+1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = temp;
        return res;
    }
}
