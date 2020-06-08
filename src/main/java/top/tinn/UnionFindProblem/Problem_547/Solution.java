package top.tinn.UnionFindProblem.Problem_547;

import top.tinn.UnionFindProblem.UnionFind;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/6/8 10:45
 */
public class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++){
            for (int j = i + 1; j < N; j++){
                if (M[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }
}
