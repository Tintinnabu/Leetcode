package top.tinn.剑指offer.Interview_13;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 13:32
 */
public class Solution {
    private int ret = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] mark = new boolean[m][n];
        dfs(m, n, k, 0, 0, mark);
        return ret;
    }

    private void dfs(int m, int n, int k, int i, int j, boolean[][] mark) {
        if (0 <= i && i < m && 0 <= j && j < n && !mark[i][j] && count(i, j) <= k){
            ret++;
            mark[i][j] = true;
            dfs(m, n, k, i+1, j, mark);
            dfs(m, n, k, i-1, j, mark);
            dfs(m, n, k, i, j+1, mark);
            dfs(m, n, k, i, j-1, mark);
        }
    }

    private int count(int i, int j) {
        int res = 0;
        while (i > 0){
            res += i % 10;
            i /= 10;
        }
        while (j > 0){
            res += j % 10;
            j /= 10;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(movingCount(16, 8, 4));
    }
}
