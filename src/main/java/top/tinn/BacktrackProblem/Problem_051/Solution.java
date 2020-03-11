package top.tinn.BacktrackProblem.Problem_051;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N皇后
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    private int[] column;
    private int[] diag1;
    private int[] diag2;
    public List<List<String>> solveNQueens(int n) {
        column=new int[n];
        diag1=new int[2*n-1];
        diag2=new int[2*n-1];
        List<List<String>> result=new ArrayList<>();
        backtrack(0,n,new ArrayDeque<>(),result);
        return result;
    }

    private void backtrack(int i, int n, ArrayDeque<String> temp, List<List<String>> result){
        if (i==n){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int j=0;j<n;j++){
            if (column[j]==0&&isSafe(i,j,n)){
                column[j]++;
                diag1[i-j+n-1]++;
                diag2[i+j]++;
                char[] str=new char[n];
                Arrays.fill(str,'.');
                str[j]='Q';
                temp.add(String.valueOf(str));
                backtrack(i+1,n,temp,result);
                diag1[(i-j+n-1)]--;
                diag2[i+j]--;
                column[j]--;
                temp.removeLast();
            }
        }
    }

    private boolean isSafe(int i,int j,int n) {
        if (i==0) return true;
        if (diag1[i-j+n-1]==0&&diag2[i+j]==0) return true;
        return false;
    }


    @Test
    public void test(){
        List<List<String>> result=solveNQueens(8);
        System.out.println(result.size());
        for (List<String> list:result){
            System.out.println(list);
        }
    }
}
