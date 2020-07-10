package top.tinn.Contest.Contest_Double_27.Problem_03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/30 22:55
 */
public class Solution {

    int[][] adjacent;
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        adjacent = new int[n][n];
        for (int[] cp : prerequisites){
            adjacent[cp[0]][cp[1]] = 1;
        }

        List<Boolean> ret = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int[] flags = new int[n];
            dfs(flags, i, i);
        }
        for (int[] query : queries){
            if (adjacent[query[0]][query[1]] == 0){
                ret.add(false);
            }else ret.add(true);
        }
        return ret;
    }

    private void dfs(int[] flags, int start, int cur) {
        if (flags[cur] == 1){
            return;
        }
        flags[cur] = 1;
        for (int j = 0; j < adjacent.length; j++){
            if (adjacent[cur][j] == 1){
                adjacent[start][j] = 1;
                dfs(flags, start, j);
            }
        }
    }

    @Test
    public void test(){
        int numCourses = 5;
        int[][] prerequisites = new int[4][2];
        prerequisites[0] = new int[]{0,1};
        prerequisites[1] = new int[]{1,2};
        prerequisites[2] = new int[]{2,3};
        prerequisites[3] = new int[]{3,4};
        int[][] queries = new int[2][2];
        queries[0] = new int[]{1, 4};
        queries[1] = new int[]{1,2};
        System.out.println(checkIfPrerequisite(numCourses, prerequisites,queries));
    }

    /**
     * if(flags[i] == 1) return false;
     *         if(flags[i] == -1) return true;
     *         flags[i] = 1;
     *         for(int j = 0; j < adjacency.length; j++) {
     *             if(adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) return false;
     *         }
     *         flags[i] = -1;
     *         return true;
     */
}
